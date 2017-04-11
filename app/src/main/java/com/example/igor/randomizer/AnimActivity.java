package com.example.igor.randomizer;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.util.Timer;
import java.util.TimerTask;

public class AnimActivity extends AppCompatActivity {

    WebView gifAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        gifAnim = (WebView)findViewById(R.id.wvAnim);

        gifAnim.loadUrl("file:///android_asset/ani.gif");
        gifAnim.getSettings().setLoadWithOverviewMode(true);
        gifAnim.getSettings().setUseWideViewPort(true);

        final Intent intent = new Intent(this, ResultActivity.class);
        new java.util.Timer().schedule(
                new TimerTask() {
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                },
                3000 );


    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        InputActivity.randomList.clear();
    }
}
