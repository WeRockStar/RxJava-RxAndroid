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
    private Button btnZip;
    private Button btnRetrofit;

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
        btnZip = (Button) view.findViewById(R.id.btnZip);
        btnRetrofit = (Button) view.findViewById(R.id.btnRetrofit);

        btnBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeFragment(new BasicFragment());
            }
        });
    }


}
