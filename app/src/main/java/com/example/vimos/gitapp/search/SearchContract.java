package com.example.vimos.gitapp.search;

import com.example.vimos.gitapp.BasePresenter;
import com.example.vimos.gitapp.BaseView;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.util.OnViewClickListener;

import java.util.List;

/**
 * Created by Vimos on 20/06/2018.
 */

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void showUsers(List<User> users, boolean insert);

        void setLoading(boolean show);

        void itemClickedInfo(User user, android.view.View view);

    }

    interface Presenter extends BasePresenter, OnViewClickListener<User> {

        void setQueryFilter(String query);

        void loadUsers(final boolean insert);

        void loadMore();

        void stop();

    }
}
