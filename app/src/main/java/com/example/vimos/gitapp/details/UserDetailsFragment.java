package com.example.vimos.gitapp.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vimos.gitapp.R;
import com.example.vimos.gitapp.model.Repository;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.util.Constants;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Vimos on 23/06/2018.
 */

public class UserDetailsFragment extends Fragment implements UserDetailsContract.View, SwipeRefreshLayout.OnRefreshListener {

    private UserDetailsContract.Presenter presenter;

    public static UserDetailsFragment newInstance(String username) {

        Bundle args = new Bundle();
        args.putString(Constants.USERNAME, username);

        UserDetailsFragment fragment = new UserDetailsFragment();
        fragment.setArguments(args);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repos_list, container, false);

        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setUsername(getArguments().getString(Constants.USERNAME));
    }


    @Override
    public void setPresenter(UserDetailsContract.Presenter presenter) {

    }

    @Override
    public void showRepos(List<Repository> repos, boolean insert) {

    }

    @Override
    public void updateItem(int position) {

    }

    @Override
    public void updateItem(User product) {

    }

    @Override
    public void setLoading(boolean show) {

    }

    @Override
    public void onRefresh() {

    }
}
