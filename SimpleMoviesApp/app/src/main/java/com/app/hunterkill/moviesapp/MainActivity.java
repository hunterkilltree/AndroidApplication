package com.app.hunterkill.moviesapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.exoplayer2.ui.PlayerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnAction, btnDoc, btnEpic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAction = findViewById(R.id.btnActionMovies);
        btnDoc = findViewById(R.id.btnDocumentaryMovies);
        btnEpic = findViewById(R.id.btnEpicMovies);

        btnAction.setOnClickListener(this);
        btnDoc.setOnClickListener(this);
        btnEpic.setOnClickListener(this);
    }

    ImageButton preButton;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActionMovies:
                invisibleBackground(preButton);
                visibleBackground(btnAction);
                preButton = btnAction;
                selectFragment(1);
                break;
            case R.id.btnDocumentaryMovies:
                invisibleBackground(preButton);
                visibleBackground(btnDoc);
                preButton = btnDoc;
                selectFragment(2);
                break;
            case R.id.btnEpicMovies:
                invisibleBackground(preButton);
                visibleBackground(btnEpic);
                preButton = btnEpic;
                selectFragment(3);
                break;
            default:
                break;
        }
    }

    Fragment fragment = null;
    String fragmentTag = "";
    private void selectFragment(int position) {
        Class fragmentClass = null;
        switch (position) {
            case 1:
                fragmentClass = ActionMoviesFragment.class;
                fragmentTag = "ActionMoviesFragment";
                break;
            case 2:
                fragmentClass = DocumentaryMoviesFragment.class;
                fragmentTag = "DocumentaryMoviesFragment";
                break;
            case 3:
                fragmentClass = EpicMoviesFragment.class;
                fragmentTag = "EpicMoviesFragment";
                break;
            default:
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();

            // passing arguments to Fragment
            Bundle bundle = new Bundle();
            bundle.putString("fragmentTag", fragmentTag);
            fragment.setArguments(bundle);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_content, fragment);
//            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commitAllowingStateLoss();

        } catch (Exception e) {
            // Log.e(TAG, "selectFragment " + e.getMessage());
        }
    }



    private void visibleBackground(ImageButton btnIcon) {
        if (btnIcon != null) {
            btnIcon.setBackgroundResource(R.drawable.button_focus_state);
        }
    }

    private void invisibleBackground(ImageButton btnIcon) {
        if (btnIcon != null) {
            btnIcon.setBackgroundResource(R.drawable.button_normal_state);
        }
    }
}
