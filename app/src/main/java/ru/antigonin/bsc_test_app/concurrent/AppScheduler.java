package ru.antigonin.bsc_test_app.concurrent;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppScheduler {

    /**
     * Return scheduler for background operations
     *
     * @return scheduler
     */
    public Scheduler background() {
        return Schedulers.computation();
    }

    /**
     * Return scheduler for network operations
     *
     * @return scheduler
     */
    public Scheduler network() {
        // TODO: 7/31/2018 think about creating custom scheduler
        return Schedulers.io();
    }

    /**
     * Return scheduler for UI operations(main thread scheduler)
     *
     * @return scheduler
     */
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}

