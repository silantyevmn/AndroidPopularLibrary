package silantyevmn.ru.myapplication.mvp.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Single;
import rx.schedulers.Schedulers;

public class CounterModel {
    List<Integer> counters;
    private String loadNameFile="pogoda.jpg";
    private String saveNameFile ="test";
    private String saveNameFileSuffix=".png";

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

    public Observable<Uri> convertImage(Context context) {
        return Observable.just(new String[]{saveNameFile,saveNameFileSuffix })
                .subscribeOn(Schedulers.io())
                .map(s -> createFile(s[0], s[1]))
                .map(file -> getUriConvertJpgToPng(file, context));
    }

    private Uri getUriConvertJpgToPng(File file, Context context) {
        try {
            InputStream stream = context.getAssets().open(loadNameFile);
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes.toByteArray());
            fos.close();
            return Uri.fromFile(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File createFile(String prefix, String suffix) {
        File file = null;
        try {
            file = File.createTempFile(prefix, suffix);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
