package es.ffgiraldez.hmr.android.schedulers;

import es.ffgiraldez.hmr.schedulers.SchedulerProvider;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 * @author Fernando Franco Giráldez
 */
public class AndroidSchedulerProvider implements SchedulerProvider {

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler immediate() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
