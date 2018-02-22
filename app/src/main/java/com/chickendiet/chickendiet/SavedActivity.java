package com.chickendiet.chickendiet;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedActivity extends AppCompatActivity {
    ListView listView;
    com.chickendiet.chickendiet.DbHelper dbHelper;
    ArrayList<String> stringArrayListt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        listView = (ListView)findViewById(R.id.listView_existing);
        dbHelper = new com.chickendiet.chickendiet.DbHelper(this);

        loadarray();
    }

    public void loadarray(){
        Cursor cursor2 = dbHelper.querry_listview_table();
//        cursor2.moveToFirst();
//        Toast.makeText(ExistingFeedActivity.this,"No of form: " + cursor2.getCount(),Toast.LENGTH_SHORT).show();
        stringArrayListt = new ArrayList<String>();

        while (cursor2.moveToNext()){
            stringArrayListt.add(cursor2.getString(2));
//            Toast.makeText(ExistingFeedActivity.this,"String 1: " + cursor2.getString(1),Toast.LENGTH_SHORT).show();
//            Toast.makeText(ExistingFeedActivity.this,"String 2: " + cursor2.getString(2),Toast.LENGTH_SHORT).show();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.text_list_view,R.id.textView_id,stringArrayListt);
        listView.setAdapter(arrayAdapter);
//        Toast.makeText(ExistingFeedActivity.this,"String: " + stringArrayListt.get(0),Toast.LENGTH_SHORT).show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tag_name = (String)listView.getItemAtPosition(position);
                Intent intent = new Intent(SavedActivity.this, FeedSummary.class);
                intent.putExtra("name", tag_name);
                startActivity(intent);
            }
        });

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        String[] arrayString = stringArrayListt.toArray(new String[stringArrayListt.size()]);
        if(v.getId()==R.id.listView_existing){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle(arrayString[info.position]);
            menu.add(Menu.NONE,0,0,getResources().getString(R.string.optionItem));
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        String[] arrayString = stringArrayListt.toArray(new String[stringArrayListt.size()]);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuCount = item.getItemId();
        String get_string = arrayString[info.position];
//        String[] array_string = get_string();
//        String read_string = array_string[array_string.length-1];


        dbHelper.deletelist_view_row(get_string);
        finish();
        Intent intent = new Intent(this,SavedActivity.class);
        startActivity(intent);

        return true;
    }
}
