package com.app.hunterkill.LiveVideo;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.hunterkill.LiveVideo.fragment_pages_class.FavoriteFragment;
import com.app.hunterkill.LiveVideo.fragment_pages_class.HistoryFragment;
import com.app.hunterkill.LiveVideo.fragment_pages_class.PlayListFragment;
import com.app.hunterkill.LiveVideo.fragment_pages_class.SearchingFragment;
import com.app.hunterkill.LiveVideo.fragment_pages_class.SettingFragment;
import com.app.hunterkill.LiveVideo.fragment_pages_class.TrendingFragment;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private ImageButton btnVoice, btnSetting, btnPlayList,
            btnHistory, btnFavorite, btnTrending, btnSearch;
    private TextView txtVoiceStatus, txtSettingStatus,
            txtHistoryStatus, txtFavoriteStatus,
            txtTrendingStatus, txtPlayListStatus, txtSearchStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVoice = findViewById(R.id.btnVoice);
        btnSetting = findViewById(R.id.btnSetting);
        btnPlayList = findViewById(R.id.btnPlaylist);
        btnHistory = findViewById(R.id.btnHistory);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnTrending = findViewById(R.id.btnTrending);
        btnSearch = findViewById(R.id.btnSearch);


        txtSettingStatus = findViewById(R.id.txtSetting);
        txtVoiceStatus = findViewById(R.id.txtVoiceStatus);
        txtPlayListStatus = findViewById(R.id.txtPlaylist);
        txtHistoryStatus = findViewById(R.id.txtHistory);
        txtFavoriteStatus = findViewById(R.id.txtFavorite);
        txtTrendingStatus = findViewById(R.id.txtTrending);
        txtSearchStatus = findViewById(R.id.txtSearch);


        btnVoice.setOnFocusChangeListener(this);
        btnSetting.setOnFocusChangeListener(this);
        btnPlayList.setOnFocusChangeListener(this);
        btnHistory.setOnFocusChangeListener(this);
        btnFavorite.setOnFocusChangeListener(this);
        btnTrending.setOnFocusChangeListener(this);
        btnSearch.setOnFocusChangeListener(this);


        // put the first fragment to UI
        //selectFragment(0);
    }

    // for smooth testing because we focus on tivi app.
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_B) {
//            onBackPressed();
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    public void onBackPressed() {
//        Fragment home = getSupportFragmentManager().findFragmentByTag(fragmentTag);
//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            getFragmentManager().popBackStack();
//        }
//        else {
//            super.onBackPressed();
//        }
//
//    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            switch (v.getId()) {
                case R.id.btnVoice:
                    visibleText(txtVoiceStatus, hasFocus);
                    selectFragment(0);
                    break;
                case R.id.btnTrending:
                    visibleText(txtTrendingStatus, hasFocus);
                    selectFragment(1);
                    break;
                case R.id.btnSearch:
                    visibleText(txtSearchStatus, hasFocus);
                    selectFragment(2);
                    break;
                case R.id.btnPlaylist:
                    visibleText(txtPlayListStatus, hasFocus);
                    selectFragment(3);
                    break;
                case R.id.btnHistory:
                    visibleText(txtHistoryStatus, hasFocus);
                    selectFragment(4);
                    break;
                case R.id.btnFavorite:
                    visibleText(txtFavoriteStatus, hasFocus);
                    selectFragment(5);
                    break;
                case R.id.btnSetting:
                    visibleText(txtSettingStatus, hasFocus);
                    selectFragment(6);
                    break;
                default:
                    break;
            }
    }

}
    // add Fragment
    Fragment fragment = null;
    String fragmentTag = "";

    private void selectFragment(int position) {
        Class fragmentClass = null;
        switch (position) {
            case 0:
                fragmentClass = HomeFragment.class;
                fragmentTag = "HomeFragment";
                break;
            case 1:
                fragmentClass = TrendingFragment.class;
                fragmentTag = "TrendingFragment";
                break;
            case 2:
                fragmentClass = SearchingFragment.class;
                fragmentTag = "SearchFragment";
                break;
            case 3:
                fragmentClass = PlayListFragment.class;
                fragmentTag = "PlayListFragment";
                break;
            case 4:
                fragmentClass = HistoryFragment.class;
                fragmentTag = "HistoryFragment";
                break;
            case 5:
                fragmentClass = FavoriteFragment.class;
                fragmentTag = "FavoriteFragment";
                break;
            case 6:
                fragmentClass = SettingFragment.class;
                fragmentTag = "SettingFragment";
                break;
            default:
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();

            Bundle bundle = new Bundle();

            bundle.putString("fragmentTag", fragmentTag);


            fragment.setArguments(bundle);
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_content, fragment).commitAllowingStateLoss();
        } catch (Exception e) {
            // Log.e(TAG, "selectFragment " + e.getMessage());
        }
    }

    public void visibleText(TextView txt, boolean hasFocus) {
        if (hasFocus) {
            txt.setVisibility(View.VISIBLE);
        } else {
            txt.setVisibility(View.INVISIBLE);
        }
    }

//    private void visibleBackground(ImageButton btnIcon, boolean hasFocus) {
//        if (hasFocus) {
//            btnIcon.setBackgroundResource(R.drawable.button_background);
//        }
//
//    }
}
