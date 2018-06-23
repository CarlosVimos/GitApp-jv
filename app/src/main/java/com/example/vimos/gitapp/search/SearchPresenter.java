package com.example.vimos.gitapp.search;

import android.util.Log;
import android.view.View;

import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.dao.UserDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Vimos on 20/06/2018.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private static final int ON_PAGE = 10;
    private String query = "";
    private int offset = 0;

    private UserDao userDAO;

    private SearchContract.View view;
    private CompositeDisposable compositeDisposable;

    public SearchPresenter(SearchContract.View view, UserDao userDAO) {
        this.view = view;
        this.view.setPresenter(this);
        this.userDAO = userDAO;
    }

    @Override
    public void start() {
        compositeDisposable = new CompositeDisposable();

    }

    @Override
    public void onItemClick(User item, int position, View v) {

        view.itemClickedInfo(item, v);

    }

    @Override
    public void setQueryFilter(String query) {
        if(query != null) {
            this.query = query;
            if (query.trim().length() > 2) {
                loadUsers();
            }
        }
    }

    @Override
    public void loadUsers() {

        view.setLoading(true);

        compositeDisposable.add(
                userDAO.searchUsers(query)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            view.setLoading(false);
                            view.showUsers(response.getItems(), true);
                            Timber.d("items: %s", response.getItems().size());
                            Log.i("SearchPresenter", "query: " + query + ", Total items of users: " + response.getItems().size());
                        },
                        throwable -> {
                            Timber.d(throwable, "Cannot obtain list of users");
                            view.setLoading(false);
                        }
                )
        );
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void stop() {

    }
}
