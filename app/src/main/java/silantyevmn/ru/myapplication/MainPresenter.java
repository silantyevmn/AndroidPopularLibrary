package silantyevmn.ru.myapplication;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>
{
    CounterModel model;

    public MainPresenter()
    {
        this.model = new CounterModel();
    }


    public void counterClickButtonOne() {
        getViewState().setButtonOneText(model.calculate(0));
    }


    public void counterClickButtonTwo() {
        getViewState().setButtonTwoText(model.calculate(1));
    }

    public void counterClickButtonThree() {
        getViewState().setButtonThreeText(model.calculate(2));
    }
}
