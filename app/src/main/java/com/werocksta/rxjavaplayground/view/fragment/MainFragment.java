package com.werocksta.rxjavaplayground.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.werocksta.rxjavaplayground.R;
import com.werocksta.rxjavaplayground.view.activity.MainActivity;

public class MainFragment extends Fragment {

    private Button btnBasic;
    private Button btnOperator;
    private Button btnRetrofit;
    private Button btnCombine;
    private Button btnCondition;
    private Button btnFilter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initialViews(view);
        return view;
    }

    private void initialViews(View view) {
        btnBasic = (Button) view.findViewById(R.id.btnBasic);
        btnCombine = (Button) view.findViewById(R.id.btnCombineOperator);
        btnOperator = (Button) view.findViewById(R.id.btnBasicOperator);
        btnRetrofit = (Button) view.findViewById(R.id.btnRetrofit);
        btnCondition = (Button) view.findViewById(R.id.btnCondition);
        btnFilter = (Button) view.findViewById(R.id.btnFilter);

        btnOperator.setOnClickListener(v -> ((MainActivity) getActivity()).changeFragment(new OperatorFragment(), true));
        btnCondition.setOnClickListener(v -> ((MainActivity) getActivity()).changeFragment(new ConditionFragment(), true));
        btnBasic.setOnClickListener(v -> ((MainActivity) getActivity()).changeFragment(new BasicFragment(), true));
        btnCombine.setOnClickListener(v -> ((MainActivity) getActivity()).changeFragment(new CombineFragment(), true));
        btnFilter.setOnClickListener(v -> ((MainActivity) getActivity()).changeFragment(new FilterFragment(), true));
    }


}
