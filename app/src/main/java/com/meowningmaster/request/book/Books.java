package com.meowningmaster.request.book;

import android.content.Context;

import com.meowningmaster.request.Assets;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Books {
    public int count() {
        return books.size();
    }

    public Book get(int i) {
        return books.get(i);
    }

    private ArrayList<Book> books;

    public Books(@NotNull Context context) throws IOException, JSONException {
        books = new ArrayList<>();
        String[] files = Assets.getFilesList(context, "books");

        if (files != null) {
            for (String file : files) {
                books.add(new Book(context, file));
            }
        }
    }
}
