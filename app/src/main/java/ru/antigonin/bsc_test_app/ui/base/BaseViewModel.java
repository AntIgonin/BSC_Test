package ru.antigonin.bsc_test_app.ui.base;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.io.IOException;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.antigonin.bsc_test_app.base_mvvm.MvvmView;


public class BaseViewModel<T extends MvvmView> extends ViewModel {

    CompositeDisposable compositeDisposable;

    T view;

    protected void onCreated(T view){
        this.view = view;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            // it is needed since after disposing  CompositeDisposable we can add disposables to it,
            // BUT they right away will be disposed
            compositeDisposable = new CompositeDisposable();
        } else {
            compositeDisposable = new CompositeDisposable();
        }
    }

    protected void onCreated(T view, Bundle bundle){
        onCreated(view);
    }

    protected void onResume(){

    }

    protected void onResume(T view, Bundle bundle){
        this.view = view;

    }

    protected void onResume(Bundle bundle){

    }

    protected void  onDestroy(){
        view = null;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    protected T getView(){
        return view;
    }

    protected void addDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

}
