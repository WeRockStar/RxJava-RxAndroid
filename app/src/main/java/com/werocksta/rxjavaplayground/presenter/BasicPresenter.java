package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

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

    private void log(Object msg) {
        Log.d("Thread", Thread.currentThread().getName() + ": " + msg);
    }

    public void operatorRange() {
        Observable.range(5, 10)
                .subscribe(this::log);
    }

    public void operatorCreate() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                for (int i = 1; i < 10; i++)
                    subscriber.onNext("create : " + i);
                subscriber.onCompleted();
                subscriber.unsubscribe();
            }
        }).cache().subscribeOn(Schedulers.newThread()).subscribe(this::log);
    }

    public void cache() {
        Observable<String> sampleCache = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Log.d("Create", "Create");
                subscriber.onNext("Love");
                subscriber.onCompleted();
            }
        }).cache();

        sampleCache.subscribe(i -> Log.d("Cache", i));
        sampleCache.subscribe(i -> Log.d("Cache", i));
    }


    public <T> Observable<T> just(T x) {
        /*
        .create() in fact you can build all of already discover factory methods on top of other operator ha ha!
         */
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onCompleted();
        });
    }

    public <T> Observable<T> error(T x) {
        /*
        .create() in fact you can build all of already discover factory methods on top of other operator ha ha!
         */
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onCompleted();
        });
    }

    public <T> Observable<String> empty(T x) {
        /*
        .create() in fact you can build all of already discover factory methods on top of other operator ha ha!
         */
        return Observable.create(subscriber -> {
            subscriber.onNext("");
            subscriber.onCompleted();
        });
    }
}
