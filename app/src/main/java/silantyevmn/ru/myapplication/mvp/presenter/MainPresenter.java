package silantyevmn.ru.myapplication.mvp.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import rx.Scheduler;
import rx.schedulers.Schedulers;
import silantyevmn.ru.myapplication.mvp.model.CounterModel;
import silantyevmn.ru.myapplication.mvp.view.MainView;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private CounterModel model;
    private final Scheduler mainScheduler;

    public MainPresenter(@NonNull Scheduler mainScheduler) {
        this.mainScheduler = mainScheduler;
        this.model = new CounterModel();
    }


    public void counterClickButtonOne() {
        model.calculateObservable(0)
                .subscribeOn(Schedulers.computation())
                .observeOn(mainScheduler)
                .subscribe(integer -> getViewState().setButtonOneText(integer));
    }


    public void counterClickButtonTwo() {
        model.calculateObservable(1)
                .subscribeOn(Schedulers.computation())
                .observeOn(mainScheduler)
                .subscribe(integer -> getViewState().setButtonTwoText(integer));
    }

    public void counterClickButtonThree() {
        model.calculateObservable(2)
                .subscribeOn(Schedulers.computation())
                .observeOn(mainScheduler)
                .subscribe(integer -> getViewState().setButtonThreeText(integer));
    }
}
