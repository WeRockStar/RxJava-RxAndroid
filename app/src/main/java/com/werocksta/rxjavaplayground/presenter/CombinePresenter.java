package com.werocksta.rxjavaplayground.presenter;

public class CombinePresenter {

    private View view;

    public CombinePresenter(View view) {
        this.view = view;
    }

    public interface View {
        void onDisplay(String result);
    }

    public void operatorZip() {

    }

    public void operatorMerge() {

    }
}
