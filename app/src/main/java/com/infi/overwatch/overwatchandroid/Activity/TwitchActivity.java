package com.infi.overwatch.overwatchandroid.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.model.Video.Stream;
import com.infi.overwatch.overwatchandroid.model.Video.Videos;

/**
 * Created by TQi on 5/18/16.
 */
public class TwitchActivity extends AppCompatActivity {
    public static final String CONTENT_EXTRA = "CONTENT_EXTRA";
    public static final String SUBTITLE = "SUBTITLE";

    private Stream stream;
    private WebView mWebContent;
    private ProgressBar progressBar;

    private boolean firstTimeLoad = true;
    private String subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitch);
        mWebContent = (WebView) findViewById(R.id.webPlayer);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        stream = new Gson().fromJson(getIntent().getStringExtra(CONTENT_EXTRA), Stream.class);
        _loadUrl();
    }

    private void _loadUrl() {
        mWebContent.getSettings().setJavaScriptEnabled(true);
        mWebContent.getSettings().setDomStorageEnabled(true);
        mWebContent.setWebChromeClient(new WebChromeClient());
        mWebContent.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        mWebContent.loadUrl("http://player.twitch.tv/?channel=" + stream.getChannel().getName() + "&html5");
    }

    public static void launchActivity(Activity fromActivity, Stream stream){
        Intent intent = new Intent(fromActivity, TwitchActivity.class);
        intent.putExtra(CONTENT_EXTRA, new Gson().toJson(stream));
        fromActivity.startActivity(intent);
    }
}
