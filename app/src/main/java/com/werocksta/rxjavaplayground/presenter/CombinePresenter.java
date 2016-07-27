package com.werocksta.rxjavaplayground.presenter;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

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

    public void operatorCombineLast() {
        Observable.combineLatest(Observable.just("1", "2", "3", "7", "8", "9"),
                Observable.just("4", "5", "6", "7", "8", "9"),
                (s, f) -> s + " : " + f).forEach(System.out::println);
    }
}
