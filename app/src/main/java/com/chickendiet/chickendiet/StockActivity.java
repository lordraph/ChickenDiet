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

        mListView = (ListView) findViewById(R.id.listview);
        ArrayList<Card> list = new ArrayList<>();
        list.add(new Card ("drawable://" + R.drawable.acha, "Acha"));
        list.add(new Card ("drawable://" + R.drawable.bloodmeal, "Blood Meal"));
        list.add(new Card ("drawable://" + R.drawable.brewers, "Brewers Dried Grain"));
        list.add(new Card ("drawable://" + R.drawable.bonemeal, "Bone Meal"));
        list.add(new Card ("drawable://" + R.drawable.cashew, "Cashew Nut Meal "));
        list.add(new Card ("drawable://" + R.drawable.cassavameal, "Cassava Meal"));
        list.add(new Card ("drawable://" + R.drawable.cassavapeel, "Cassava Peel"));
        list.add(new Card ("drawable://" + R.drawable.cottonseedmeal, "Cotton Seed Meal"));
        list.add(new Card ("drawable://" + R.drawable.beniseed, "Beni seed"));
        list.add(new Card ("drawable://" + R.drawable.fishmeal, "Fish Meal"));
        list.add(new Card ("drawable://" + R.drawable.groundnutcake, "Groundnut Cake"));
        list.add(new Card ("drawable://" + R.drawable.maize, "Maize "));
        list.add(new Card ("drawable://" + R.drawable.guineacorn, "Guinea Corn "));
        list.add(new Card ("drawable://" + R.drawable.soyabeanmeal, "Soyabean Meal"));
        list.add(new Card ("drawable://" + R.drawable.palmkernelcake, "Palm Kernel Cake"));
        list.add(new Card ("drawable://" + R.drawable.wheatbran, "Wheat Bran"));
        list.add(new Card ("drawable://" + R.drawable.ricebran, "Rice Bran  "));
        list.add(new Card ("drawable://" + R.drawable.millet, "Millet "));
        list.add(new Card ("drawable://" + R.drawable.maizebran, "Maize Bran  "));
        list.add(new Card ("drawable://" + R.drawable.sunflower, "Sunflower "));
        list.add(new Card ("drawable://" + R.drawable.limestone, "Limestone"));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.stock_cardview, list);
        mListView.setAdapter(adapter);
    }
}
