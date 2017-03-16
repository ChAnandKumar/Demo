package com.vjam.demo.di.component;


import com.vjam.demo.di.module.BusModule;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */
@Component(modules = BusModule.class)
@Singleton
public interface BusComponent {
    PublishSubject<String> getSubject();
}
