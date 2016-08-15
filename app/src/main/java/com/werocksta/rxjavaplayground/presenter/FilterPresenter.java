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
                .subscribe(n -> view.displayResult(n));
    }

    public void take() {
        Observable.range(1, 9)
                .take(3)
                .subscribe(n -> view.displayResult(n));
    }

    public void skip() {
        Observable.range(1, 9)
                .skip(3)
                .subscribe(n -> view.displayResult(n));
    }

    public void takeLast() {
        Observable.range(1, 9)
                .takeLast(3)
                .subscribe(n -> view.displayResult(n));
    }

    public void skipLast() {
        Observable.range(1, 9)
                .skipLast(3)
                .subscribe(n -> view.displayResult(n));
    }

    public void first() {
        Observable.range(1, 9)
                .first()
                .subscribe(n -> view.displayResult(n));
    }

    public void last() {
        Observable.range(1, 9)
                .last()
                .subscribe(n -> view.displayResult(n));
    }

    public void firstOrDefault() {
        Observable.range(1, 9)
                .firstOrDefault(0)
                .subscribe(n -> view.displayResult(n));
    }

    public void elementAt() {
        Observable.range(1, 9)
                .elementAt(3)
                .subscribe(n -> view.displayResult(n));
    }

}
