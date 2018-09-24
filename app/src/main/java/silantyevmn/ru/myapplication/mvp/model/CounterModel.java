package silantyevmn.ru.myapplication;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Single;

public class CounterModel {
    List<Integer> counters;

    public CounterModel() {
        counters = new ArrayList<>();
        counters.add(0);
        counters.add(0);
        counters.add(0);
    }

    public Integer calculate(int index) {
        counters.set(index, counters.get(index) + 1);
        return counters.get(index);
    }

    public Single<Integer> calculateSingle(final int index) {
        return Single.fromCallable(() -> {
            counters.set(index, counters.get(index) + 1);
            return counters.get(index);
        });
    }

    public Observable<Integer> calculateObservable(int index) {
        counters.set(index, counters.get(index) + 1);
        return Observable.just(counters.get(index));
    }
}
