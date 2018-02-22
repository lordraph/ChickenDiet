package com.chickendiet.chickendiet;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class ResultActivity extends AppCompatActivity {
    com.chickendiet.chickendiet.DbHelper dbHelper;
    ArrayList<EditText> newarraylist;
    ArrayList<TextView> textViewArrayList;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        dbHelper = new com.chickendiet.chickendiet.DbHelper(this);
        tableLayout = (TableLayout)findViewById(R.id.ingridient_table);

        generateCrop();
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
}
