package es.ffgiraldez.hmr.executors;

import android.util.Log;

import java.lang.ref.WeakReference;

import rx.Observer;
import rx.exceptions.OnErrorNotImplementedException;

/**
 * @author Fernando Franco Giráldez
 */
public class CompletedObserverRequestListener<T> implements RequestListener<T> {
    // ----------------------------------
    // CONSTANTS
    // ----------------------------------
    private static final String TAG = CompletedObserverRequestListener.class.getSimpleName();

    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final WeakReference<Observer<T>> reference;

    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    public CompletedObserverRequestListener(Observer<T> subject) {
        reference = new WeakReference<>(subject);
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public void onSuccess(T result) {
        Observer<T> subject = reference.get();
        if (subject != null) {
            subject.onNext(result);
            subject.onCompleted();
        } else {
            Log.e(TAG, "onSuccess without reference with result:" + result);
        }
    }

    @Override
    public void onFailure(RequestException exception) {
        Observer<T> subject = reference.get();
        if (subject != null) {
            try {
                subject.onError(exception.getCause());
            }catch (OnErrorNotImplementedException error) {
                Log.e(TAG, "ignore error call", error);
            }
        } else {
            Log.e(TAG, "onFailure without reference");
        }
    }
}
