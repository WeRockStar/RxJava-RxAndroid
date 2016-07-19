package com.werocksta.rxjavaplayground.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.view.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainerFragment, new MainFragment())
                .commit();
    }
}
