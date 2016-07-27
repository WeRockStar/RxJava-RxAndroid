package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.CombinePresenter;

public class CombineFragment extends Fragment implements CombinePresenter.View {

    private CombinePresenter presenter;
    private Button btnZip;
    private Button btnMerge;

    public CombineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_combine, container, false);
        presenter = new CombinePresenter(this);

        intialViews(view);

        return view;
    }

    private void intialViews(View view) {
        btnMerge = (Button) view.findViewById(R.id.btnMerge);
        btnZip = (Button) view.findViewById(R.id.btnZip);

        btnZip.setOnClickListener(v -> presenter.operatorZip());
        btnMerge.setOnClickListener(v -> presenter.operatorMerge());
    }

    @Override
    public void onDisplay(String result) {

    }
}
