package com.valley.wishers.tvapp.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valley.wishers.tvapp.R;
import com.valley.wishers.tvapp.adapter.CustomRecyclerViewAdapter;
import com.valley.wishers.tvapp.viewmodel.ChannelsViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelsFragment extends Fragment {

    private ChannelsViewModel mViewModel;

    @BindView(R.id.channelsRecyclerView)
    protected RecyclerView channelsRecyclerView;

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false);
        channelsRecyclerView.setLayoutManager(linearLayoutManager);
        channelsRecyclerView.setHasFixedSize(true);
        CustomRecyclerViewAdapter customAdapter = new CustomRecyclerViewAdapter(getContext(), getDataSource());
        channelsRecyclerView.setAdapter(customAdapter);
    }

    private List<String> getDataSource(){
        List<String> data = new ArrayList<String>();
        data.add("First Header");
        data.add("Channel will appear here");
        data.add("Channel will appear here");
        data.add("Channel will appear here");
        data.add("Channel will appear here");
        data.add("Channel will appear here");
        return data;
    }

}
