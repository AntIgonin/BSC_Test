package ru.antigonin.bsc_test_app.ui.main_activity;


import java.util.List;

import ru.antigonin.bsc_test_app.base_mvvm.BaseView;
import ru.antigonin.bsc_test_app.base_mvvm.MvvmModel;
import ru.antigonin.bsc_test_app.model.models_info.Currency;

public interface MainActivityContract {

    interface View extends BaseView {
        void setData(List<Currency> list);
    }

    interface ViewModel extends MvvmModel<View> {

    }


}
