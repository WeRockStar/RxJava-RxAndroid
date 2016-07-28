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
        Observable.amb(programming("PHP"), programming("Java"))
                .subscribe(result -> Log.d("Result", result));
    }

    Observable<String> programming(String lang) {
        return Observable.just(lang)
                .map(l -> "Lang: " + l)
                .doOnSubscribe(() -> Log.d("Sub Lang", lang))
                .doOnUnsubscribe(() -> Log.d("Unsub", lang));
    }
}
