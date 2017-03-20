package com.example.igor.randomizer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.igor.randomizer.R.id.menu_list;

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
                    etInput.setText("");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_input, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        // Операции для выбранного пункта меню
        switch (id) {
            case menu_list:
                final String [] items = new String[randomList.size()];
                for (int i = 0; i < randomList.size(); i++){
                    items[i] = randomList.get(i).toString();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(InputActivity.this);
                builder.setTitle("Список Рандом")
                        .setCancelable(true);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(),
                                "Нажми RANDOM",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
