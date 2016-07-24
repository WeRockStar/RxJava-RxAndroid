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
        // return same events but skip some event they did not matching
        Observable.just(text)
                .filter(m -> m.contains("filter"))
                .subscribe(result -> view.onDisplay(result));
    }
}
