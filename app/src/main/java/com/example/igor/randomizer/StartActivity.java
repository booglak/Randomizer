package com.example.igor.randomizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvStart;
    TextView tvExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        tvStart = (TextView) findViewById(R.id.tvStart);
        tvExit = (TextView) findViewById(R.id.tvExit);

        tvStart.setOnClickListener(this);
        tvExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvStart:
                Intent intent = new Intent(this, KindActivity.class);
                startActivity(intent);
                break;
            case R.id.tvExit:
                finish();
                break;
        }
    }
}
