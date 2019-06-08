package com.meowningmaster.request.book.page.widget.types;

import com.meowningmaster.request.book.page.widget.Widget;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class TextWidget extends Widget {

    public String getText() {
        return text;
    }

    private String text;

    public TextWidget(@NotNull JSONObject json) throws JSONException {
        super();
        text = json.getString("content");
    }
}
