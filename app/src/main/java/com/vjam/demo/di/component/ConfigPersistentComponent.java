package com.vjam.demo.di.component;


import com.vjam.demo.di.ConfigPersistent;
import com.vjam.demo.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);


}
