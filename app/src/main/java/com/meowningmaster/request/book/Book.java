package com.meowningmaster.request.book;

import android.content.Context;

import com.meowningmaster.request.Assets;
import com.meowningmaster.request.Parser;
import com.meowningmaster.request.book.image.Image;
import com.meowningmaster.request.book.image.Images;
import com.meowningmaster.request.book.page.Pages;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Book {
    public String getTitle() {
        return title;
    }

    public String getFile() {
        return file;
    }

    public String getStart() {
        return start;
    }

    public Image getImage() {
        return images.get(image);
    }

    public Pages getPages() {
        return pages;
    }

    public Images getImages() {
        return images;
    }

    private String title, image, start, file;
    private Images images;
    private Pages pages;

    public Book(Context context, String file) throws IOException, JSONException {
        this.file = file;
        JSONObject json = new JSONObject(Assets.readFile(context, "books/" + file));

        parse(json);
    }

    private void parse(@NotNull JSONObject json) throws JSONException {
        title = json.getString("title");
        image = Parser.image(json.getString("image"));
        start = Parser.page(json.getString("start"));

        images = new Images(json.getJSONObject("images"));
        pages = new Pages(json.getJSONObject("pages"));
    }
}

