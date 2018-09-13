package silantyevmn.ru.myapplication.Photo;

import java.util.List;

/**
 * Created by silan on 13.09.2018.
 */

public interface PhotoModel {
    void savePhoto(Photo photo);

    void savePhotoFavorite(Photo photo);

    List<Photo> getListPhoto();

    List<Photo> getListPhotoFavorite();

    Photo getPhotoByName(String name);

    void setPhoto(Photo photo);
}
