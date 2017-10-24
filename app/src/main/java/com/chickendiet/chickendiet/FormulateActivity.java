package com.chickendiet.chickendiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FormulateActivity extends AppCompatActivity {

    ArrayAdapter<String> adapterchicken, adapteringredient;
    Spinner spinnerChicken, spinnerIngredient;
    String[] chicken = {"Layer", "Brooder", "Grower"};
    String[] ingredient = {"Acha", "Blood Meal", "Brewers dried grain", "Bone Meal", "Cashew nut meal", "Cassava meal", "Cassava peel",
                            "Cotton Seed Meal", "Beni seed", "Fish meal", "Groudnut cake", "Maize", "Guinea corn", "Soyabean Meal"
                            , "Palm kernel cake", "wheat Bran", "Rice offal", "Rice bran", "Millet", "Maize bran", "Sunflower", "Limestone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulate);

        spinnerChicken = (Spinner)findViewById(R.id.spinner_chicken);
        spinnerIngredient = (Spinner)findViewById(R.id.spinner_ingredient);

        adapterchicken = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, chicken);
        spinnerChicken.setAdapter(adapterchicken);
        adapterchicken.setDropDownViewResource(R.layout.spinner_item);
        spinnerChicken.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        adapteringredient = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ingredient);
        spinnerIngredient.setAdapter(adapteringredient);
        adapteringredient.setDropDownViewResource(R.layout.spinner_item);
        spinnerIngredient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    public void openResultActivity(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
