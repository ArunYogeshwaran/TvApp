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
import com.valley.wishers.tvapp.viewmodel.ShowsViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowsFragment extends Fragment {

    private ShowsViewModel mViewModel;

    @BindView(R.id.showsRecyclerView)
    protected RecyclerView showsRecyclerView;

    public static ShowsFragment newInstance() {
        return new ShowsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shows, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShowsViewModel.class);
        // TODO: Use the ViewModel
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false);
        showsRecyclerView.setLayoutManager(linearLayoutManager);
        showsRecyclerView.setHasFixedSize(true);
        CustomRecyclerViewAdapter customAdapter = new CustomRecyclerViewAdapter(getContext(), getDataSource());
        showsRecyclerView.setAdapter(customAdapter);
    }

    private List<String> getDataSource(){
        List<String> data = new ArrayList<String>();
        data.add("First Header");
        data.add("Shows will appear here");
        data.add("Shows will appear here");
        data.add("Shows will appear here");
        data.add("Shows will appear here");
        data.add("Shows will appear here");
        return data;
    }

}
