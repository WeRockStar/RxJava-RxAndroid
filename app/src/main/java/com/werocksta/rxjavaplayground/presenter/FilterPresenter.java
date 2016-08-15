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
        Observable.just(1, 9, 2, 3, 4, 1, 1, 2, 3)
                .distinct()
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

    public void takeLast() {
        Observable.range(1, 9)
                .takeLast(3)
                .subscribe(u -> view.displayResult(u));
    }

    public void skipLast() {
        Observable.range(1, 9)
                .skipLast(3)
                .subscribe(u -> view.displayResult(u));
    }

    public void first() {
        Observable.range(1, 9)
                .first()
                .subscribe(u -> view.displayResult(u));
    }

    public void last() {
        Observable.range(1, 9)
                .last()
                .subscribe(u -> view.displayResult(u));
    }

    public void firstOrDefault() {
        Observable.range(1, 9)
                .firstOrDefault(0)
                .subscribe(u -> view.displayResult(u));
    }

}
