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

    private static final String KEY_CHECK_BOXES = "key_check_boxes" ;
    private CheckBox[] mCheckBoxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPageFragment.KEY_RECIPE_INDEX);


        View view = inflater.inflate(R.layout.fragment_ingredient, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ingredientLayout);
        String [] ingredients = Recipes.ingredients[index].split("`");

        mCheckBoxes = new CheckBox[ingredients.length];
        boolean[] checkBoxes = new boolean[mCheckBoxes.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECK_BOXES) != null)
            checkBoxes = savedInstanceState.getBooleanArray(KEY_CHECK_BOXES);


        setUpCheckBox(ingredients, linearLayout, checkBoxes);

        return view;
    }

    private void setUpCheckBox(String[] ingredients, ViewGroup container, boolean[] checkBoxes) {
        int i = 0;

        for(String ingredient: ingredients) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8, 16, 8, 16);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setText(ingredient);
            mCheckBoxes[i].setTextColor(Color.RED);
            container.addView( mCheckBoxes[i]);// add to linearLayout
            if (checkBoxes[i]) {
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        int i = 0;
        for (CheckBox checkBox: mCheckBoxes) {
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECK_BOXES, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
