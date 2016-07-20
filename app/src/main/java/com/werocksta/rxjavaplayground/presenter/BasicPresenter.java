package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import rx.Observable;
import rx.Observer;
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

    /**
     * Subscription
     */
    public void inputText2(final String text) {
        Subscription s = Observable.just(text).subscribe(
                view::onTextChange,
                Throwable::printStackTrace,
                this::displayLogs
        );


        // unsubscribe avoid memory leak
        s.unsubscribe();
    }

    /**
     * Subscriber
     */
    public void inputText3(final String text) {
        Observable.just(text)
                .subscribe(
                        new Subscriber<String>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(String s) {
                                // unsubscribe avoid memory leak
                                if (s.equals("unsubscribe"))
                                    unsubscribe();
                            }
                        }
                );
    }
}
