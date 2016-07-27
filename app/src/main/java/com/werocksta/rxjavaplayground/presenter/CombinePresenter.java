package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class CombinePresenter {

    private View view;

    public CombinePresenter(View view) {
        this.view = view;
    }

    public interface View {
        void onDisplay(String result);
    }

    public void operatorZip() {
        Observable<Long> red = Observable.interval(10, TimeUnit.MICROSECONDS);
        Observable<Long> greed = Observable.interval(10, TimeUnit.MICROSECONDS);

        Observable.zip(red.timestamp(), greed.timestamp(),
                (r, g) -> r.getTimestampMillis() - g.getTimestampMillis()
        ).forEach(result -> Log.d("Zip", result.toString()));
    }

    public void operatorMerge() {

    }
}
