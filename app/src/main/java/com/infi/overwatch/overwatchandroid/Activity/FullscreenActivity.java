package com.infi.overwatch.overwatchandroid.Activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.crashlytics.android.Crashlytics;
import com.infi.overwatch.overwatchandroid.Fragment.NewsFragment;
import com.infi.overwatch.overwatchandroid.Fragment.PhotoFragment;
import com.infi.overwatch.overwatchandroid.Fragment.TwitFragment;
import com.infi.overwatch.overwatchandroid.Fragment.VideoFragment;
import com.infi.overwatch.overwatchandroid.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class FullscreenActivity extends AppCompatActivity {


    private BottomBar bottomBar;
    private FragmentManager fragmentManager;
    private LinearLayout linearLayout;
    private com.infi.overwatch.overwatchandroid.Application.Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = new com.infi.overwatch.overwatchandroid.Application.Application();

        setContentView(R.layout.activity_fullscreen);

        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.useDarkTheme();
        bottomBar.setItemsFromMenu(R.menu.bottom_bar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(int menuItemId) {
                if(menuItemId == R.id.news){
                    _hideOtherFragment();
                    NewsFragment newsFragment = NewsFragment.newInstance("overwatch");
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.rootLayout, newsFragment, NewsFragment.TAG).commit();
                }else if(menuItemId == R.id.photo){
                    _hideOtherFragment();
                    PhotoFragment photoFragment = PhotoFragment.newInstance();
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.rootLayout, photoFragment, PhotoFragment.TAG).commit();
                }else if(menuItemId == R.id.video){
                    _hideOtherFragment();
                    VideoFragment videoFragment = VideoFragment.newInstance();
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.rootLayout, videoFragment, VideoFragment.TAG).commit();
                }else if(menuItemId == R.id.twit){
                    _hideOtherFragment();
                    TwitFragment twitFragment = TwitFragment.newInstance();
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.rootLayout, twitFragment, TwitFragment.TAG).commit();
                }
            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {
                if(menuItemId == R.id.news){
                    _checkFragment(NewsFragment.class);
                }else if(menuItemId == R.id.photo){
                    _checkFragment(PhotoFragment.class);
                }else if(menuItemId == R.id.video){
                    _checkFragment(VideoFragment.class);
                }else if(menuItemId == R.id.twit){
                    _checkFragment(TwitFragment.class);
                }
            }
        });
    }

    private void _hideOtherFragment(){
        if(getSupportFragmentManager().getFragments() == null){
            return;
        }

        for(android.support.v4.app.Fragment fragment : getSupportFragmentManager().getFragments()){
            getSupportFragmentManager().beginTransaction().hide(fragment).commit();
        }
    }

    private void _checkFragment(Class<?> className){
        for(android.support.v4.app.Fragment fragment : getSupportFragmentManager().getFragments()){
            if(fragment.getClass().isInstance(className)){
                getSupportFragmentManager().beginTransaction().show(fragment).commit();
            }else{
                getSupportFragmentManager().beginTransaction().hide(fragment).commit();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        bottomBar.onSaveInstanceState(outState);
    }
}
