package com.example.igor.randomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class KindActivity extends AppCompatActivity implements View.OnClickListener{

    private static boolean isNumeric;
    ImageButton btnNumeric;
    ImageButton btnObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind);

        btnNumeric = (ImageButton)findViewById(R.id.ibtnNumeric);
        btnObjects = (ImageButton)findViewById(R.id.ibtnObjects);

        btnNumeric.setOnClickListener(this);
        btnObjects.setOnClickListener(this);
    }

    public static boolean getNumeric(){
        return isNumeric;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ibtnNumeric:
                break;
            case R.id.ibtnObjects:
                break;
        }

    }
}
