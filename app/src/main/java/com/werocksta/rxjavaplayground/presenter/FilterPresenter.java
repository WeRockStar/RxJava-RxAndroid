package com.werocksta.rxjavaplayground.presenter;

import rx.Observable;

public class FilterPresenter {

    private View view;

    public FilterPresenter(View view) {
        this.view = view;
    }

    public interface View {
        void displayResult(int result);
    }

    public void filer() {
        Observable.range(1, 6)
                .filter(n -> n % 2 == 0).subscribe(result -> view.displayResult(result));
    }

    public void distinct() {
        Observable.range(1, 9)
                .distinct()
                .take(3)
                .subscribe(u -> view.displayResult(u));
    }

    public void take() {
        Observable.range(1, 9)
                .take(3)
                .subscribe(u -> view.displayResult(u));
    }

    public void skip() {
        Observable.range(1, 9)
                .skip(3)
                .subscribe(u -> view.displayResult(u));
    }


}
