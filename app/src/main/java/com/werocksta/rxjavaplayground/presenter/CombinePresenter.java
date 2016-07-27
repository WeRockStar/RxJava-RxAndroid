package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class CombinePresenter {

    private View view;

    public CombinePresenter(View view) {
        this.view = view;
    }

    public interface View {
        void onDisplay(String result);
    }

    public void operatorZip() {
        Observable<String> red = Observable.just("RED");
        Observable<String> greed = Observable.just("GREEN");

        Observable.zip(red, greed, (r, g) -> r + g)
                .observeOn(AndroidSchedulers.mainThread()).forEach(aLong -> Log.d("Zip", "Zip : " + aLong));
    }

    public void operatorMerge() {
        Observable<String> red = Observable.just("RED");
        Observable<String> greed = Observable.just("GREEN");

        Observable.merge(red, greed)
                .subscribe(
                        result -> Log.d("Merge", "Merge : " + result)
                );
    }
}
