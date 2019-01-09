package com.valley.wishers.tvapp.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valley.wishers.tvapp.R;
import com.valley.wishers.tvapp.viewmodel.ChannelsViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelsFragment extends Fragment {

    private ChannelsViewModel mViewModel;

    @BindView(R.id.tv_test_channels)
    protected TextView testTvChannels;

    public static ChannelsFragment newInstance() {
        return new ChannelsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channels, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ChannelsViewModel.class);
        // TODO: Use the ViewModel
    }

}
