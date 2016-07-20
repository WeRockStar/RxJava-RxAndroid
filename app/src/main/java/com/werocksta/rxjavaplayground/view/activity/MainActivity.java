package com.werocksta.rxjavaplayground.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.view.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        changeFragment(new MainFragment());
    }


    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainerFragment, fragment)
                .addToBackStack(null)
                .commit();

    }
}

