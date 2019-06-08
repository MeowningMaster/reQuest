package com.meowningmaster.request.book.page.widget.types;

import com.meowningmaster.request.book.command.Commands;
import com.meowningmaster.request.book.page.widget.Widget;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ButtonWidget extends Widget {

    public String getText() {
        return text;
    }

    public Commands getClick() {
        return click;
    }

    private String text;
    private Commands click;

    public ButtonWidget(@NotNull JSONObject json) throws JSONException {
        super();
        text = json.getString("content");
        click = new Commands(json.getJSONArray("click"));
    }
}
