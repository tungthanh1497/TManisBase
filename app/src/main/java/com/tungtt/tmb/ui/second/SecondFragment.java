package com.tungtt.tmb.ui.second;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.tungtt.tmb.MainActivity;
import com.tungtt.tmb.databinding.FragmentSecondBinding;
import com.tungtt.tmbmodule.common.FragmentBase;

public class SecondFragment extends FragmentBase<MainActivity, FragmentSecondBinding, SecondViewModel> {

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public SecondViewModel initViewModel() {
        return new ViewModelProvider(this).get(SecondViewModel.class);
    }

    @Override
    public FragmentSecondBinding initBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentSecondBinding.inflate(inflater, container, false);
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    protected void implementListeners(View view) {
        mBinding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBack();
            }
        });
    }

    @Override
    protected void init(View view) {
        new Handler().postDelayed(() -> mActivity.dismissProgressDialog(), 3000);
    }

}