package ru.antigonin.bsc_test_app.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.antigonin.bsc_test_app.model.CurrencyModel;

@Module
public class ModelsModule {

    @Provides
    public CurrencyModel provideCurrencyModel() {
        return new CurrencyModel();
    }

}
