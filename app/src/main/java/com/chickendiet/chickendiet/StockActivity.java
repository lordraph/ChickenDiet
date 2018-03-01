package com.chickendiet.chickendiet;


/**
 * Created by Tolulope Ogunjuyigbe on 10/23/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class StockActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        mListView = findViewById(R.id.listview);
        ArrayList<Card> list = new ArrayList<>();
        list.add(new Card("drawable://" + R.drawable.acha, "Acha", "Energy(%): 3939", "Crude Protein(%): 7.42",
                "Crude Fibre(%): 0.35", "Lysine(%): -", "Methionine(%): -", "Calcium(%): -", "Phosphorus(%): 0.32", "Fats(%): 13"));
        list.add(new Card("drawable://" + R.drawable.bloodmeal, "Blood Meal", "Energy(%): 3080", "Crude Protein(%): 80",
                "Crude Fibre(%): 10", "Lysine(%): 6.9", "Methionine(%): 1.01", "Calcium(%): 0.28", "Phosphorus(%): 0.28", "Fats(%): 10"));
        list.add(new Card("drawable://" + R.drawable.brewers, "Brewers Dried Grain", "Energy(%): 2513", "Crude Protein(%): 27.90",
                "Crude Fibre(%): 11.70", "Lysine(%): 0.90", "Methionine(%): -", "Calcium(%): 30", "Phosphorus(%): 0.88", "Fats(%): 7.4"));
        list.add(new Card("drawable://" + R.drawable.bonemeal, "Bone Meal", "Energy(%): -", "Crude Protein(%): -",
                "Crude Fibre(%): -", "Lysine(%): -", "Methionine(%): -", "Calcium(%): 37", "Phosphorus(%): 15", "Fats(%): -"));
        list.add(new Card("drawable://" + R.drawable.cashew, "Cashew Nut Meal ", "Energy(%): -", "Crude Protein(%): 40.9",
                "Crude Fibre(%): 150", "Lysine(%): 0.86", "Methionine(%): 0.35", "Calcium(%): 0.06", "Phosphorus(%): 1.72", "Fats(%): 13"));
        list.add(new Card("drawable://" + R.drawable.cassavameal, "Cassava Meal", "Energy(%): 3909", "Crude Protein(%): 2.50",
                "Crude Fibre(%): 3.50", "Lysine(%): 0.04", "Methionine(%): 0.022", "Calcium(%): 0.18", "Phosphorus(%): 0.19", "Fats(%): 0.3"));
        list.add(new Card("drawable://" + R.drawable.cassavapeel, "Cassava Peel", "Energy(%): 2423", "Crude Protein(%): 5",
                "Crude Fibre(%): 9.5", "Lysine(%): -", "Methionine(%): -", "Calcium(%): -", "Phosphorus(%): -", "Fats(%): 5.8"));
        list.add(new Card("drawable://" + R.drawable.cottonseedmeal, "Cotton Seed Meal", "Energy(%): 2079", "Crude Protein(%): 25",
                "Crude Fibre(%): 25.10", "Lysine(%): 0.54", "Methionine(%): 5.30", "Calcium(%): 0.15", "Phosphorus(%): 0.90", "Fats(%): 1.50"));
        list.add(new Card("drawable://" + R.drawable.beniseed, "Beni seed", "Energy(%): 5820", "Crude Protein(%): 25",
                "Crude Fibre(%): 6.30", "Lysine(%): 3.5", "Methionine(%): 3.80", "Calcium(%): 1.06", "Phosphorus(%): 0.47", "Fats(%): 49.1"));
        list.add(new Card("drawable://" + R.drawable.fishmeal, "Fish Meal", "Energy(%): 2860", "Crude Protein(%): 65",
                "Crude Fibre(%): 1.00", "Lysine(%): 4.60", "Methionine(%): 2.80", "Calcium(%): 6.10", "Phosphorus(%): 3.0", "Fats(%): 4.5"));
        list.add(new Card("drawable://" + R.drawable.groundnutcake, "Groundnut Cake", "Energy(%): 2540", "Crude Protein(%): 45",
                "Crude Fibre(%): 5.0", "Lysine(%): 1.60", "Methionine(%): 0.48", "Calcium(%): 0.20", "Phosphorus(%): 0.20", "Fats(%): 6"));
        list.add(new Card("drawable://" + R.drawable.maize, "Maize ", "Energy(%): 3432", "Crude Protein(%): 8.90",
                "Crude Fibre(%): 2.0", "Lysine(%): 0.25", "Methionine(%): 0.18", "Calcium(%): 0.01", "Phosphorus(%): 0.09", "Fats(%): 3.7"));
        list.add(new Card("drawable://" + R.drawable.guineacorn, "Guinea Corn ", "Energy(%): 3300", "Crude Protein(%): 11",
                "Crude Fibre(%): 6", "Lysine(%): 0.35", "Methionine(%): 10", "Calcium(%): 0.04", "Phosphorus(%): 0.32", "Fats(%): 2.0"));
        list.add(new Card("drawable://" + R.drawable.soyabeanmeal, "Soyabean Meal", "Energy(%): 2700", "Crude Protein(%): 44",
                "Crude Fibre(%): 6.5", "Lysine(%): 2.80", "Methionine(%): 0.59", "Calcium(%): 0.20", "Phosphorus(%): 0.60", "Fats(%): 0.80"));
        list.add(new Card("drawable://" + R.drawable.palmkernelcake, "Palm Kernel Cake", "Energy(%): 2175", "Crude Protein(%): 18",
                "Crude Fibre(%): 12", "Lysine(%): 0.64", "Methionine(%): 0.39", "Calcium(%): 0.21", "Phosphorus(%): 0.16", "Fats(%): 6.00"));
        list.add(new Card("drawable://" + R.drawable.wheatbran, "Wheat Bran", "Energy(%): 1870", "Crude Protein(%): 16",
                "Crude Fibre(%): 8.50", "Lysine(%): 0.90", "Methionine(%): 0.25", "Calcium(%): 0.10", "Phosphorus(%): 0.30", "Fats(%): 1.90"));
        list.add(new Card("drawable://" + R.drawable.ricebran, "Rice Bran", "Energy(%): 1319", "Crude Protein(%): 6.0",
                "Crude Fibre(%): 36.60", "Lysine(%): 0.16", "Methionine(%): 0.06", "Calcium(%): 0.17", "Phosphorus(%): 0.49", "Fats(%): 7.90"));
        list.add(new Card("drawable://" + R.drawable.millet, "Millet", "Energy(%): 2984", "Crude Protein(%): 11.50",
                "Crude Fibre(%): 6.50", "Lysine(%): 0.23", "Methionine(%): 0.15", "Calcium(%): 0.05", "Phosphorus(%): 0.30", "Fats(%): 3.60"));
        list.add(new Card("drawable://" + R.drawable.maizebran, "Maize Bran", "Energy(%): 2784", "Crude Protein(%): 11.50",
                "Crude Fibre(%): 10.50", "Lysine(%): -", "Methionine(%): -", "Calcium(%): -", "Phosphorus(%): -", "Fats(%): 170"));
        list.add(new Card("drawable://" + R.drawable.sunflower, "Sunflower", "Energy(%): 2310", "Crude Protein(%): 41",
                "Crude Fibre(%): 13", "Lysine(%): 1.52", "Methionine(%): 0.72", "Calcium(%): 0.43", "Phosphorus(%): 1.0", "Fats(%): 28.0"));
        list.add(new Card("drawable://" + R.drawable.limestone, "Limestone", "Energy(%): -", "Crude Protein(%): -",
                "Crude Fibre(%): -", "Lysine(%): -", "Methionine(%): -", "Calcium(%): 35", "Phosphorus(%): 0.05", "Fats(%): -"));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.stock_cardview, list);
        mListView.setAdapter(adapter);
    }
}
