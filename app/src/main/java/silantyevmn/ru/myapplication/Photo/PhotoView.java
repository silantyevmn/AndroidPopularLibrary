package silantyevmn.ru.myapplication.Photo;

import java.util.List;

/**
 * Created by silan on 13.09.2018.
 */

public interface PhotoView {
    void showPhoto(Photo photo);
    void showDialogDeletePhoto(Photo photo);
    void setAdapter(List<Photo> photos);
}
