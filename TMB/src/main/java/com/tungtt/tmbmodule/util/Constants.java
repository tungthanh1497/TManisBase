package com.tungtt.tmbmodule.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Constants {
    @Retention(RetentionPolicy.SOURCE)
    public @interface BUNDLE_KEY {
        String TAG_SCREEN = "tag_screen";
    }
}
