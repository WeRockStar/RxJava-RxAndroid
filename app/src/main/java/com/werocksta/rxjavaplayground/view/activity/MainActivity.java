package com.werocksta.rxjavaplayground.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.view.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFragment(new MainFragment(), false);
    }

    public void changeFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (addBackStack)
            transaction.replace(R.id.contentContainerFragment, fragment)
                    .addToBackStack(null)
                    .commit();
        else
            transaction.replace(R.id.contentContainerFragment, fragment)
                    .commit();

    }
}

