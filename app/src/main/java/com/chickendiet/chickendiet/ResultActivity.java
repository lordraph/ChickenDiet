package com.chickendiet.chickendiet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class ResultActivity extends AppCompatActivity {
    com.chickendiet.chickendiet.DbHelper dbHelper;
    TableLayout tableLayout;
//    TextView textView_energy_required, textView_protein_required, textView_lysine, textView_methionine;
//    TextView textview_fibre_required, textView_calcium, textView_phosphorus, textView_fat;
    TextView textView_energy_used, textView_protein_used, textView_lysine_used, textView_fat_used,textView_phosphorus_used;
    TextView textview_fibre_used, total_ingridient, total_cost_required, textView_methionine_used, textView_calcium_used;
//    TextView energy_status, protein_status, ether_status, fibre_status, required_qty;
    ArrayList<EditText> newarraylist;
    ArrayList<TextView> textViewArrayList;
    ArrayList<Double> proteinArrayList, etherArrayList, fibreArrayList,priceArrayList;
    ArrayList<Integer> energyArrayList;
    TextWatcher textWatcher;
    double total_protein_used, total_ether_used, total_fibre_used,total_energy_used;
    int saved_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        dbHelper = new com.chickendiet.chickendiet.DbHelper(this);
        tableLayout = (TableLayout)findViewById(R.id.ingridient_table);

//        textView_energy_required = (TextView)findViewById(R.id.energy_required);
//        textView_protein_required = (TextView)findViewById(R.id.protein_required);
//        textView_lysine = (TextView)findViewById(R.id.lys);
//        textview_fibre_required = (TextView)findViewById(R.id.fibre_required);
//        total_cost_required = (TextView)findViewById(R.id.total_required);

        textView_energy_used = (TextView)findViewById(R.id.energy_used);
        textView_protein_used = (TextView)findViewById(R.id.protein_used);
        textView_lysine_used = (TextView)findViewById(R.id.lysine_used);
        textview_fibre_used = (TextView)findViewById(R.id.fibre_used);
        total_ingridient = (TextView)findViewById(R.id.total_used);


//        energy_status = (TextView)findViewById(R.id.energy_status);
//        protein_status = (TextView)findViewById(R.id.protein_status);
//        ether_status = (TextView)findViewById(R.id.ether_status);
//        fibre_status = (TextView)findViewById(R.id.fibre_status);
//        required_qty = (TextView)findViewById(R.id.total_status);


        generateCrop();
        load_nutrient_content();
        autocalc();
        loadContent();

    }

    public void load_nutrient_content(){
        Cursor load_bird_type = dbHelper.querry_bird_selector();
        load_bird_type.moveToFirst();
        String bird_type = load_bird_type.getString(1);
        Cursor bird_requirement = dbHelper.querry_table_requirement();
        while(bird_requirement.moveToNext()){
            if(bird_requirement.getString(1).equals(bird_type)){
                textView_energy_required.setText(valueOf(bird_requirement.getInt(2)));
                textView_protein_required.setText(valueOf(bird_requirement.getDouble(3)));
                textView_ether_required.setText(valueOf(bird_requirement.getDouble(4)));
                textview_fibre_required.setText(valueOf(bird_requirement.getDouble(5)));
            }
        }

    }

    public void autocalc(){

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculateEnergy();

            }

            @Override
            public void afterTextChanged (Editable s){

            }
        }

        ;


        for(
                EditText editText:newarraylist)

        {
            editText.addTextChangedListener(textWatcher);

        }

    }

    public void calculateEnergy() {

        //Declare nutrient variables
        int total = 0;
        double price_values = 0;
        int edit_no;
        int crop_edit_no;
        double sum_protein = 0;
        double sum_energy = 0;
        double sum_ether = 0;
        double sum_fibre = 0;


        //Calculate the total quantity of crop used
        for (EditText editText : newarraylist) {

            if (!(editText.getText().toString().equals(""))) {
                edit_no = Integer.valueOf(editText.getText().toString());
            } else {
                edit_no = 0;
            }
            total = total + edit_no;


        }



        //Calculate the nutrient content
        for (int i = 0; i < newarraylist.size(); i++) {
//                       TextView getText_view = textViewArrayList.get(i);
            EditText editText_no = newarraylist.get(i);
            if (!(editText_no.getText().toString().equals(""))) {
                crop_edit_no = Integer.valueOf(editText_no.getText().toString());
            } else {
                crop_edit_no = 0;
            }
            sum_energy = sum_energy + (Double.valueOf(energyArrayList.get(i)) * ((double)crop_edit_no / 100.00));
            sum_protein = sum_protein + (((double) crop_edit_no / 100.00) * (proteinArrayList.get(i)));
            sum_ether = sum_ether + (((double)crop_edit_no / 100.00) * etherArrayList.get(i));
            sum_fibre = sum_fibre + (((double)crop_edit_no / 100.00) * (fibreArrayList.get(i)));
            price_values = price_values + ((double)crop_edit_no * priceArrayList.get(i));

        }


        //Display the result
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        textView_energy_used.setText(decimalFormat.format(sum_energy));
        textView_protein_used.setText(decimalFormat.format(sum_protein));
        textView_ether_used.setText(decimalFormat.format(sum_ether));
        textview_fibre_used.setText(decimalFormat.format(sum_fibre));
        total_ingridient.setText(decimalFormat.format(total));
        total_cost_required.setText(decimalFormat.format(price_values));


        //Store the result
        total_energy_used = sum_energy;
        total_protein_used = sum_protein;
        total_ether_used = sum_ether;
        total_fibre_used = sum_fibre;

        //Display the status

        double energy_required_no;

        double protein_required_no;

        double ether_required_no;

        double fibre_required_no;



        energy_required_no = Double.valueOf(textView_energy_required.getText().toString());
        protein_required_no = Double.valueOf(textView_protein_required.getText().toString());
        ether_required_no = Double.valueOf(textView_ether_required.getText().toString());
        fibre_required_no = Double.valueOf(textview_fibre_required.getText().toString());


        if(sum_energy == energy_required_no){
            energy_status.setText("Appropriate");
            energy_status.setTextColor(Color.GREEN);
        }else if (sum_energy < energy_required_no){
            energy_status.setText("Deficient");
            energy_status.setTextColor(Color.RED);
        }else if (sum_energy > energy_required_no){
            energy_status.setText("Excess");
            energy_status.setTextColor(Color.RED);
        }

//               Toast.makeText(FeedFormulation.this, "energery_required: "+ energy_required_no,Toast.LENGTH_SHORT).show();
//               Toast.makeText(FeedFormulation.this, "sum_energy: "+ energy_required_no,Toast.LENGTH_SHORT).show();

        if(sum_protein == protein_required_no){
            protein_status.setText("Appropriate");
            protein_status.setTextColor(Color.GREEN);
        }else if (sum_protein < protein_required_no){
            protein_status.setText("Deficient");
            protein_status.setTextColor(Color.RED);
        }else if (sum_protein > protein_required_no){
            protein_status.setText("Excess");
            protein_status.setTextColor(Color.RED);
        }



        if(sum_ether == ether_required_no){
            ether_status.setText("Appropriate");
            ether_status.setTextColor(Color.GREEN);
        }else if (sum_ether < ether_required_no){
            ether_status.setText("Deficient");
            ether_status.setTextColor(Color.RED);
        }else if (sum_ether > ether_required_no){
            ether_status.setText("Excess");
            ether_status.setTextColor(Color.RED);
        }


        if(sum_fibre == fibre_required_no){
            fibre_status.setText("Appropriate");
            fibre_status.setTextColor(Color.GREEN);
        }else if (sum_fibre < fibre_required_no){
            fibre_status.setText("Deficient");
            fibre_status.setTextColor(Color.RED);
        }else if (sum_fibre > fibre_required_no){
            fibre_status.setText("Excess");
            fibre_status.setTextColor(Color.RED);
        }


        if(total == 100){
            required_qty.setText("Appropriate");
            required_qty.setTextColor(Color.GREEN);
        }else if (total < 100){
            required_qty.setText("Deficient");
            required_qty.setTextColor(Color.RED);
        }else if (total > 100){
            required_qty.setText("Excess");
            required_qty.setTextColor(Color.RED);
        }


        //cost price



    }


    public void loadContent(){
        proteinArrayList = new ArrayList<>();
        etherArrayList = new ArrayList<>();
        fibreArrayList = new ArrayList<>();
        energyArrayList =  new ArrayList<>();
        priceArrayList = new ArrayList<>();

        for(TextView textView:textViewArrayList){
            Cursor whole_table = dbHelper.querry_table_content();
//                   Toast.makeText(FeedFormulation.this, "text 1: "+ textView.getText().toString(),Toast.LENGTH_SHORT).show();
            while(whole_table.moveToNext()){

//                       Toast.makeText(FeedFormulation.this, "text 2: "+ whole_table.getString(1),Toast.LENGTH_SHORT).show();

                if (textView.getText().toString().equals(whole_table.getString(1))){
//                           Toast.makeText(FeedFormulation.this, "text 3: "+ whole_table.getString(1),Toast.LENGTH_SHORT).show();
                    energyArrayList.add(whole_table.getInt(3));
                    proteinArrayList.add(whole_table.getDouble(2));
                    etherArrayList.add(whole_table.getDouble(4));
                    fibreArrayList.add(whole_table.getDouble(5));
                    priceArrayList.add(whole_table.getDouble(7));
                }
            }

        }

    }


    public void generateCrop() {
        Cursor cursor = dbHelper.querry_Selector_table();
        newarraylist = new ArrayList<>();
        textViewArrayList = new ArrayList<>();

        while (cursor.moveToNext()) {
            TableRow new_row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            new_row.setLayoutParams(lp);

            TextView tv_1 = new TextView(this);
            tv_1.setText(cursor.getString(1));
            textViewArrayList.add(tv_1);
            new_row.addView(tv_1);

            EditText editText = new EditText(this);
            editText.setText(valueOf(cursor.getInt(2)));
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setGravity(Gravity.CENTER);
            newarraylist.add(editText);
            new_row.addView(editText);

            tableLayout.addView(new_row);
        }
    }


    public void openFeedSummaryActivity(View view) {
        saved_time = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this);
        builder.setMessage("Are Sure you want to Save?");
        final EditText editText1 = new EditText(ResultActivity.this);
        editText1.setHint("type name to save");
        editText1.setAllCaps(true);
        builder.setView(editText1);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (!(editText1.getText().toString().equals(""))) {
                    Cursor cursor1 = dbHelper.querry_bird_selector();
                    cursor1.moveToFirst();
                    dbHelper.insertdata_listView(cursor1.getString(1), String.valueOf(editText1.getText().toString()));

                    Cursor cursor = dbHelper.querry_form_table();
                    cursor.moveToFirst();
                    int form_no = cursor.getInt(1);
                    for (int i = 0; i < newarraylist.size(); i++) {
                        EditText editText = newarraylist.get(i);
                        TextView textView = textViewArrayList.get(i);

                        dbHelper.insertdata_save(textView.getText().toString() + " (kg)",  String.valueOf(editText1.getText().toString()), Double.valueOf(editText.getText().toString()));
                    }

                    dbHelper.insertdata_save("Total cost(#)",  String.valueOf(editText1.getText().toString()), Double.valueOf(total_cost_required.getText().toString()));
//                        saved_time = 1;
                    Intent intent = new Intent(ResultActivity.this, SavedActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ResultActivity.this,"Please Enter a Name to save", Toast.LENGTH_SHORT).show();
                }

            }

        });

        AlertDialog.Builder builder1 = builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                    saved_time = 1;
                Intent intent = new Intent(ResultActivity.this, SavedActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
