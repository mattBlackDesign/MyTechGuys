package com.zeeroapps.mytechguys;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.onesignal.OneSignal;

import org.json.JSONObject;

public class MainActivity extends Activity {

    private WebView mwebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// OneSignal.SetLogLevel(OneSignal.LOG_LEVEL.DEBUG, OneSignal.LOG_LEVEL.DEBUG);

        OneSignal.startInit(this).setNotificationOpenedHandler(new ExampleNotificationOpenedHandler()).init();

        mwebview=(WebView)findViewById(R.id.webView);
        final String loadUrl="http://www.mytechguys.ca/";

        mwebview.getSettings().setJavaScriptEnabled(true);
        mwebview.getSettings().setUseWideViewPort(true);
        mwebview.getSettings().setLoadWithOverviewMode(true);

        mwebview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mwebview.setScrollbarFadingEnabled(false);
        mwebview.getSettings().setBuiltInZoomControls(true);
        mwebview.getSettings().setSupportZoom(true);

        try{
            mwebview.loadUrl(loadUrl);

        }catch (Exception e){
            e.printStackTrace();
        }

        this.mwebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
}

// This fires when a notification is opened by tapping on it or one is received while the app is running.
private class ExampleNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
    @Override
    public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {
        //to do...
    }
}
}
