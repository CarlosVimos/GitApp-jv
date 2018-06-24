package com.example.vimos.gitapp.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.vimos.gitapp.R;
import com.example.vimos.gitapp.RecyclerViewScrollListener;
import com.example.vimos.gitapp.details.UserDetailsActivity;
import com.example.vimos.gitapp.model.User;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vimos on 20/06/2018.
 */

public class SearchFragment extends Fragment implements SearchContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SearchContract.Presenter presenter;
    private SearchAdapter adapter;
    private RecyclerViewScrollListener scrollListener;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private RecyclerView recyclerView;
    private EditText search;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, view);


        recyclerView = view.findViewById(R.id.list_user);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        search = view.findViewById(R.id.search_user);

        adapter = new SearchAdapter();
        adapter.setOnItemClickListener(presenter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(scrollListener = new RecyclerViewScrollListener() {
            @Override
            public void onEndReached() {
                presenter.loadMore();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(this);

        swipeRefreshLayout.setOnRefreshListener(this);

            compositeDisposable.add(
                    RxTextView.textChanges(search)
                            .map(CharSequence::toString)
                            .debounce(300, TimeUnit.MILLISECONDS)
                            .distinctUntilChanged()
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.computation())
                            .subscribe(query -> {
                                presenter.setQueryFilter(query);
                                adapter.getDataSet().clear();
                            })
            );

        return view;
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showUsers(List<User> list, boolean insert) {
        if (insert) {
            adapter.notifyDataSetChanged();
            adapter.getDataSet().addAll(list);
            int insertStart = adapter.getDataSet().size();
            int size = list.size();
            adapter.notifyItemRangeInserted(insertStart, size);
        } else {
            adapter.setDataSet(list);
            adapter.notifyDataSetChanged();
        }
        scrollListener.setLoading(true);

    }


    @Override
    public void setLoading(boolean show) {
        swipeRefreshLayout.setRefreshing(show);
    }

    @Override
    public void itemClickedInfo(User user, View view) {

        UserDetailsActivity.startActivity(getActivity(), user.getLogin());
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.stop();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        compositeDisposable.clear();
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
