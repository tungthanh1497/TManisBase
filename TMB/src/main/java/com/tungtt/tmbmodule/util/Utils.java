package com.tungtt.tmbmodule.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    private static Float scale;

    public static int dp2px(Context context, int dpValue) {
        if (scale == null) {
            scale = context.getResources().getDisplayMetrics().density;
        }
        return (int) (dpValue * scale + 0.5f);
    }

    public static boolean isNullOrEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String) {
            return 0 == ((String) object).trim().length();
        } else if (object instanceof ArrayList) {
            return 0 == ((ArrayList<?>) object).size();
        } else if (object instanceof List) {
            return 0 == ((List<?>) object).size();
        } else if (object instanceof Map) {
            return 0 == ((Map<?, ?>) object).size();
        } else {
            return false;
        }
    }
}
