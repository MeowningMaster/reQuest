package com.meowningmaster.request;

import org.jetbrains.annotations.NotNull;

public class Part {
    public String first, second;

    public Part(@NotNull String s) {
        int separator = s.indexOf("|");
        first = s.substring(0, separator);
        second = s.substring(separator + 1);
    }
}
