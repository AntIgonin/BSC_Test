package ru.antigonin.bsc_test_app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import ru.antigonin.bsc_test_app.di.components.DaggerAppComponent;


public class MainApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
