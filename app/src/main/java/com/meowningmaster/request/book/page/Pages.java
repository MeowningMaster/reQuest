package com.meowningmaster.request.book.page;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Pages {
    public Page get(String id) {
        return pages.get(id);
    }

    private Map<String, Page> pages;

    public Pages(@NotNull JSONObject json) throws JSONException {
        pages = new HashMap<>();

        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject value = json.getJSONObject(key);
            pages.put(key, new Page(value));
        }
    }
}
