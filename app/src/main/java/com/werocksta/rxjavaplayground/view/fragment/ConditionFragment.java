package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.ConditionPresenter;

public class ConditionFragment extends Fragment implements ConditionPresenter.View {

    private Button btnAmb;
    private Button btnTakeWhile;
    private Button btnTakeUtil;

    private ConditionPresenter presenter;

    public ConditionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_condition, container, false);
        presenter = new ConditionPresenter(this);
        initialViews(view);
        return view;
    }

    private void initialViews(View view) {
        btnAmb = (Button) view.findViewById(R.id.btnAmb);
        btnTakeUtil = (Button) view.findViewById(R.id.btnTakeUtil);
        btnTakeWhile = (Button) view.findViewById(R.id.btnTakeWhile);

        btnAmb.setOnClickListener(v -> presenter.conditionAmb());
    }

    @Override
    public void onDisplay(String result) {

    }
}
