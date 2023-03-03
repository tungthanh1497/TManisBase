package com.tungtt.tmbmodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.tungtt.tmb.R;
import com.tungtt.tmbmodule.util.Utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ButtonBase extends AppCompatTextView {

    @Retention(RetentionPolicy.SOURCE)
    private @interface TYPE {
        int FILL = 0;
        int BORDER = 1;
        int DISABLE = 2;
    }

    private int type = TYPE.FILL;

    public ButtonBase(@NonNull Context context) {
        super(context);
        initUI(context, null);
    }

    public ButtonBase(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initUI(context, attrs);
    }

    public ButtonBase(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context, attrs);
    }

    private void initUI(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonBase);
            type = typedArray.getInt(R.styleable.ButtonBase_typeButton, TYPE.FILL);
            typedArray.recycle();
        }

        int styleTheme;
        int backgroundRes;
        boolean state;
        if (TYPE.DISABLE == type) {
            styleTheme = R.style.ButtonDisable;
            backgroundRes = R.drawable.bg_button_disable;
            state = false;
        } else {
            if (TYPE.BORDER == type) {
                styleTheme = R.style.ButtonBorder;
                backgroundRes = R.drawable.bg_button_border;
            } else {
                styleTheme = R.style.ButtonFill;
                backgroundRes = R.drawable.bg_button_fill;
            }
            state = true;
        }
        this.setTextAppearance(styleTheme);
        this.setBackgroundResource(backgroundRes);
        this.changeState(state);

        this.setPadding(Utils.dp2px(context, 16), Utils.dp2px(context, 8), Utils.dp2px(context, 16), Utils.dp2px(context, 8));
    }

    private void changeState(boolean isEnable) {
        this.setFocusable(isEnable);
//        this.setFocusableInTouchMode(isEnable);
        this.setEnabled(isEnable);
        this.setClickable(isEnable);
    }
}
