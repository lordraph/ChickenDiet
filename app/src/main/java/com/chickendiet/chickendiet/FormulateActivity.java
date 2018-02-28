package com.chickendiet.chickendiet;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class FormulateActivity extends AppCompatActivity {
    boolean ismaize_chk, isrice_grain_chk, isrice_bran_chk,issorghum_chk,iscake_chk, iscotton_chk,issesame_chk,isbean_seeds_chk;
    boolean isLayer_chk, isGrower_chk, isBrooder_chk;
    CheckBox checkGrower, checkLayer, checkBrooder;
    CheckBox maize_chk, rice_grain_chk, rice_bran_chk,sorghum_chk,cake_chk, cotton_chk,sesame_chk,bean_seeds_chk;
    com.chickendiet.chickendiet.DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulate);
        dbHelper = new com.chickendiet.chickendiet.DbHelper(this);

        checkGrower = findViewById(R.id.check_grower);
        checkLayer = findViewById(R.id.check_layer);
        checkBrooder = findViewById(R.id.check_brooder);

        maize_chk = findViewById(R.id.check_maize);
        rice_grain_chk = findViewById(R.id.check_rice);
        rice_bran_chk = findViewById(R.id.check_ricebran);
        sorghum_chk = findViewById(R.id.check_sorghum);
        cake_chk = findViewById(R.id.check_groundnutcake);
        cotton_chk = findViewById(R.id.check_cotton_seed);
        bean_seeds_chk = findViewById(R.id.check_soyabean);

        selectChicken();
        checkSelectedCrop();


    }

    public void checkSelectedCrop(){

        maize_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ismaize_chk = true;
                    dbHelper.insertdata("Maize",0);
//                    isnonechecked = true;
//                    Cursor cursor = dbHelper.querry_Selector_table();
//                    Toast.makeText(FormulateActivity.this,"No of rows: " + cursor.getCount(),Toast.LENGTH_SHORT).show();

                }else {
                    if(ismaize_chk){
                        dbHelper.deletingsinlecrop("Maize");
                    }
                    ismaize_chk = false;
//                    isnonechecked = false;
                }
            }
        });

        rice_grain_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isrice_grain_chk = true;
                    dbHelper.insertdata("Rice grains",0);
//                    isnonechecked = true;

                }else {
                    if(isrice_grain_chk){
                        dbHelper.deletingsinlecrop("Rice grains");
                    }
                    isrice_grain_chk = false;
//                    isnonechecked = false;
                }
            }
        });

        rice_bran_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isrice_bran_chk = true;
                    dbHelper.insertdata("Rice bran",0);
//                    isnonechecked = true;

                }else {
                    if(isrice_bran_chk){
                        dbHelper.deletingsinlecrop("Rice bran");
                    }
                    isrice_bran_chk = false;
//                    isnonechecked = false;
                }
            }
        });

        sorghum_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    issorghum_chk = true;
                    dbHelper.insertdata("Sorghum grains",0);
//                    isnonechecked = true;
                }else {
                    if(issorghum_chk){
                        dbHelper.deletingsinlecrop("Sorghum grains");
                    }
                    issorghum_chk = false;
//                    isnonechecked = false;
                }
            }
        });

        cake_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iscake_chk = true;
                    dbHelper.insertdata("Groundnut cake",0);
//                    isnonechecked = true;
                }else {
                    if(iscake_chk){
                        dbHelper.deletingsinlecrop("Groundnut cake");
                    }
                    iscake_chk = false;
//                    isnonechecked = false;
                }
            }
        });

        cotton_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iscotton_chk = true;
                    dbHelper.insertdata("Cotton seed",0);
//                    isnonechecked = true;
                }else {
                    if(iscotton_chk){
                        dbHelper.deletingsinlecrop("Cotton seed");
                    }
                    iscotton_chk = false;
//                    isnonechecked = false;
                }
            }
        });

        bean_seeds_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isbean_seeds_chk = true;
                    dbHelper.insertdata("Soybean seeds (heat processed)",0);
//                    isnonechecked = true;
                }else {
                    if(isbean_seeds_chk){
                        dbHelper.deletingsinlecrop("Soybean seeds (heat processed)");
                    }
                    isbean_seeds_chk = false;
//                    isnonechecked = false;
                }
            }
        });


    }

    public void selectChicken(){
        checkGrower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isGrower_chk = true;
                    checkLayer.setChecked(false);
                    checkBrooder.setChecked(false);
                    Cursor cursor = dbHelper.querry_bird_selector();
                    cursor.moveToFirst();
                    int new_form = cursor.getInt(2) + 1;
                    dbHelper.update_bird_selection("Grower",new_form);

                }else{
                    if(isGrower_chk){
                        isGrower_chk = false;
                        dbHelper.update_bird_selection("bird",0);
                    }
                }
//                Toast.makeText(FormulateActivity.this,"Grower" + isGrower_chk,Toast.LENGTH_SHORT).show();;

            }
        });

        checkLayer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isLayer_chk = true;
                    checkGrower.setChecked(false);
                    checkBrooder.setChecked(false);
                    Cursor cursor = dbHelper.querry_bird_selector();
                    cursor.moveToFirst();
                    int new_form = cursor.getInt(2) + 1;
                    dbHelper.update_bird_selection("Layer",new_form);
                }else{
                    if(isLayer_chk){
                        isLayer_chk = false;
                        dbHelper.update_bird_selection("bird",0);
                    }
                }
//                Toast.makeText(FormulateActivity.this,"Layer" + isGrower_chk,Toast.LENGTH_SHORT).show();;
            }
        });

        checkBrooder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isBrooder_chk = true;
                    checkLayer.setChecked(false);
                    checkGrower.setChecked(false);
                    Cursor cursor = dbHelper.querry_bird_selector();
                    cursor.moveToFirst();
                    int new_form = cursor.getInt(2) + 1;
                    dbHelper.update_bird_selection("Brooder",new_form);
                }else{
                    if(isBrooder_chk){
                        isBrooder_chk = false;
                        dbHelper.update_bird_selection("bird",0);
                    }
                }
//                Toast.makeText(FormulateActivity.this,"Brooder" + isGrower_chk,Toast.LENGTH_SHORT).show();;
            }
        });

    }

    public void openResultActivity(View view) {

        if((ismaize_chk || isrice_grain_chk || isrice_bran_chk || issorghum_chk || iscake_chk || iscotton_chk || issesame_chk || isbean_seeds_chk)){
            if((isLayer_chk||isGrower_chk||isBrooder_chk)){
                Intent intent = new Intent(this, ResultActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(FormulateActivity.this, "Select at least a bird category", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(FormulateActivity.this, "Select at least a crop", Toast.LENGTH_SHORT).show();
        }




    }
}
