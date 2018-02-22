package com.chickendiet.chickendiet;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class FeedSummary extends AppCompatActivity {
    com.chickendiet.chickendiet.DbHelper dbHelper;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_summary);

        dbHelper = new com.chickendiet.chickendiet.DbHelper(this);

        tableLayout = (TableLayout)findViewById(R.id.summary_table);


        load_summary();
    }

    public void load_summary(){
        Cursor cursor = dbHelper.querry_save_table();

        String address = getIntent().getStringExtra("name");

//        Toast.makeText(FeedSummary.this,"position: " + address,Toast.LENGTH_SHORT).show();
        if(!(address.equals(""))){
            while (cursor.moveToNext()) {
//                Toast.makeText(FeedSummary.this,"String: " + cursor.getString(2),Toast.LENGTH_SHORT).show();
                if (cursor.getString(2).equals(address)) {

                    TableRow tableRow = new TableRow(this);
                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    tableRow.setLayoutParams(lp);

                    TextView descr_text = new TextView(this);
                    descr_text.setText(cursor.getString(1));
                    descr_text.setGravity(Gravity.START);
                    tableRow.addView(descr_text);

                    TextView save_value = new TextView(this);
                    save_value.setText(String.valueOf(cursor.getDouble(3)));
                    save_value.setGravity(Gravity.START);
                    tableRow.addView(save_value);

                    tableLayout.addView(tableRow);
                }
            }
        }




    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
