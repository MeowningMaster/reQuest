package com.meowningmaster.request;

import org.jetbrains.annotations.NotNull;

public class Parser {
    @NotNull
    public static String image(@NotNull String s) {
        return s.substring(s.indexOf("|") + 1);
    }

    @NotNull
    public static String page(@NotNull String s) {
        return s.substring(s.indexOf("|") + 1);
    }
}
