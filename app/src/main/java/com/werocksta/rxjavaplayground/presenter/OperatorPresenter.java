package com.werocksta.rxjavaplayground.presenter;

public class OperatorPresenter {


    public interface View {
        void onDisplay(String result);
    }

    private View view;

    public OperatorPresenter(View view) {
        this.view = view;
    }

    public void operatorMap() {

    }

    public void operatorFlatMap() {

    }

    public void operatorFilter() {

    }
}
