package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import rx.Observable;

public class BasicPresenter {

    private View view;

    public BasicPresenter(View view) {
        this.view = view;
    }

    public interface View {
        void onTextChange(String text);
    }

    public void inputText(final String text) {
        Observable.just(text).subscribe(
                view::onTextChange,
                Throwable::printStackTrace,
                this::displayLogs
        );
    }

    private int displayLogs() {
        return Log.d("Completed", "Completed");
    }
}
