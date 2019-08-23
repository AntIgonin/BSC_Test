package ru.antigonin.bsc_test_app.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import ru.antigonin.bsc_test_app.base_mvvm.BaseView;


public abstract class BaseActivity extends DaggerAppCompatActivity implements BaseView {


    protected abstract View getBaseView();

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onStart() {
        super.onStart();

    }

}
