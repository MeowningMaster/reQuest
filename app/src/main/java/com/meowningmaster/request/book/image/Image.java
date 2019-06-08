package com.meowningmaster.request.book.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class Image {
    public String asString() {
        return content;
    }

    public Bitmap asBitmap() {
        byte[] decodedString = Base64.decode(content, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    private String content;

    public Image(String content) {
        this.content = content;
    }
}
