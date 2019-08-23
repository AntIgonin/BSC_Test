package ru.antigonin.bsc_test_app.ui.main_activity;

import android.util.Log;

import androidx.databinding.ObservableField;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import ru.antigonin.bsc_test_app.concurrent.AppScheduler;
import ru.antigonin.bsc_test_app.model.CurrencyModel;
import ru.antigonin.bsc_test_app.model.models_info.Currency;
import ru.antigonin.bsc_test_app.ui.base.BaseViewModel;


public class MainActivityViewModel extends BaseViewModel<MainActivityContract.View> implements MainActivityContract.ViewModel {

    CurrencyModel currencyModel;

    AppScheduler appScheduler;

    @Inject
    public MainActivityViewModel(AppScheduler appScheduler, CurrencyModel currencyModel) {
        this.currencyModel = currencyModel;
        this.appScheduler = appScheduler;
    }

    @Override
    protected void onCreated(MainActivityContract.View view) {
        super.onCreated(view);
        loadData();
    }

    private void loadData() {
        Disposable disposable = currencyModel
                .getCurrencyList()
                .subscribeOn(appScheduler.background())
                .observeOn(appScheduler.ui())
                .subscribe(this::onGetCurrencyListSuccess,this::onGetCurrencyListError);
        addDisposable(disposable);
    }

    private void onGetCurrencyListSuccess(List<Currency> list) {
        getView().setData(list);
    }

    private void onGetCurrencyListError(Throwable throwable) {
        Log.e("MainActivityViewModel", throwable.getMessage(), throwable);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
