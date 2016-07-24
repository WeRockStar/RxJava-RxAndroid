package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class OperatorPresenter {


    public interface View {
        void onDisplay(String result);
    }

    private View view;

    public OperatorPresenter(View view) {
        this.view = view;
    }

    public void operatorMap(String text) {
        // transform the one item to another
        Observable.just(text)
                .doOnNext(l -> Log.d("text", l))
                .map(m -> m + " -> Map1")
                .doOnNext(l -> Log.d("text", l))
                .map(m -> m + " -> Map2")
                .doOnNext(l -> Log.d("text", l))
                .subscribe(result -> view.onDisplay(result));
    }

    public void operatorFlatMap(String text) {
        // flatMap them return Observable
        Observable.just(text)
                .flatMap(f -> (!f.isEmpty()) ? Observable.just(text) : Observable.empty())
                .flatMap(f -> Observable.just(f + " FlatMap"))
                .subscribe(result -> view.onDisplay(result));
    }


    public void operatorFilter(String text) {
        // return same events but skip some event they did not matching
        Observable.just(text)
                .filter(m -> m.contains("filter"))
                .filter(m -> m.contains("Filter"))
                .subscribe(result -> view.onDisplay(result));
    }

    public void operatorDelay(String text) {
        // delay run in background
        Observable.just(text)
                .map(s -> s + " delay")
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> view.onDisplay(result),
                        throwable -> Log.e("Error", throwable.getMessage()));
    }
}
