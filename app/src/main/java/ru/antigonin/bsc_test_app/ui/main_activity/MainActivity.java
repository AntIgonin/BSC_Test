package ru.antigonin.bsc_test_app.ui.main_activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import ru.antigonin.bsc_test_app.R;
import ru.antigonin.bsc_test_app.databinding.ActivityMainBinding;
import ru.antigonin.bsc_test_app.model.models_info.Currency;
import ru.antigonin.bsc_test_app.ui.base.BaseActivity;


public class MainActivity extends BaseActivity implements MainActivityContract.View{

    MainActivityViewModel mainActivityViewModel;

    public ActivityMainBinding binding;

    MenuItemAdapter menuItemAdapter;

    @Inject
    protected ViewModelProvider.Factory viewModelFactory;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected View getBaseView() {
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel.class);
        setupRecyclerView();
        mainActivityViewModel.onCreated(this);
    }

    private void setupRecyclerView() {
        binding.currencyItemRv.setLayoutManager(new LinearLayoutManager(this));
        menuItemAdapter = new MenuItemAdapter();
        binding.currencyItemRv.setAdapter(menuItemAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mainActivityViewModel.onResume();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainActivityViewModel.onDestroy();
    }

    @Override
    public void setData(List<Currency> list) {
        menuItemAdapter.setData(list);
    }
}
