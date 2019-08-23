package ru.antigonin.bsc_test_app.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ru.antigonin.bsc_test_app.di.scopes.PerActivity;
import ru.antigonin.bsc_test_app.ui.main_activity.MainActivity;
import ru.antigonin.bsc_test_app.ui.main_activity.MainModule;


@Module
public abstract class BindingModule {

    @PerActivity
    @ContributesAndroidInjector(
            modules = {
                MainModule.class,
            })
    abstract MainActivity provideMainActivity();

}
