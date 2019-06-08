package com.meowningmaster.request.book.page.widget.types;

import com.meowningmaster.request.Parser;
import com.meowningmaster.request.book.command.Commands;
import com.meowningmaster.request.book.image.Image;
import com.meowningmaster.request.book.page.widget.Widget;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageWidget extends Widget {

    public String getImage() {
        return image;
    }

    public Commands getClick() {
        return click;
    }

    private String image;
    private Commands click;

    public ImageWidget(@NotNull JSONObject json) throws JSONException {
        super();
        image = Parser.image(json.getString("content"));

        if (json.has("click")) {
            click = new Commands(json.getJSONArray("click"));
        } else {
            click = new Commands(null);
        }
    }
}
