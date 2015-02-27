package es.ffgiraldez.hmr.schedulers;

import rx.Scheduler;
/**
 * @author Fernando Franco Giráldez
 */
public interface SchedulerProvider {

    Scheduler io();

    Scheduler immediate();

    Scheduler ui();
}
