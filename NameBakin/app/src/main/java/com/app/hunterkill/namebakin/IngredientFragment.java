package com.app.hunterkill.namebakin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by hunterkill on 23/05/2020.
 */

public class IngredientFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPageFragment.KEY_RECIPE_INDEX);


        View view = inflater.inflate(R.layout.fragment_ingredient, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ingredientLayout);
        String [] ingredients = Recipes.ingredients[index].split("`");

        setUpCheckBox(ingredients, linearLayout);

        return view;
    }

    private void setUpCheckBox(String [] ingredients, ViewGroup container) {
        for(String ingredient: ingredients) {
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setPadding(8, 16, 8, 16);
            checkBox.setTextSize(20f);
            checkBox.setText(ingredient);
            checkBox.setTextColor(Color.RED);
            System.out.println(ingredient);
            container.addView(checkBox);// add to linearLayout
        }
    }
}
