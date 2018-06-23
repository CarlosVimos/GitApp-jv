package com.example.vimos.gitapp.details;

import com.example.vimos.gitapp.BasePresenter;
import com.example.vimos.gitapp.BaseView;
import com.example.vimos.gitapp.model.Repository;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.util.OnViewClickListener;

import java.util.List;

/**
 * Created by Vimos on 23/06/2018.
 */

public interface UserDetailsContract {

    interface View extends BaseView<UserDetailsContract.Presenter> {

        void showRepos(List<Repository> repos, boolean insert);

        void updateItem(int position);

        void updateItem(User product);

        void setLoading(boolean show);

    }

    interface Presenter extends BasePresenter, OnViewClickListener<User> {

        void setUsername(String username);

        void loadRepos();

        void loadMore();

        void stop();

    }
}
