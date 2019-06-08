package com.meowningmaster.request.book.page.widget;

import com.meowningmaster.request.book.page.widget.types.ButtonWidget;
import com.meowningmaster.request.book.page.widget.types.HeaderWidget;
import com.meowningmaster.request.book.page.widget.types.ImageWidget;
import com.meowningmaster.request.book.page.widget.types.TextWidget;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class Widget {
    @Contract("_ -> new")
    @NotNull
    public static Widget parse(@NotNull JSONObject json) throws JSONException {
        String type = json.getString("type");

        switch (type) {
            case "HEADER": {
                return new HeaderWidget(json);
            }
            case "TEXT": {
                return new TextWidget(json);
            }
            case "BUTTON": {
                return new ButtonWidget(json);
            }
            case "IMAGE": {
                return new ImageWidget(json);
            }
            default: {
                return new Widget();
            }
        }
    }
}
