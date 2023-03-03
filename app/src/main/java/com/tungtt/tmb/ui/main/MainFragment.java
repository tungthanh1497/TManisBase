package com.tungtt.tmb.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.tungtt.tmb.MainActivity;
import com.tungtt.tmb.databinding.FragmentMainBinding;
import com.tungtt.tmb.ui.second.SecondFragment;
import com.tungtt.tmb.util.ActivityUtils;
import com.tungtt.tmb.util.Constants;
import com.tungtt.tmbmodule.common.FragmentBase;

public class MainFragment extends FragmentBase<MainActivity, FragmentMainBinding, MainViewModel> {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public MainViewModel initViewModel() {
        return new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public FragmentMainBinding initBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentMainBinding.inflate(inflater, container, false);
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    protected void implementListeners(View view) {
        mBinding.btnNext.setOnClickListener(view1 -> {
            mActivity.showProgressDialog();
            ActivityUtils.addScreen(SecondFragment.newInstance(), Constants.TAG_SCREEN.SECOND);
        });
    }

    @Override
    protected void init(View view) {
    }

}