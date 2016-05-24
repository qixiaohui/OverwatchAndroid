package com.infi.overwatch.overwatchandroid.Dao;

import com.infi.overwatch.overwatchandroid.model.Video.Videos;
import com.infi.overwatch.overwatchandroid.model.heros.Heros;
import com.infi.overwatch.overwatchandroid.model.table.Result;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.ArrayList;

/**
 * Created by TQi on 5/24/16.
 */
public class DataStore {
    private static ArrayList<Result> newsStore = new ArrayList<>();
    private static ArrayList<Heros> heroStore = new ArrayList<>();
    private static ArrayList<Tweet> tweetStore = new ArrayList<>();
    private static Videos videoStore = new Videos();

    public static void setNewsStore(ArrayList<Result> news){
        newsStore = news;
    }

    public static ArrayList<Result> getNewsStore(){
        return newsStore;
    }

    public static void setHeroStore(ArrayList<Heros> heros){
        heroStore = heros;
    }

    public static ArrayList<Heros> getHeroStore(){
        return heroStore;
    }

    public static void setVideoStore(Videos videos){
        videoStore = videos;
    }

    public static Videos getVideoStore(){
        return videoStore;
    }

    public static void setTweetStore(ArrayList<Tweet> tweets){
        tweetStore = tweets;
    }

    public static ArrayList<Tweet> getTweetStore(){
        return tweetStore;
    }
}
