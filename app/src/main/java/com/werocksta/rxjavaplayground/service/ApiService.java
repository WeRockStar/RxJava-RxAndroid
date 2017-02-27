package com.werocksta.rxjavaplayground.service;

import rx.Observable;

interface ApiService {
    Observable<Void> getData();
}
