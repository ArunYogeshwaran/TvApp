package com.valley.wishers.tvapp.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valley.wishers.tvapp.R;
import com.valley.wishers.tvapp.viewmodel.ShortFilmsViewModel;

import butterknife.ButterKnife;

public class ShortFilmsFragment extends Fragment {

    private ShortFilmsViewModel mViewModel;

    public static ShortFilmsFragment newInstance() {
        return new ShortFilmsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_short_films, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShortFilmsViewModel.class);
        // TODO: Use the ViewModel
    }

}
