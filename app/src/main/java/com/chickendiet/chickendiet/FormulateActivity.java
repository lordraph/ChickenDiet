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
    boolean isbonemeal_chk, iscottonseed_chk,isbrewers_chk,isacha_chk, isbloodmeal_chk, iscassavameal_chk, iscassavapeel_chk;
    boolean isbeniseed_chk, isfishmeal_chk, isgroundnutcake_chk, isguinea_chk, issoyebeanmeal_chk, iscottonseedmeal_chk;
    boolean ispalmkernel, iswheatbran,ismillet, ismaizebran,issunflower, islimestone;
    boolean isLayer_chk, isGrower_chk, isBrooder_chk;
    CheckBox checkGrower, checkLayer, checkBrooder;
    CheckBox bonemeal_chk, brewersDriedGrain_chk, acha_chk, maize_chk, rice_grain_chk;
    CheckBox rice_bran_chk,sorghum_chk,cake_chk, cotton_chk,sesame_chk,bean_seeds_chk;
    CheckBox bloodmeal_chk, cassavameal_chk,cassavapeel_chk, beniseed_chk, fishmeal_chk,guinea_chk, maizebrain_chk, cottonseedmeal;
    CheckBox soyabeanmeal_chk, palmkernelcake_chk, wheatbran_chk, millet_chk, sunflower_chk, limestone_chk;
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
        bonemeal_chk = findViewById(R.id.check_bonemeal);
        rice_bran_chk = findViewById(R.id.check_ricebran);
        brewersDriedGrain_chk = findViewById(R.id.check_brewersDriedGrain);
        cake_chk = findViewById(R.id.check_groundnutcake);
//        cotton_chk = findViewById(R.id.check_cotton_seed);
        acha_chk = findViewById(R.id.check_acha);

        bloodmeal_chk = findViewById(R.id.check_bloodmeal);
        cassavameal_chk = findViewById(R.id.check_cassavameal);
        cassavapeel_chk = findViewById(R.id.check_cassavapeel);
        beniseed_chk = findViewById(R.id.check_beniseed);
        fishmeal_chk = findViewById(R.id.check_fishmeal);
        guinea_chk = findViewById(R.id.check_guineacorn);
        soyabeanmeal_chk = findViewById(R.id.check_soyabeanmeal);

        palmkernelcake_chk = findViewById(R.id.check_palmkernelcake);
        wheatbran_chk = findViewById(R.id.check_wheatbran);
        millet_chk = findViewById(R.id.check_millet);
        sunflower_chk = findViewById(R.id.check_sunflower);
        limestone_chk = findViewById(R.id.check_limestone);
        maizebrain_chk = findViewById(R.id.check_maizebran);
        cottonseedmeal = findViewById(R.id.check_cottonseedmeal);

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

                }else {
                    if(ismaize_chk){
                        dbHelper.deletingsinlecrop("Maize");
                    }
                    ismaize_chk = false;
                }
            }
        });

        bonemeal_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isbonemeal_chk = true;
                    dbHelper.insertdata("Bone Meal",0);

                }else {
                    if(isbonemeal_chk){
                        dbHelper.deletingsinlecrop("Bone Meal");
                    }
                    isbonemeal_chk = false;
                }
            }
        });

        //Setting up for cassava meal crop selection
        cassavameal_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iscassavameal_chk = true;
                    dbHelper.insertdata("Cassava Meal",0);

                }else {
                    if(iscassavameal_chk){
                        dbHelper.deletingsinlecrop("Cassava Meal");
                    }
                    iscassavameal_chk = false;
                }
            }
        });

        //Setting up for cassava peel crop selection
        cassavapeel_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iscassavapeel_chk = true;
                    dbHelper.insertdata("Cassava Peel",0);

                }else {
                    if(iscassavapeel_chk){
                        dbHelper.deletingsinlecrop("Cassava Peel");
                    }
                    iscassavapeel_chk = false;
                }
            }
        });


        //Setting up for beniseed crop selection
        beniseed_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isbeniseed_chk = true;
                    dbHelper.insertdata("Beniseed",0);

                }else {
                    if(isbeniseed_chk){
                        dbHelper.deletingsinlecrop("Beniseed");
                    }
                    isbeniseed_chk = false;
                }
            }
        });

        //Setting up for fish meal crop selection
        fishmeal_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isfishmeal_chk = true;
                    dbHelper.insertdata("Fish Meal",0);

                }else {
                    if(isfishmeal_chk){
                        dbHelper.deletingsinlecrop("Fish Meal");
                    }
                    isfishmeal_chk = false;
                }
            }
        });

        //Setting up for guinea corn crop selection
        guinea_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isguinea_chk = true;
                    dbHelper.insertdata("Guinea Corn",0);

                }else {
                    if(isguinea_chk){
                        dbHelper.deletingsinlecrop("Guinea Corn");
                    }
                    isguinea_chk = false;
                }
            }
        });


        //Setting up for maize bran crop selection
        maizebrain_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ismaizebran = true;
                    dbHelper.insertdata("Maize Bran",0);

                }else {
                    if(ismaizebran){
                        dbHelper.deletingsinlecrop("Maize Bran");
                    }
                    ismaizebran = false;
                }
            }
        });


        //Setting up for cotton seed meal crop selection
        cottonseedmeal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iscottonseedmeal_chk = true;
                    dbHelper.insertdata("Cotton Seed Meal",0);

                }else {
                    if(iscottonseedmeal_chk){
                        dbHelper.deletingsinlecrop("Cotton Seed Meal");
                    }
                    iscottonseedmeal_chk = false;
                }
            }
        });

        //Setting up for soyabean  crop selection
        soyabeanmeal_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    issoyebeanmeal_chk = true;
                    dbHelper.insertdata("Soyabean Meal",0);

                }else {
                    if(issoyebeanmeal_chk){
                        dbHelper.deletingsinlecrop("Soyabean Meal");
                    }
                    issoyebeanmeal_chk = false;
                }
            }
        });

        //Setting up for palm kernel  crop selection
        palmkernelcake_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ispalmkernel = true;
                    dbHelper.insertdata("Palm Kernel Cake",0);

                }else {
                    if(ispalmkernel){
                        dbHelper.deletingsinlecrop("Palm Kernel Cake");
                    }
                    ispalmkernel = false;
                }
            }
        });


        //Setting up for wheat bran  crop selection
        wheatbran_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iswheatbran = true;
                    dbHelper.insertdata("Wheat Bran",0);

                }else {
                    if(iswheatbran){
                        dbHelper.deletingsinlecrop("Wheat Bran");
                    }
                    iswheatbran = false;
                }
            }
        });

        //Setting up for millet crop selection
        millet_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ismillet = true;
                    dbHelper.insertdata("Millet",0);

                }else {
                    if(ismillet){
                        dbHelper.deletingsinlecrop("Millet");
                    }
                    ismillet = false;
                }
            }
        });

        //Setting up for sunflower crop selection
        sunflower_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    issunflower = true;
                    dbHelper.insertdata("Sunflower",0);

                }else {
                    if(issunflower){
                        dbHelper.deletingsinlecrop("Sunflower");
                    }
                    issunflower = false;
                }
            }
        });

        //Setting up for limestone crop selection
        limestone_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    islimestone = true;
                    dbHelper.insertdata("Limestone",0);

                }else {
                    if(islimestone){
                        dbHelper.deletingsinlecrop("Limestone");
                    }
                    islimestone = false;
                }
            }
        });

        //Setting up for acha crop selection
        acha_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isacha_chk = true;
                    dbHelper.insertdata("Acha",0);

                }else {
                    if(isacha_chk){
                        dbHelper.deletingsinlecrop("Acha");
                    }
                    isacha_chk = false;
                }
            }
        });

        //Setting up for blood meal crop selection
        bloodmeal_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isbloodmeal_chk = true;
                    dbHelper.insertdata("Blood Meal",0);

                }else {
                    if(isbloodmeal_chk){
                        dbHelper.deletingsinlecrop("Blood Meal");
                    }
                    isbloodmeal_chk = false;
                }
            }
        });

        //Setting up for brewers dried grain crop selection
        brewersDriedGrain_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isbrewers_chk = true;
                    dbHelper.insertdata("Brewers Dry Grain",0);

                }else {
                    if(isbrewers_chk){
                        dbHelper.deletingsinlecrop("Brewers Dry Grain");
                    }
                    isbrewers_chk = false;
                }
            }
        });


        rice_grain_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isrice_grain_chk = true;
                    dbHelper.insertdata("Rice grains",0);

                }else {
                    if(isrice_grain_chk){
                        dbHelper.deletingsinlecrop("Rice grains");
                    }
                    isrice_grain_chk = false;
                }
            }
        });

        rice_bran_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isrice_bran_chk = true;
                    dbHelper.insertdata("Rice bran",0);

                }else {
                    if(isrice_bran_chk){
                        dbHelper.deletingsinlecrop("Rice bran");
                    }
                    isrice_bran_chk = false;
                }
            }
        });

        sorghum_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    issorghum_chk = true;
                    dbHelper.insertdata("Sorghum grains",0);
                }else {
                    if(issorghum_chk){
                        dbHelper.deletingsinlecrop("Sorghum grains");
                    }
                    issorghum_chk = false;
                }
            }
        });

        cake_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iscake_chk = true;
                    dbHelper.insertdata("Groundnut cake",0);
                }else {
                    if(iscake_chk){
                        dbHelper.deletingsinlecrop("Groundnut cake");
                    }
                    iscake_chk = false;
                }
            }
        });

        cotton_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iscotton_chk = true;
                    dbHelper.insertdata("Cotton seed",0);
                }else {
                    if(iscotton_chk){
                        dbHelper.deletingsinlecrop("Cotton seed");
                    }
                    iscotton_chk = false;
                }
            }
        });

        bean_seeds_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isbean_seeds_chk = true;
                    dbHelper.insertdata("Soybean seeds (heat processed)",0);
                }else {
                    if(isbean_seeds_chk){
                        dbHelper.deletingsinlecrop("Soybean seeds (heat processed)");
                    }
                    isbean_seeds_chk = false;
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
            }
        });

    }

    public void openResultActivity(View view) {

        if(( ismaize_chk||isrice_grain_chk||isrice_bran_chk||issorghum_chk||iscake_chk||iscotton_chk||issesame_chk||isbean_seeds_chk||isbonemeal_chk|| iscottonseed_chk||isbrewers_chk||isacha_chk|| isbloodmeal_chk|| iscassavameal_chk|| iscassavapeel_chk||isbeniseed_chk||isfishmeal_chk||isgroundnutcake_chk||isguinea_chk||issoyebeanmeal_chk||iscottonseedmeal_chk||ispalmkernel|| iswheatbran||ismillet|| ismaizebran||issunflower||islimestone)){
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
