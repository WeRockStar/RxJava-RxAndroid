package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.presenter.FilterPresenter;

public class FilterFragment extends Fragment implements FilterPresenter.View {


    private Button btnFiler;
    private FilterPresenter presenter;

    public FilterFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        presenter = new FilterPresenter(this);

        btnFiler = (Button) view.findViewById(R.id.btnFilter);
        btnFiler.setOnClickListener(v -> presenter.filer(new int[]{1, 2, 3, 4, 5, 6}));
        return view;
    }

    @Override
    public void displayResult(int result) {
        Log.d("Result", result + "");
    }
}
