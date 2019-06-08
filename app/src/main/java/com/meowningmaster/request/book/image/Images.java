package com.meowningmaster.request.book.image;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Images {
    public Image get(String id) {
        return images.get(id);
    }

    private Map<String, Image> images;

    public Images(@NotNull JSONObject json) throws JSONException {
        images = new HashMap<>();

        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = json.getString(key);
            images.put(key, new Image(value));
        }
    }
}
