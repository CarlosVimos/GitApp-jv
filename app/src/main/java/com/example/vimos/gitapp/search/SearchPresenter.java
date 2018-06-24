package com.example.vimos.gitapp.search;

import android.util.Log;
import android.view.View;

import com.example.vimos.gitapp.model.SimpleError;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.dao.UserDao;
import com.example.vimos.gitapp.network.RetrofitException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Vimos on 20/06/2018.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private int ON_PAGE = 1;
    private String query = "";
    private int offset = 0;

    private UserDao userDao;

    private SearchContract.View view;
    private CompositeDisposable compositeDisposable;

    public SearchPresenter(SearchContract.View view, UserDao userDAO) {
        this.view = view;
        this.view.setPresenter(this);
        this.userDao = userDAO;
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
                loadUsers(false);
            }
        }
    }

    @Override
    public void loadUsers(final boolean insert) {

        String next = "";

        if (!insert) {
            offset = 0;
            ON_PAGE = 1;
        } else {
            ON_PAGE++;
            next = String.valueOf(ON_PAGE);
        }


        view.setLoading(true);

        compositeDisposable.add(
                userDao.searchUsers(query, next)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            view.setLoading(false);
                            if (insert) {
                                offset += response.getItems().size();
                            }
                            view.showUsers(response.getItems(), true);
                            Timber.d("items: %s", response.getItems().size());

                        },
                        throwable -> {
                            Timber.d(throwable, "Cannot obtain list of users");
                            if (throwable instanceof RetrofitException) {
                                RetrofitException e = ((RetrofitException) throwable);
                                try {
                                    SimpleError errorMessage = e.getErrorBodyAs(SimpleError.class);
                                    Timber.i(errorMessage.getMessage());
                                } catch (Exception exception) {
                                    Timber.e(exception);
                                }
                            }
                            view.setLoading(false);
                        }
                )
        );
    }

    @Override
    public void loadMore() {
        loadUsers(true);
    }

    @Override
    public void stop() {

    }
}
