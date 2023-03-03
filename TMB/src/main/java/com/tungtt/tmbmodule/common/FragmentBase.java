package com.tungtt.tmbmodule.common;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;

public abstract class FragmentBase<A extends ActivityBase, B extends ViewBinding, VM extends ViewModel> extends Fragment {

    public static final String TAG_SCREEN = "tag_screen";

    private String mTagScreen;
    protected A mActivity;
    protected B mBinding;
    protected VM mViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (A) getActivity();
        mViewModel = initViewModel();
        if (getArguments() != null) {
            mTagScreen = getArguments().getString(TAG_SCREEN, "");
            onReceiveData(getArguments());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = initBinding(inflater, container);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handlePhysicalBackClicked(view);
        implementListeners(view);
        init(view);
    }

    private void handlePhysicalBackClicked(View view) {
        if (view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener((v, keyCode, event) -> {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    onBack();
                    return true;
                }
                return false;
            });
        }
    }

    protected void onBack() {
        if (getActivity() != null) {
            if (mTagScreen == null || 0 == mTagScreen.trim().length()) {
                getActivity().getSupportFragmentManager().popBackStack();
            } else {
                getActivity().getSupportFragmentManager().popBackStack(mTagScreen, POP_BACK_STACK_INCLUSIVE);
            }
        }
    }

    public abstract VM initViewModel();

    public abstract B initBinding(LayoutInflater inflater, ViewGroup container);

    public abstract void onReceiveData(@NonNull Bundle data);

    protected abstract void implementListeners(View view);

    protected abstract void init(View view);
}