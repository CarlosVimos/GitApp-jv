package com.example.vimos.gitapp.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vimos.gitapp.R;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.util.OnViewClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by Vimos on 21/06/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchHolder> {

    private List<User> dataSet;
    private OnViewClickListener<User> onItemClickListener;

    public SearchAdapter() {
        this.dataSet = new ArrayList<>(0);
    }

    @Override
    public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SearchHolder(inflater.inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchHolder holder, int position) {
        holder.bind(onItemClickListener, dataSet.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        if (dataSet != null) {
            return dataSet.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnViewClickListener<User> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public List<User> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<User> dataSet) {
        this.dataSet = dataSet;
    }


}
