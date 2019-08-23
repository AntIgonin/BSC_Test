package ru.antigonin.bsc_test_app.model.models_info;

import ru.antigonin.bsc_test_app.R;

public class Currency{

    public enum CurrencyName {
        RUR,
        USD,
        EUR
    }


    public Currency(int imageRes, int sum){
        this.imageRes = imageRes;

        switch (imageRes){
            case R.drawable.ic_ruble:
                name = CurrencyName.RUR;
                break;
            case R.drawable.ic_dollar_symbol:
                name = CurrencyName.USD;
                break;
            case R.drawable.ic_euro:
                name = CurrencyName.EUR;
                break;
        }

        this.sum = sum;
    }

    public int imageRes;

    public CurrencyName name;

    public int sum;

}
