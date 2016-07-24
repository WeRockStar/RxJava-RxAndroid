package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.OperatorPresenter;

public class OperatorFragment extends Fragment implements OperatorPresenter.View {

    private OperatorPresenter presenter;
    private Button btnMap;
    private Button btnFilter;
    private Button btnFlatMap;
    private Button btnDelay;
    private EditText edtText;
    private TextView tvResult;

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
        tvResult = (TextView) view.findViewById(R.id.tvResult);
        edtText = (EditText) view.findViewById(R.id.edtText);
        btnMap = (Button) view.findViewById(R.id.btnMap);
        btnFlatMap = (Button) view.findViewById(R.id.btnFlatMap);
        btnDelay = (Button) view.findViewById(R.id.btnDelay);
        btnFilter = (Button) view.findViewById(R.id.btnFilter);


        btnMap.setOnClickListener(v -> presenter.operatorMap(edtText.getText().toString()));
        btnDelay.setOnClickListener(v -> presenter.operatorDelay(edtText.getText().toString()));
        btnFilter.setOnClickListener(v -> presenter.operatorFilter(edtText.getText().toString()));
        btnFlatMap.setOnClickListener(v -> presenter.operatorFlatMap(edtText.getText().toString()));
    }

    @Override
    public void onDisplay(String result) {
        tvResult.setText("Result : " + result);
    }
}
