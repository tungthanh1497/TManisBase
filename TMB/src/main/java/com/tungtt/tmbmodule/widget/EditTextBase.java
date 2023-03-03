package com.tungtt.tmbmodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.tungtt.tmb.R;
import com.tungtt.tmbmodule.util.Utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class EditTextBase extends AppCompatEditText {


    @Retention(RetentionPolicy.SOURCE)
    private @interface TYPE {
        int DISABLE = 0;
        int ENABLE = 1;
    }

    private int type = TYPE.ENABLE;

    public EditTextBase(@NonNull Context context) {
        super(context);
        initUI(context, null);
    }

    public EditTextBase(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initUI(context, attrs);
    }

    public EditTextBase(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context, attrs);
    }

    private void initUI(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EditTextBase);
            type = typedArray.getInt(R.styleable.EditTextBase_typeEditText, TYPE.ENABLE);
            typedArray.recycle();
        }

        int styleTheme;
        int backgroundRes;
        boolean state;
        if (TYPE.DISABLE == type) {
            styleTheme = R.style.EditTextBaseDisable;
            backgroundRes = R.drawable.bg_edittext_disable;
            state = false;
        } else {
            styleTheme = R.style.EditTextNormal;
            backgroundRes = R.drawable.bg_edittext;
            state = true;
        }
        this.setTextAppearance(styleTheme);
        this.setBackgroundResource(backgroundRes);
        this.changeState(state);

        this.setPadding(Utils.dp2px(context, 16), Utils.dp2px(context, 8), Utils.dp2px(context, 16), Utils.dp2px(context, 8));
    }

    private void changeState(boolean isEnable) {
        this.setFocusable(isEnable);
        this.setFocusableInTouchMode(isEnable);
        this.setEnabled(isEnable);
        this.setClickable(isEnable);
    }
}
