package com.tungtt.tmbmodule.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tungtt.tmb.R;

public class LoadingDialog extends Dialog {
    private static final String TAG = LoadingDialog.class.toString();
    private View progressBar;
    private View tvWait;

    public LoadingDialog(@NonNull Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        setContentView(R.layout.dialog_loading);
        progressBar = findViewById(R.id.progress_bar);
        this.setCancelable(false);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void onBackPressed() {

    }
}
