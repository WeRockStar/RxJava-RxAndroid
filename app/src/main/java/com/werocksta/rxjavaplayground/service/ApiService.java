package com.werocksta.rxjavaplayground.service;

import rx.Observable;

interface ApiService {
    <T> Observable<T> getData();
}
