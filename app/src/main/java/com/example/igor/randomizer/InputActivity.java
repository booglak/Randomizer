package com.example.igor.randomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InputActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etInput;
    Button btnAdd;
    Button btnRandom;
    ArrayList randomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etInput = (EditText)findViewById(R.id.etInput);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnRandom = (Button)findViewById(R.id.btnRandom);

        btnAdd.setOnClickListener(this);
        btnRandom.setOnClickListener(this);

        if (KindActivity.getNumeric()){
            etInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        else {
            etInput.setInputType(InputType.TYPE_CLASS_TEXT);
        }

        randomList = new ArrayList();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                if (etInput.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Пустой элемент", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    randomList.add(etInput.getText().toString());
                }
                System.out.println(randomList.size());
                break;
            case R.id.btnRandom:
                break;
        }

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        randomList.clear();
    }
}
