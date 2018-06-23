package com.example.vimos.gitapp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Vimos on 21/06/2018.
 */

public abstract class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {

        private boolean loading = true;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (dy > 0) //check for scroll down
            {
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = manager.getChildCount();
                int totalItemCount = manager.getItemCount();
                int pastVisibleItems = manager.findFirstVisibleItemPosition();

                if (loading) {
                    if ((visibleItemCount + pastVisibleItems ) >= totalItemCount) {
                        loading = false;
                        onEndReached();
                    }
                }
            }
        }

        public void setLoading(boolean loading) {
            this.loading = loading;
        }

        public abstract void onEndReached();

}
