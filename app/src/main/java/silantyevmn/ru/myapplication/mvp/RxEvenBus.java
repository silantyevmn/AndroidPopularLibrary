package silantyevmn.ru.myapplication;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by silan on 24.09.2018.
 */

public class RxEvenBus {
    private final PublishSubject subject;

    public RxEvenBus() {
        this.subject = PublishSubject.create();
    }

    public void send(Object o){
        subject.onNext(o);
    }

    public Observable<Object> toObservable(){
        return subject;
    }
}
