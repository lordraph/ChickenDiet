package com.chickendiet.chickendiet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    private Button buttonBrooder, buttonLayer, buttonGrower;
    Context context = this;
    com.chickendiet.chickendiet.DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new com.chickendiet.chickendiet.DbHelper(this);
        dbHelper.deletingsinlecrop_whole();

        buttonBrooder = (Button)findViewById(R.id.btn_brooder);
        buttonBrooder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = {"Formulate Diet"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setItems(items, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int item){
                       Intent intent = new Intent(MainActivity.this, FormulateActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        buttonLayer = (Button)findViewById(R.id.btn_layer);
        buttonLayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = {"Formulate Diet"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setItems(items, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int item){
                        Intent intent = new Intent(MainActivity.this, FormulateActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        buttonGrower = (Button)findViewById(R.id.btn_grower);
        buttonGrower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = {"Formulate Diet"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setItems(items, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int item){
                        Intent intent = new Intent(MainActivity.this, FormulateActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });




        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        break;
                    case R.id.nav_stock:
                        Intent intent1 = new Intent(MainActivity.this, StockActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_formulate:
                        Intent intent2 = new Intent(MainActivity.this, FormulateActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_More:
                        Intent intent3 = new Intent(MainActivity.this, MoreActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_saved:
                        Intent intent4 = new Intent(MainActivity.this, SavedActivity.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });

    }
}
