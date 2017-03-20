package com.example.igor.randomizer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.LayoutInflater;
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

    //Пункты контекстного меню
    public static final int CON_MEN_RANGE = 101;
    public static final int CON_MEN_NON = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etInput = (EditText)findViewById(R.id.etInput);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnRandom = (Button)findViewById(R.id.btnRandom);

        registerForContextMenu(etInput);

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

    //Создание верхнего меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_input, menu);
        return true;
    }

    //Обработчик верхнего меню
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

    //Создаем контекстное меню
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (KindActivity.getNumeric()) {
            menu.add(Menu.NONE, CON_MEN_RANGE, Menu.NONE, "Ввести диапазон");
        }
        else
        menu.add(Menu.NONE, CON_MEN_NON, Menu.NONE, "Диапазон не доступен");
    }

    //Обработчик контекстного меню
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case CON_MEN_RANGE:

                //Берем диалог из лейаута
                LayoutInflater li = LayoutInflater.from(this);
                View rangeDialog = li.inflate(R.layout.range_input, null);

                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
                mDialogBuilder.setView(rangeDialog);

                final EditText userInputFrom = (EditText) rangeDialog.findViewById(R.id.etRangeFrom);
                final EditText userInputTo = (EditText) rangeDialog.findViewById(R.id.etRangeTo);

                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {

                                        if (Integer.parseInt(userInputFrom.getText().toString()) > Integer.parseInt(userInputTo.getText().toString())){
                                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                                    "Только в порядке возрастания", Toast.LENGTH_SHORT);
                                            toast1.show();
                                        }else

                                        for (int i = Integer.parseInt(userInputFrom.getText().toString()); i < Integer.parseInt(userInputTo.getText().toString())+1; i++){
                                            randomList.add(i);
                                        }


                                    }
                                })
                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();





                break;
        }
        return true;
    }



}
