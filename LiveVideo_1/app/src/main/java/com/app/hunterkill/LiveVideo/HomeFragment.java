package com.app.hunterkill.LiveVideo;

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
 * Created by hunterkill on 14/04/2020.
 */

public class HomeFragment extends Fragment {

    HorizontalGridView gridViewHome;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //gridViewHome.requestFocus();
        gridViewHome = view.findViewById(R.id.gridViewHome);

        // Create a list of MediaModel
        List<MediaModel> aList = new ArrayList<>();
        MediaModel aMedia = new MediaModel();

        // 1
        aMedia.setMediaTitle("Zack & Aerith || If I Die Young ||");
        aMedia.setMediaInfo("seasalticecreams13");
        aMedia.setMediaThumbnail("https://i.ytimg.com/vi/ExrZ4pfcZlY/maxresdefault.jpg");
        aList.add(aMedia);
        // 2
        aMedia = new MediaModel();
        aMedia.setMediaTitle("Two Steps From Hell - Victory");
        aMedia.setMediaInfo("Two Steps From Hell");
        aMedia.setMediaThumbnail("https://i.ytimg.com/vi/hKRUPYrAQoE/maxresdefault.jpg");
        aList.add(aMedia);

        // 3
        aMedia = new MediaModel();
        aMedia.setMediaTitle("Fairy Tail Emotional Music");
        aMedia.setMediaInfo("ich98");
        aMedia.setMediaThumbnail("https://i.ytimg.com/vi/L8HxKTty1WU/hqdefault.jpg");
        aList.add(aMedia);

        // 4
        aMedia = new MediaModel();
        aMedia.setMediaTitle("MOUNT & BLADE 2 #1");
        aMedia.setMediaInfo("Trực Tiếp Game");
        aMedia.setMediaThumbnail("https://i.ytimg.com/vi/7aVRrs8MSEc/maxresdefault.jpg");
        aList.add(aMedia);

        // 5
        aMedia = new MediaModel();
        aMedia.setMediaTitle("The Seven Deadly Sins - 'Perfect Time' with Lyrics");
        aMedia.setMediaInfo("heldenhaftig");
        aMedia.setMediaThumbnail("https://i.ytimg.com/vi/5-Ltm-3lmss/maxresdefault.jpg");
        aList.add(aMedia);

        // Circular??


        //Create Adapter
        ListAdapter adapter = new ListAdapter(getActivity(), aList);
        gridViewHome.setAdapter(adapter);

        return view;
    }
}
