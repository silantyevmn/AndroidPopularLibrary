package silantyevmn.ru.myapplication.Photo;

import java.util.List;

/**
 * Created by silan on 13.09.2018.
 */

public interface PhotoPresenter {
    void importCamera(String uriString);
    void importGalery(String uriString);
    void importNetwork(String uriString);

    void onClickPhoto(Photo photo);
    void onClickDeletePhoto(Photo photo);
    void onClickFavoritePhoto(Photo photo);

}
