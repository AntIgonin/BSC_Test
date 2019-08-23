package ru.antigonin.bsc_test_app.ui.main_activity;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ru.antigonin.bsc_test_app.base_mvvm.ViewModelKey;

@Module
public abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindMainViewModel(MainActivityViewModel userViewModel);

}
