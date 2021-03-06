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
    private Button btnDistinct;
    private Button btnTake;
    private Button btnSkip;
    private Button btnTakeLast;
    private Button btnSkipLast;
    private Button btnFirst;
    private Button btnLast;
    private Button btnFirstOrDefault;
    private Button btnElementAt;

    private FilterPresenter presenter;

    public FilterFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        presenter = new FilterPresenter(this);

        btnFiler = (Button) view.findViewById(R.id.btnFilter);
        btnDistinct = (Button) view.findViewById(R.id.btnDistinct);
        btnSkip = (Button) view.findViewById(R.id.btnSkip);
        btnTake = (Button) view.findViewById(R.id.btnTake);
        btnTakeLast = (Button) view.findViewById(R.id.btnTakeLast);
        btnSkipLast = (Button) view.findViewById(R.id.btnSkipLast);
        btnLast = (Button) view.findViewById(R.id.btnLast);
        btnFirst = (Button) view.findViewById(R.id.btnFirst);
        btnFirstOrDefault = (Button) view.findViewById(R.id.btnFirstOrDefault);
        btnElementAt = (Button) view.findViewById(R.id.btnElement);

        btnFiler.setOnClickListener(v -> presenter.filer());
        btnDistinct.setOnClickListener(v -> presenter.distinct());
        btnTake.setOnClickListener(v -> presenter.take());
        btnSkip.setOnClickListener(v -> presenter.skip());
        btnTakeLast.setOnClickListener(v -> presenter.takeLast());
        btnSkipLast.setOnClickListener(v -> presenter.skipLast());
        btnFirst.setOnClickListener(v -> presenter.first());
        btnLast.setOnClickListener(v -> presenter.last());
        btnFirstOrDefault.setOnClickListener(v -> presenter.firstOrDefault());
        btnElementAt.setOnClickListener(v -> presenter.elementAt());
        return view;
    }

    @Override
    public void displayResult(int result) {
        Log.d("Result", result + "");
    }
}
