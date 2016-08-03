package com.werocksta.rxjavaplayground.presenter;


import android.util.Log;

import rx.Observable;

public class ConditionPresenter {

    public interface View {
        void onDisplay(String result);
    }

    private View view;

    public ConditionPresenter(View view) {
        this.view = view;
    }

    public void conditionAmb() {
        Observable.amb(programming("PHP"), programming("Java"), programming("C#"))
                .subscribe(result -> Log.d("Result", result));
    }

    public void conditionTakeUtil() {
        Observable.range(1, 10)
                .takeUntil(x -> x == 5)
                .subscribe(x -> Log.d("takeUtil", x + ""));
    }

    public void conditionTakeWhile() {
        Observable.range(1, 10)
                .takeWhile(x -> x != 5)
                .subscribe(x -> Log.d("takeWhile", x + ""));
    }

    Observable<String> programming(String lang) {
        return Observable.just(lang)
                .map(l -> "Lang: " + l)
                .doOnSubscribe(() -> Log.d("Sub Lang", lang))
                .doOnUnsubscribe(() -> Log.d("Unsub", lang));
    }
}
