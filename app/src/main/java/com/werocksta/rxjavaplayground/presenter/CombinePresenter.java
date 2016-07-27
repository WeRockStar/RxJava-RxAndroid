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

    public void operatorMerge(String text1, String text2) {
        Observable<String> red = Observable.just(text1);
        Observable<String> greed = Observable.just(text2);

        Observable.merge(red, greed)
                .subscribe(
                        result -> view.onDisplay(result)
                );
    }
}
