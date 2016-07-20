package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class BasicPresenter {

    private View view;

    public BasicPresenter(View view) {
        this.view = view;
    }

    public interface View {
        void onTextChange(String text);
    }

    public Subscription inputText(final String text) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(text);
                subscriber.onCompleted();
            }
        }).subscribe(
                message -> view.onTextChange(message),
                throwable -> Log.e("Error", throwable.getMessage()),
                () -> Log.d("Completed", "Completed")
        );
    }
}
