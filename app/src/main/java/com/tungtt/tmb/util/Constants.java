package com.tungtt.tmb.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Constants {
    @Retention(RetentionPolicy.SOURCE)
    public @interface TAG_SCREEN {
        String MAIN = "main_screen";
        String SECOND = "second_screen";
    }
}
