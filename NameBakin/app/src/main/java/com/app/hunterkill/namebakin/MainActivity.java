package com.app.hunterkill.namebakin;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  ListFragment.OnRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEW_PAGER = "viewpager_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create an instance of  class ListFragment
        ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
        if (savedFragment == null) { // prevent re-create Fragment
            ListFragment fragment = new ListFragment();

            // in support FragmentManager lib getSupportFragmentManager() is good to go with AppCompatActivity
            // help us to keep track of our fragments, manage the back stack
            FragmentManager fragmentManager = getSupportFragmentManager();

            // like shared preferences
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // add new layer to placeHolder layer (de len)
            fragmentTransaction.add(R.id.placeHolder, fragment);

            // commit the change.
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListRecipeSelected(int index) {

        ViewPageFragment fragment = new ViewPageFragment();

        // pass argument to ViewPageFragment
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPageFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        // in support FragmentManager lib getSupportFragmentManager()
        // help us to keep track of our fragments, manage the back stack
        FragmentManager fragmentManager = getSupportFragmentManager();

        // like shared preferences
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // add new layer to placeHolder layer (de len)
        fragmentTransaction.replace(R.id.placeHolder, fragment);

        // back to previous State
        fragmentTransaction.addToBackStack(null);

        // commit the change.
        fragmentTransaction.commit();
    }
}
