package com.example.vimos.gitapp.details;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vimos.gitapp.BaseActivity;
import com.example.vimos.gitapp.R;
import com.example.vimos.gitapp.model.dao.UserDaoImpl;
import com.example.vimos.gitapp.search.SearchPresenter;
import com.example.vimos.gitapp.util.ActivityUtils;
import com.example.vimos.gitapp.util.Constants;

public class UserDetailsActivity extends BaseActivity {

    private String username;

    public static void startActivity(Context context,
                                     String username) {
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(Constants.USERNAME, username);

        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        username = getIntent().getExtras().getString(Constants.USERNAME);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_details,
                UserDetailsFragment.newInstance(username),
                UserDetailsFragment.class.getSimpleName());
        fragmentTransaction.commit();


    }
}
