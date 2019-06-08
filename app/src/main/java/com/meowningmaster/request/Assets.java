package com.meowningmaster.request;

import android.content.Context;
import android.content.res.AssetManager;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Assets {
    public static String[] getFilesList(@NotNull Context context, String folder) throws IOException {
        AssetManager assetManager = context.getAssets();
        return assetManager.list(folder);
    }

    @NotNull
    public static String readFile(@NotNull Context context, String file) throws IOException {
        AssetManager am = context.getAssets();
        return StreamToString(am.open(file));
    }

    @NotNull
    public static String StreamToString(InputStream stream) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        StringBuilder total = new StringBuilder();
        for (String line; (line = r.readLine()) != null; ) {
            total.append(line).append('\n');
        }
        return total.toString();
    }
}
