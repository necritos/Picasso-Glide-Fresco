package pe.android.tercerareunion.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Created by manu on 25/11/15.
 */
public class CategoryEntity {
    String name;
    JsonElement images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonElement getImages() {
        return images;
    }

    public void setImages(JsonElement images) {
        this.images = images;
    }

    public String getImage() {

        Gson gson = new Gson();
        ImageCategory imageCategory = gson.fromJson(images, ImageCategory.class);
        return  imageCategory.getHero();
    }
}
