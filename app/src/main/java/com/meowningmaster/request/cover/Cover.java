package com.meowningmaster.request.cover;

import android.content.Context;

import com.meowningmaster.request.Assets;
import com.meowningmaster.request.Parser;
import com.meowningmaster.request.book.image.Image;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Cover {
    public String getTitle() {
        return title;
    }

    public String getFile() {
        return file;
    }

    public Image getImage() {
        return image;
    }

    private String title, file;
    private Image image;

    public Cover(Context context, String file) throws IOException, JSONException {
        this.file = file;
        JSONObject json = new JSONObject(Assets.readFile(context, "books/" + file));

        title = json.getString("title");
        String imageId = Parser.image(json.getString("image"));

        JSONObject images = json.getJSONObject("images");
        image = new Image(images.getString(imageId));
    }
}
