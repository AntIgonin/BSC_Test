package ru.antigonin.bsc_test_app.di.modules;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import ru.antigonin.bsc_test_app.di.factory.ViewModelFactory;


@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
