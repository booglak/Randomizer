package com.example.igor.randomizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv3;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv3 = (TextView) findViewById(R.id.tvResult3);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(this);


        InputRandom rand = new InputRandom();

        tv3.setText(rand.Result3(InputActivity.randomList).toString());
    }

    @Override
    public void onBackPressed(){
        InputActivity.randomList.clear();
        InputActivity.etInput.setHint("");
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        InputActivity.randomList.clear();
        InputActivity.etInput.setHint("");
        super.onBackPressed();
        finish();
    }
}
