package com.tungtt.tmbmodule.common;

import androidx.appcompat.app.AppCompatActivity;

import com.tungtt.tmbmodule.util.ActivityUtils;
import com.tungtt.tmbmodule.widget.LoadingDialog;

public class ActivityBase extends AppCompatActivity {
    private LoadingDialog mLoadingDialog;

    public LoadingDialog getLoadingDialog() {
        return mLoadingDialog;
    }

    public void setLoadingDialog(LoadingDialog loadingDialog) {
        this.mLoadingDialog = loadingDialog;
    }

    public void showProgressDialog() {
        ActivityUtils.showProgressDialog(this);
    }


    public void dismissProgressDialog() {
        ActivityUtils.dismissProgressDialog(this);
    }
}
