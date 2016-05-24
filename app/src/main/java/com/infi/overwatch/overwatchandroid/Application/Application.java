package com.infi.overwatch.overwatchandroid.Application;

import android.content.res.AssetManager;
import android.util.Log;

import com.infi.overwatch.overwatchandroid.Dao.DataStore;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import io.fabric.sdk.android.Fabric;

/**
 * Created by TQi on 5/19/16.
 */
public class Application extends android.app.Application {
    private static DataStore dataStore;
    @Override
    public void onCreate() {
        super.onCreate();
        dataStore = new DataStore();
    }
}
