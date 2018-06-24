package com.example.vimos.gitapp.details;

import android.view.View;

import com.example.vimos.gitapp.model.Repository;
import com.example.vimos.gitapp.model.SimpleError;
import com.example.vimos.gitapp.model.dao.UserDao;
import com.example.vimos.gitapp.network.RetrofitException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Vimos on 23/06/2018.
 */

public class UserDetailsPresenter implements UserDetailsContract.Presenter {

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
    public void setUsername(String username) {
        if (username != null) {
            this.username = username;
            loadRepos();
        }
    }

    @Override
    public void loadRepos() {

        view.setLoading(true);

        //TODO proper request to repository of Github API

        compositeDisposable.add(
                userDAO.getRepos(username)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                response -> view.setLoading(true),
                                throwable -> {
                                    view.setLoading(false);
                                    if (throwable instanceof RetrofitException) {
                                        RetrofitException e = ((RetrofitException) throwable);
                                        try {
                                            SimpleError errorMessage = e.getErrorBodyAs(SimpleError.class);
                                            Timber.i(errorMessage.getMessage());
                                        } catch (Exception exception) {
                                            Timber.e(exception);
                                        }
                                    }
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

    @Override
    public void onItemClick(Repository item, int position, View v) {

    }
}
