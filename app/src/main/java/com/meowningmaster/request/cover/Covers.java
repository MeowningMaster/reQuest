package com.meowningmaster.request.cover;

import android.content.Context;

import com.meowningmaster.request.Assets;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Covers {
    public int count() {
        return covers.size();
    }

    public Cover get(int i) {
        return covers.get(i);
    }

    private ArrayList<Cover> covers;

    public Covers(@NotNull Context context) throws IOException, JSONException {
        covers = new ArrayList<>();
        String[] files = Assets.getFilesList(context, "books");

        if (files != null) {
            for (String file : files) {
                covers.add(new Cover(context, file));
            }
        }
    }
}
