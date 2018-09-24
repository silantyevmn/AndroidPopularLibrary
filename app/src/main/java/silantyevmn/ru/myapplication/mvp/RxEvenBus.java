package silantyevmn.ru.myapplication.mvp;

import rx.Observable;
import rx.subjects.PublishSubject;


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
