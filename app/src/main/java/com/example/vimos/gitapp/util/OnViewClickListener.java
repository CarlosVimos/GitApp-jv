package com.example.vimos.gitapp.util;

import android.view.View;

/**
 * Created by Vimos on 21/06/2018.
 */

public interface OnViewClickListener<T> {

    void onItemClick(T item, int position, View v);

}
