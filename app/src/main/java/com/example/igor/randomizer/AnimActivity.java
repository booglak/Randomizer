package com.example.igor.randomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class AnimActivity extends AppCompatActivity {

    WebView gifAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        gifAnim = (WebView)findViewById(R.id.wvAnim);


    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        InputActivity.randomList.clear();
    }
}
