package silantyevmn.ru.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.btn_one)
    Button buttonOne;
    @BindView(R.id.btn_two)
    Button buttonTwo;
    @BindView(R.id.btn_three)
    Button buttonThree;

    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.edit_text)
    EditText editText;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Subscription editTextSub = RxTextView.textChanges(editText).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence value) {
                textView.setText(value);
            }
        });

    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        presenter = new MainPresenter();
        //TO SOMETHING WITH PRESENTER
        return presenter;
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three})
    public void onClick(Button button) {
        switch (button.getId()) {
            case R.id.btn_one: {
                presenter.counterClickButtonOne();
                break;
            }
            case R.id.btn_two: {
                presenter.counterClickButtonTwo();
                break;
            }
            case R.id.btn_three: {
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
