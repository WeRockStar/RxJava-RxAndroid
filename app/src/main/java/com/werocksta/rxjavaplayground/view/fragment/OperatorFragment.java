package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.OperatorPresenter;

public class OperatorFragment extends Fragment implements OperatorPresenter.View {

    private OperatorPresenter presenter;

    public OperatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operator, container, false);

        presenter = new OperatorPresenter(this);
        initialView(view);
        return view;
    }

    private void initialView(View view) {
    }

    @Override
    public void onDisplay(String result) {

    }
}
