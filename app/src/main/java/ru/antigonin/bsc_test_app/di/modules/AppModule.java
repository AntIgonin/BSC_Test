package ru.antigonin.bsc_test_app.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.antigonin.bsc_test_app.MainApplication;
import ru.antigonin.bsc_test_app.concurrent.AppScheduler;


@Module
public class AppModule {

    @Provides
    @Singleton
    public static Context context(MainApplication app) {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    public AppScheduler provideAppScheduler() {
        return new AppScheduler();
    }

}
