package com.app.hunterkill.namebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by hunterkill on 16/05/2020.
 */

public class ViewPageFragment extends Fragment {

    public static final String KEY_RECIPE_INDEX = "recipe_index";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);


        // instance of IngredientFragment, DirectionFragment
        final IngredientFragment ingredientFragment = new IngredientFragment();
        final DirectionFragment directionFragment = new DirectionFragment();

        // new value for viewPager from fragment_viewpager.xml
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        // when we deal with fragment within fragment, we need to use ChildFragmentManager()
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return ingredientFragment;
                } else if (position == 1) {
                    return directionFragment;
                }

                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        return view;
    }


    // set title back to app name when hit back.
    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
