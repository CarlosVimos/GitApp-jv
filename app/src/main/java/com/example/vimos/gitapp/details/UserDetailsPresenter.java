package com.example.vimos.gitapp.details;

import android.util.Log;
import android.view.View;

import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.model.dao.UserDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Vimos on 23/06/2018.
 */

public class UserDetailsPresenter implements UserDetailsContract.Presenter {

    private static final int ON_PAGE = 10;
    private int offset = 0;
    private String username;

    private UserDao userDAO;

    private UserDetailsContract.View view;
    private CompositeDisposable compositeDisposable;

    public UserDetailsPresenter(UserDetailsContract.View view, UserDao userDAO) {
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

    }

    @Override
    public void setUsername(String username) {
        if (username != null) {
            this.username = username;
        }
    }

    @Override
    public void loadRepos() {

        view.setLoading(true);

        compositeDisposable.add(
                userDAO.getRepos(username)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                response -> {
                                    view.setLoading(false);
                             //       view.showRepos(response.getName(), true);
                               //     Timber.d("items: %s", response.getItems().size());
                                //    Log.i("SearchPresenter", "query: " + query + ", Total items of users: " + response.getItems().size());
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
