package silantyevmn.ru.myapplication;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.btn_one)
    Button buttonOne;
    @BindView(R.id.btn_two)
    Button buttonTwo;
    @BindView(R.id.btn_three)
    Button buttonThree;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        presenter = new MainPresenter();
        //TO SOMETHING WITH PRESENTER
        return presenter;
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three})
    public void onClick(Button button) {
        switch (button.getId()){
            case R.id.btn_one:{
                presenter.counterClickButtonOne();
                break;
            }
            case R.id.btn_two:{
                presenter.counterClickButtonTwo();
                break;
            }
            case R.id.btn_three:{
                presenter.counterClickButtonThree();
                break;
            }
        }
    }

    @Override
    public void setButtonOneText(Integer calculate) {
        buttonOne.setText(String.format(Locale.getDefault(), "%d", calculate));
    }

    @Override
    public void setButtonTwoText(Integer calculate) {
        buttonTwo.setText(String.format(Locale.getDefault(), "%d", calculate));
    }

    @Override
    public void setButtonThreeText(Integer calculate) {
        buttonThree.setText(String.format(Locale.getDefault(), "%d", calculate));
    }
}
