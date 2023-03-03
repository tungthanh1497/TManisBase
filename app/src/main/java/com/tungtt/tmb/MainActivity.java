package com.tungtt.tmb;

import android.os.Bundle;

import com.tungtt.tmb.ui.main.MainFragment;
import com.tungtt.tmb.util.ActivityUtils;
import com.tungtt.tmb.util.Constants;
import com.tungtt.tmbmodule.common.ActivityBase;

public class MainActivity extends ActivityBase {

    private static MainActivity INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        INSTANCE = this;
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            ActivityUtils.addScreen(MainFragment.newInstance(), Constants.TAG_SCREEN.MAIN);
        }
    }

    public static MainActivity getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MainActivity();
        }
        return INSTANCE;
    }
}