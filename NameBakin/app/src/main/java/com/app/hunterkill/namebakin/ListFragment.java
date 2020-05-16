package com.app.hunterkill.namebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hunterkill on 16/05/2020.
 */

public class ListFragment extends Fragment {
    public interface OnRecipeSelectedInterface {
        void onListRecipeSelected(int index);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_list, container, false); // if we don't set it to false, it'll be added to twice and error "removeView() on the child's parent first."

        RecyclerView recyclerView = view.findViewById(R.id.listRecycleView);

        ListAdapter listAdapter = new ListAdapter(listener);

        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }


}
