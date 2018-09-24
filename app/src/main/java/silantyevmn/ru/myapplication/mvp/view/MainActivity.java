package silantyevmn.ru.myapplication.mvp.view;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import silantyevmn.ru.myapplication.R;
import silantyevmn.ru.myapplication.mvp.presenter.MainPresenter;

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
    @BindView(R.id.image)
    ImageView imageView;

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
        requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, 1);
        requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE, 2);
    }

    private void requestPermission(String permission, int requestCode) {
        ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        presenter = new MainPresenter(AndroidSchedulers.mainThread());
        //TO SOMETHING WITH PRESENTER
        return presenter;
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_convert})
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
            case R.id.btn_convert: {
                presenter.onClickConvert(this);
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

    @Override
    public void showImage(String url) {
        textView.setText(url);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_crop_original_black_24dp)
                .error(R.drawable.ic_cloud_off_black_24dp)
                .into(imageView);
    }
}
