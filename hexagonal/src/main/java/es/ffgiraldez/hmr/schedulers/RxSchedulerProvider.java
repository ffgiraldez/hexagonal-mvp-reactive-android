package es.ffgiraldez.hmr.schedulers;

import rx.Scheduler;
import rx.schedulers.Schedulers;
/**
 * @author Fernando Franco Giráldez
 */
public class RxSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler immediate() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler ui() {
        return immediate();
    }
}
