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

    public void filer(int[] numbers) {
        Observable.range(1, 6)
                .filter(n -> n % 2 == 0).subscribe(result -> view.displayResult(result));
    }
}
