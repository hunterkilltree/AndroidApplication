package com.app.hunterkill.moviesapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunterkill on 9/05/2020.
 */

public class ActionMoviesFragment extends Fragment {
    private HorizontalGridView gridViewActionMovies;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_action_movies, container, false);


        gridViewActionMovies = view.findViewById(R.id.gridViewActionMovies);
        // Create a list of MediaModel
        final List<MediaModel> aList = new ArrayList<>();
        MediaModel aMedia = new MediaModel();

        // 1
        aMedia.setMediaTitle("getMediaTitle[0]");
        aMedia.setMediaInfo("getMediaInfo[0]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aList.add(aMedia);
        // 2
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[1]");
        aMedia.setMediaInfo("getMediaInfo[1]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
        aMedia.setMediaUrl("https://drive.google.com/open?id=1-_u8FVUiqfdHwWYmoykzOovDUQlD2nHQ");
        aList.add(aMedia);

        // 3
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[2]");
        aMedia.setMediaInfo("getMediaInfo[2]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
//        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aMedia.setMediaUrl("https://drive.google.com/open?id=1-_u8FVUiqfdHwWYmoykzOovDUQlD2nHQ");
        aList.add(aMedia);

        // 3
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[3]");
        aMedia.setMediaInfo("getMediaInfo[3]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
//        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aMedia.setMediaUrl("https://drive.google.com/open?id=1-_u8FVUiqfdHwWYmoykzOovDUQlD2nHQ");
        aList.add(aMedia);

        // 4
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[4]");
        aMedia.setMediaInfo("getMediaInfo[4]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
//        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aMedia.setMediaUrl("https://drive.google.com/open?id=1-_u8FVUiqfdHwWYmoykzOovDUQlD2nHQ");
        aList.add(aMedia);

        // 5
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[5]");
        aMedia.setMediaInfo("getMediaInfo[5]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
//        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aMedia.setMediaUrl("https://drive.google.com/open?id=1-_u8FVUiqfdHwWYmoykzOovDUQlD2nHQ");
        aList.add(aMedia);

        ListAdapter adapter = new ListAdapter(getActivity(), aList);
        gridViewActionMovies.setAdapter(adapter);
        return view;
    }
}
