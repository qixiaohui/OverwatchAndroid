package com.infi.overwatch.overwatchandroid.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.infi.overwatch.overwatchandroid.R;

/**
 * Created by TQi on 5/18/16.
 */
public class YoutubeActivity extends AppCompatActivity {
    public static final String CONTENT_EXTRA = "CONTENT_EXTRA";
    public static final String SUBTITLE = "SUBTITLE";

    private String stream;
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
        stream = getIntent().getStringExtra(CONTENT_EXTRA);
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
        mWebContent.loadUrl(stream);
    }

    public static void launchActivity(Activity fromActivity, String stream){
        Intent intent = new Intent(fromActivity, YoutubeActivity.class);
        intent.putExtra(CONTENT_EXTRA, stream);
        fromActivity.startActivity(intent);
    }
}
