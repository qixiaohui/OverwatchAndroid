package com.infi.overwatch.overwatchandroid.Fragment;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.infi.overwatch.overwatchandroid.Adapter.TwitAdapter;
import com.infi.overwatch.overwatchandroid.R;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.AppSession;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.GuestCallback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;
import com.twitter.sdk.android.core.services.StatusesService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.fabric.sdk.android.Fabric;

/**
 * Created by TQi on 5/19/16.
 */
public class TwitFragment extends Fragment {
    public final static String TAG = "TWIT_FRAGMENT";
    private List<Tweet> tweets;
    private RecyclerView mRecycleView;
    private ProgressBar progressBar;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Properties properties = new Properties();
            AssetManager assetManager = getContext().getAssets();
            InputStream inputStream = assetManager.open("fabric.properties");
            properties.load(inputStream);
            TwitterAuthConfig authConfig =  new TwitterAuthConfig(properties.getProperty("apiKey"), properties.getProperty("apiSecret"));
            Fabric.with(getContext(), new Twitter(authConfig));
            _getSession();
        }catch (IOException e){
            Log.e("IOEXCEPTION", e.toString());
        }
    }

    private void _getSession(){
        TwitterCore.getInstance().logInGuest(new Callback<AppSession>() {
            @Override
            public void success(Result<AppSession> result) {
                AppSession guestAppSession = result.data;
                _getTweets(guestAppSession);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d(TAG, "loginGuest.callback.failure called");
                // unable to get an AppSession with guest auth
                throw exception;
            }
        });
    }

    private void _getTweets(AppSession guestAppSession){
        TwitterApiClient twitterApiClient =  TwitterCore.getInstance().getApiClient(guestAppSession);
        twitterApiClient.getSearchService().tweets("overwatch", null, "en", null, null, 50, null, null, null, true, new GuestCallback<Search>(new Callback<Search>() {
            @Override
            public void success(Result<Search> result) {
                // use result tweets
                Log.i(TAG, new Gson().toJson(result));
                tweets = result.data.tweets;
                mRecycleView.setAdapter(new TwitAdapter(getActivity(), getContext(), tweets));
            }

            @Override
            public void failure(TwitterException exception) {
                // handle exceptions
            }
        }));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_twit, container, false);
        mRecycleView = (RecyclerView) view.findViewById(R.id.list);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mRecycleView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycleView.setLayoutManager(mLayoutManager);
        progressBar.setVisibility(View.INVISIBLE);
        return view;
    }

    public static TwitFragment newInstance(){
        TwitFragment twitFragment = new TwitFragment();
        return twitFragment;
    }
}
