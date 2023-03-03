package com.tungtt.tmb.util;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.tungtt.tmb.MainActivity;
import com.tungtt.tmb.R;
import com.tungtt.tmbmodule.common.ActivityBase;

public class ActivityUtils {

    public static void addScreen(Fragment fragment, String tag) {
        addScreen(fragment, tag, null);
    }

    public static void addScreen(Fragment fragment, String tag, Bundle data) {
        com.tungtt.tmbmodule.util.ActivityUtils.addScreen(MainActivity.getINSTANCE(), R.id.container, fragment, tag, data);
    }
}
