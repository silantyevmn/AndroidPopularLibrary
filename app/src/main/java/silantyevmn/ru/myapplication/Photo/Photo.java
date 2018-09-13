package silantyevmn.ru.myapplication.Photo;

/**
 * Created by silan on 13.09.2018.
 */

public class Photo {
    private String name; //имя фото
    private boolean isFavorite; //фото ибранное
    private String uriString; //uri photo строковое
    protected enum TypeFile{ //откуда загружено фото
        camera,
        localSD,
        network,
        vk,
        insagram
    }
    private TypeFile currentType;

    public Photo(String name, boolean isFavorite, String uriString) {
        this.name = name;
        this.isFavorite = isFavorite;
        this.uriString = uriString;
    }

    public TypeFile getCurrentType() {
        return currentType;
    }

    public void setCurrentType(TypeFile currentType) {
        this.currentType = currentType;
    }

    public String getName() {
        return name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getUriString() {
        return uriString;
    }
}
