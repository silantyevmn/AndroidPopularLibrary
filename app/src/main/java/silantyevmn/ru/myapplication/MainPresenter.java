package silantyevmn.ru.myapplication;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private CounterModel model;

    public MainPresenter() {
        this.model = new CounterModel();
    }


    public void counterClickButtonOne() {
        Observable.just(0)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(integer -> model.calculate(integer))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> getViewState().setButtonOneText(integer));
        //model.calculateSingle(0).subscribe(integer -> getViewState().setButtonOneText(integer));
        //getViewState().setButtonOneText(model.calculate(0));
    }


    public void counterClickButtonTwo() {
        Observable.just(1)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(integer -> model.calculate(integer))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> getViewState().setButtonTwoText(integer));
        //getViewState().setButtonTwoText(model.calculate(1));
    }

    public void counterClickButtonThree() {
        Observable.just(2)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(integer -> model.calculate(integer))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> getViewState().setButtonThreeText(integer));
        //getViewState().setButtonThreeText(model.calculate(2));
    }
}
