package ru.antigonin.bsc_test_app.di.components;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import ru.antigonin.bsc_test_app.MainApplication;
import ru.antigonin.bsc_test_app.di.modules.AppModule;
import ru.antigonin.bsc_test_app.di.modules.BindingModule;
import ru.antigonin.bsc_test_app.di.modules.ModelsModule;
import ru.antigonin.bsc_test_app.di.modules.ViewModelModule;


@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                BindingModule.class,
                ViewModelModule.class,
                ModelsModule.class
            })
@Singleton
public interface AppComponent extends AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MainApplication> {}
}
