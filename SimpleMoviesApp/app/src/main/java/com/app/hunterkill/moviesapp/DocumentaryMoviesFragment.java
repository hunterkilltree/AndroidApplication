package com.app.hunterkill.moviesapp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunterkill on 9/05/2020.
 */

public class DocumentaryMoviesFragment extends Fragment {
    private HorizontalGridView gridViewDocumentaryMovies;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_documentary_movies, container, false);

        gridViewDocumentaryMovies = view.findViewById(R.id.gridViewDocumentaryMovies);
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
        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aList.add(aMedia);

        // 3
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[2]");
        aMedia.setMediaInfo("getMediaInfo[2]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aList.add(aMedia);

        // 3
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[3]");
        aMedia.setMediaInfo("getMediaInfo[3]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aList.add(aMedia);

        // 4
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[4]");
        aMedia.setMediaInfo("getMediaInfo[4]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aList.add(aMedia);

        // 5
        aMedia = new MediaModel();
        aMedia.setMediaTitle("getMediaTitle[5]");
        aMedia.setMediaInfo("getMediaInfo[5]");
        aMedia.setMediaThumbnail("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1_icon.jpg");
        aMedia.setMediaUrl("https://ubc.sgp1.cdn.digitaloceanspaces.com/npnlab_files/HDONLINE/movie1.mp4");
        aList.add(aMedia);


        //Create Adapter
        ListAdapter adapter = new ListAdapter(getActivity(), aList, new ListAdapter.ItemListener() {

            @Override
            public void ItemClick(int pos) {
                System.out.println(getArguments());
                System.out.println(pos);
                Fragment fragment = null;
                if (pos >= 0) {
                    Class fragmentClass = PlayVideoFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                        Bundle bundle = new Bundle();
                        bundle.putString("link", aList.get(pos).getMediaUrl());
                        fragment.setArguments(bundle);

                        // Insert the fragment by replacing any existing fragment
                        FragmentManager fragmentManager =  getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.placeHolder, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commitAllowingStateLoss();
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        gridViewDocumentaryMovies.setAdapter(adapter);

        return view;
    }
}
