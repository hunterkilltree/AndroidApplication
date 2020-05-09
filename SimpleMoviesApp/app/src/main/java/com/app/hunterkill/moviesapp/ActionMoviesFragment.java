package com.app.hunterkill.moviesapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hunterkill on 9/05/2020.
 */

public class ActionMoviesFragment extends Fragment {
    private HorizontalGridView gridViewActionMovies;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_action_movies, container, false);

        gridViewActionMovies = view.findViewById(R.id.gridViewActionMovies);

        return view;
    }
}
