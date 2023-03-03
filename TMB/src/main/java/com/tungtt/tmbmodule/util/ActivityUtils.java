package com.tungtt.tmbmodule.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.tungtt.tmbmodule.common.ActivityBase;
import com.tungtt.tmbmodule.widget.LoadingDialog;

public class ActivityUtils {
    private static final String TAG = ActivityUtils.class.getSimpleName();

    /**
     * open a new Fragment and add to backstack
     *
     * @param fragment: destination fragment
     * @param tag:      fragment's TAG
     * @param data:     bundle to transfer data (if needed)
     */
    public static void addScreen(ActivityBase activity, int containerRes, Fragment fragment, String tag, Bundle data) {

        if (data == null) {
            data = new Bundle();
        }
        data.putString(Constants.BUNDLE_KEY.TAG_SCREEN, tag);
        fragment.setArguments(data);
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(containerRes, fragment)
                .addToBackStack(tag)
                .commit();
    }

    public static void addScreen(ActivityBase activity, int containerRes, Fragment fragment, String tag) {
        addScreen(activity, containerRes, fragment, tag, null);
    }

    public static void hideKeyboard(ActivityBase activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                if (activity.getCurrentFocus() != null) {
                    imm.hideSoftInputFromWindow(
                            activity.getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS
                    );
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "hideKeyboard: ", e);
        }
    }

    public static void showProgressDialog(ActivityBase activity) {
        ActivityUtils.hideKeyboard(activity);
        if (activity.getLoadingDialog() != null) {
            try {
                activity.getLoadingDialog().cancel();
            } catch (Exception ex) {
                Log.e(TAG, "showProgressDialog: ", ex);
            }
        }

        new Handler().post(() -> {
            LoadingDialog loadingDialog = new LoadingDialog(activity);
            loadingDialog.setTitle("");
            loadingDialog.setCancelable(true);
            loadingDialog.setOnCancelListener(null);
            loadingDialog.setCanceledOnTouchOutside(false);
            activity.setLoadingDialog(loadingDialog);
            activity.getLoadingDialog().show();
        });

    }


    public static void dismissProgressDialog(ActivityBase activity) {
        if (activity.getLoadingDialog() != null) {
            try {
                activity.getLoadingDialog().dismiss();
            } catch (Exception ex) {
                Log.e(TAG, "dismissProgressDialog: ", ex);
            }
        }
    }
}
