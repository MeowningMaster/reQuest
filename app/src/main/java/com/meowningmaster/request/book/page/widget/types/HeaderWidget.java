package com.meowningmaster.request.book.page.widget.types;

import com.meowningmaster.request.book.page.widget.Widget;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class HeaderWidget extends Widget {

    public String getText() {
        return text;
    }

    private String text;

    public HeaderWidget(@NotNull JSONObject json) throws JSONException {
        super();
        text = json.getString("content");
    }
}
