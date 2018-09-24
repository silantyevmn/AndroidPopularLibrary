package silantyevmn.ru.myapplication.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void setButtonOneText(Integer calculate);

    void setButtonTwoText(Integer calculate);

    void setButtonThreeText(Integer calculate);

    void showImage(String url);
}
