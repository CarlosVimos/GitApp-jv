package com.example.vimos.gitapp.search;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vimos.gitapp.R;
import com.example.vimos.gitapp.model.User;
import com.example.vimos.gitapp.util.OnViewClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vimos on 21/06/2018.
 */

public class SearchHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.username_id)
    TextView username;
    private View itemUserLayout;

    protected User user;
    protected OnViewClickListener<User> onItemClickListener;

    public SearchHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemUserLayout = itemView.findViewById(R.id.content);

    }

    public void bind(OnViewClickListener<User> onItemClickListener, User user) {
        this.onItemClickListener = onItemClickListener;
        this.user = user;

        username.setText(user.getLogin());
        itemUserLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(user, getAdapterPosition(), view);
            }
        });
    }

    @OnClick(R.id.content)
    void onItemClick(View v) {

    }

}
