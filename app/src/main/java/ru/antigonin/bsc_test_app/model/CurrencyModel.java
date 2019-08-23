package ru.antigonin.bsc_test_app.model;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import ru.antigonin.bsc_test_app.R;
import ru.antigonin.bsc_test_app.model.models_info.Currency;

public class CurrencyModel {

    List<Currency> currencyList = new ArrayList<>();

    public CurrencyModel(){
        setUpData();
    }

    private void setUpData() {
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));
        currencyList.add(new Currency(R.drawable.ic_euro, 100));
        currencyList.add(new Currency(R.drawable.ic_dollar_symbol, 1300));
        currencyList.add(new Currency(R.drawable.ic_euro, 3300));
        currencyList.add(new Currency(R.drawable.ic_ruble, 600));

    }

    public Single<List<Currency>> getCurrencyList() {
        return Single
                .fromCallable(() -> currencyList)
                .map(this::processData);
    }

    private void swap(List<Currency> array, int ind1, int ind2) {
        Currency currency = array.get(ind1);
        array.set(ind1, array.get(ind2));
        array.set(ind2, currency);
    }

    private List<Currency> processData(List<Currency> list) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < list.size(); i++) {
               if(list.get(i - 1).name != Currency.CurrencyName.RUR && list.get(i).name == Currency.CurrencyName.RUR){
                   swap(list,i,i-1);
                   needIteration = true;
               }else if (list.get(i - 1).name != Currency.CurrencyName.RUR && list.get(i - 1).name != Currency.CurrencyName.USD &&
                         list.get(i).name == Currency.CurrencyName.USD){
                   swap(list,i,i-1);
                   needIteration = true;
               }
            }
        }

        return list;
    }

}
