package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.BasicPresenter;

public class BasicFragment extends Fragment implements BasicPresenter.View {

    private EditText edtUsername;
    private TextView tvText;
    private Button btnChange;

    BasicPresenter presenter;

    public BasicFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic, container, false);
        presenter = new BasicPresenter(this);
        initialView(view);
        return view;
    }

    private void initialView(View view) {
        edtUsername = (EditText) view.findViewById(R.id.edtUsername);
        tvText = (TextView) view.findViewById(R.id.tvText);
        btnChange = (Button) view.findViewById(R.id.btnChange);

        presenter.operatorRange();
        presenter.operatorCreate();
        presenter.cache();
        btnChange.setOnClickListener(v -> presenter.inputText(edtUsername.getText().toString()));
    }


    @Override
    public void onTextChange(String text) {
        tvText.setText(tvText.getText().toString().concat(text));
    }
}
