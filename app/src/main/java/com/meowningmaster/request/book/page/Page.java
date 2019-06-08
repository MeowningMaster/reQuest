package com.meowningmaster.request.book.page;

import com.meowningmaster.request.book.page.widget.Widgets;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class Page {
    public Widgets getWidgets() {
        return widgets;
    }

    private Widgets widgets;

    public Page(@NotNull JSONObject json) throws JSONException {
        widgets = new Widgets(json.getJSONArray("widgets"));
    }
}
