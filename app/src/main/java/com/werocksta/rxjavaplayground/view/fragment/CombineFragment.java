package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.werocksta.rxjavaplayground.R;

public class CombineFragment extends Fragment {


    public CombineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_combine, container, false);
        return view;
    }

}
