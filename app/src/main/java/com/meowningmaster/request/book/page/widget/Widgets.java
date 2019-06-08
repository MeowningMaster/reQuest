package com.meowningmaster.request.book.page.widget;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Widgets {
    public Widget get(int i) {
        return widgets.get(i);
    }

    public int count() {
        return widgets.size();
    }

    ArrayList<Widget> widgets;

    public Widgets(@NotNull JSONArray json) throws JSONException {
        widgets = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            widgets.add(Widget.parse(json.getJSONObject(i)));
        }
    }
}
