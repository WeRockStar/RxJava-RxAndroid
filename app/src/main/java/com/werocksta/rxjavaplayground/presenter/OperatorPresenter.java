package com.werocksta.rxjavaplayground.presenter;

import rx.Observable;

public class OperatorPresenter {


    public interface View {
        void onDisplay(String result);
    }

    private View view;

    public OperatorPresenter(View view) {
        this.view = view;
    }

    public void operatorMap(String text) {
        Observable.just(text)
                .map(m -> m + " -> Map")
                .subscribe(result -> view.onDisplay(result));
    }

    public void operatorFlatMap(String text) {

    }

    public void operatorFilter(String text) {

    }
}
