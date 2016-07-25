package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.CombinePresenter;

public class CombineFragment extends Fragment implements CombinePresenter.View {

    private CombinePresenter presenter;

    public CombineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_combine, container, false);
        presenter = new CombinePresenter(this);
        return view;
    }

    @Override
    public void onDisplay(String result) {

    }
}
