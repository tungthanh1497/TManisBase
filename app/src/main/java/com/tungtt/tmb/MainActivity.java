package com.tungtt.tmb;

import android.os.Bundle;

import com.tungtt.tmb.ui.main.MainFragment;
import com.tungtt.tmbmodule.common.ActivityBase;

public class MainActivity extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}