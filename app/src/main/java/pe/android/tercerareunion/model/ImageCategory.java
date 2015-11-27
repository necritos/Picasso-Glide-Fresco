package pe.android.tercerareunion.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by manu on 25/11/15.
 */
public class ImageCategory {
    JsonElement hero;
    JsonElement logo_medium;
    JsonElement medium;
    JsonElement small;

    public String getHero() {
        JsonObject jsonElement = this.hero.getAsJsonObject();
        if(jsonElement!=null) {
            JsonElement jpg = jsonElement.get("jpg");
            if (!jpg.isJsonNull())
                return jpg.getAsString();
            else
                return "";
        }
        else
            return "";
    }
    public String getLogo_medium() {
        JsonObject jsonElement = this.logo_medium.getAsJsonObject();
        if(!jsonElement.isJsonNull()) {
            JsonElement jpg = jsonElement.get("jpg");
            if (!jpg.isJsonNull())
                return jpg.getAsString();
            else
                return "";
        }
        else
            return "";
    }
    public String getMedium() {
        JsonObject jsonElement = this.medium.getAsJsonObject();
        if(!jsonElement.isJsonNull()) {
            JsonElement jpg = jsonElement.get("jpg");
            if (!jpg.isJsonNull())
                return jpg.getAsString();
            else
                return "";
        }
        else
            return "";
    }
    public String getSmall() {
        JsonObject jsonElement = this.small.getAsJsonObject();
        if(!jsonElement.isJsonNull()) {
            JsonElement jpg = jsonElement.get("jpg");
            if (!jpg.isJsonNull())
                return jpg.getAsString();
            else
                return "";
        }
        else
            return "";
    }

}
