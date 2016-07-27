package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.CombinePresenter;

public class CombineFragment extends Fragment implements CombinePresenter.View {

    private CombinePresenter presenter;
    private Button btnZip;
    private Button btnMerge;
    private EditText edtText1;
    private EditText edtText2;

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
        edtText1 = (EditText) view.findViewById(R.id.edtText1);
        edtText2 = (EditText) view.findViewById(R.id.edtText2);

        btnZip.setOnClickListener(v -> presenter.operatorZip());
        btnMerge.setOnClickListener(v -> presenter.operatorMerge(edtText1.getText().toString(),
                edtText2.getText().toString()));
    }

    @Override
    public void onDisplay(String result) {
        Log.d("Result", result);
    }
}
