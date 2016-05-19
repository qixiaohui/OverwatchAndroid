package com.infi.overwatch.overwatchandroid.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

    private WebView webView;
    private Stream stream;
    private Toolbar toolbar;
    private WebView mWebContent;
    private ProgressBar progressBar;

    private boolean firstTimeLoad = true;
    private String subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mWebContent = (WebView) findViewById(R.id.webContent);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        progressBar.setVisibility(View.VISIBLE);
        stream = new Gson().fromJson(getIntent().getStringExtra(CONTENT_EXTRA), Stream.class);
        subtitle = getIntent().getStringExtra(SUBTITLE);
        toolbar.setTitle(subtitle);
        setSupportActionBar(toolbar);
        _loadUrl();
    }

    private void _loadUrl() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int height = metrics.heightPixels;
        mWebContent.setVisibility(View.VISIBLE);
        mWebContent.setVerticalScrollBarEnabled(true);
        mWebContent.getSettings().setJavaScriptEnabled(true);
        mWebContent.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        //prevent launch from external browser
        mWebContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        mWebContent.loadUrl(stream.getChannel().getUrl());
    }

    public static void launchActivity(Activity fromActivity, Stream stream, String subtitle){
        Intent intent = new Intent(fromActivity, TwitchActivity.class);
        intent.putExtra(CONTENT_EXTRA, new Gson().toJson(stream));
        intent.putExtra(SUBTITLE, subtitle);
        fromActivity.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_content_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, stream.getChannel().getStatus());
            i.putExtra(Intent.EXTRA_TEXT, stream.getChannel().getUrl());
            startActivity(Intent.createChooser(i, stream.getChannel().getStatus()));
            return true;
        }else if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
