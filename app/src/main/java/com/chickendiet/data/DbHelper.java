package com.chickendiet.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Prof Ogunjuyigbe on 6/14/2017.
 */

public class DbHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "chicken.db";

    private static final String TABLE_NAME_INGREDIENT_SELECTION = "ingredient_selection";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SELECT_INGREDIENT = "selected_ingredient";
    private static final String COLUMN_QUANTITY= "Qty_required";

    private static final String TABLE_NAME_BIRD_SELECTION = "bird_selection";
    private static final String COLUMN_BIRD_CATEGORY = "bird_category";
    private static final String COLUMN_NO_FORMULATION = "no_of_formulation";

    private static final String TABLE_NAME_NUTRIENT_CONTENT = "nutrient_crop";
    private static final String COLUMN_NUTRIENT_CLASS = "nutrient_class";
    private static final String COLUMN_ENERGY_CONTENT = "energy";
    private static final String COLUMN_PROTEIN_CONTENT= "protein";
    private static final String COLUMN_ETHER_EXTRACT_CONTENT = "ether_extract";
    private static final String COLUMN_CRUDE_FIBRE_CONTENT = "fibre";
    private static final String COLUMN_CALCIUM_CONTENT = "Qty_Avail";
    private static final String COLUMN_PHOSPHORUS_CONTENT= "price";

    private static final String TABLE_NAME_NUTRIENT_REQUIREMENT = "nutrient_requirement";
    private static final String COLUMN_BIRD_CLASS = "bird_class";
    private static final String COLUMN_ENERGY_REQUIREMENT = "energy";
    private static final String COLUMN_PROTEIN_REQUIREMENT= "protein";
    private static final String COLUMN_PHOSPHORUS_REQUIREMENT= "phosphorus";
    private static final String COLUMN_CALCIUM_REQUIREMENT = "calcium";

    private static final String TABLE_NAME_SAVING = "save";
    private static final String COLUMN_DESCR = "description";
    private static final String COLUMN_FORMU= "noformulation";
    private static final String COLUMN_VALUE= "value";


    private static final String TABLE_NAME_FORM_NO = "Formulation_No";
    private static final String COLUMN_INT_NO= "No_times";

    private static final String TABLE_NAME_LIST_VIEW = "category_bird_table";
    private static final String COLUMN_BIRD_NO= "cate_bird";
    private static final String COLUMN_INT_REAL= "mem_int";
    private static final String COLUMN_INT_TExT= "meme_real";


    public DbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CROP_TABLE = "create table " + TABLE_NAME_INGREDIENT_SELECTION + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SELECT_INGREDIENT + " TEXT," + COLUMN_QUANTITY + " INTEGER)" ;

        String CROP_SAVE = "create table " + TABLE_NAME_LIST_VIEW + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_BIRD_NO +" TEXT," + COLUMN_INT_TExT + " TEXT," + COLUMN_INT_REAL + " INTEGER)" ;

        String bird_table = "create table " + TABLE_NAME_BIRD_SELECTION + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_BIRD_CATEGORY + " TEXT," + COLUMN_NO_FORMULATION + " INTEGER)";

        String CROP_NUTRIENT_TABLE = "create table " + TABLE_NAME_NUTRIENT_CONTENT + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,nutrient_class TEXT, energy INTEGER,protein REAL,ether_extract REAL,fibre REAL,Qty_Avail REAL,price REAL)" ;

        String NUTRIENT_REQUIREMENT_TABLE = "create table " + TABLE_NAME_NUTRIENT_REQUIREMENT + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,bird_class TEXT,energy INTEGER,protein REAL,phosphorus REAL,calcium REAL)" ;

        String save_table = "create table " + TABLE_NAME_SAVING + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DESCR + " TEXT," +  COLUMN_FORMU + " TEXT," + COLUMN_VALUE + " REAL)";

        String FORM_TABLE = "create table " + TABLE_NAME_FORM_NO + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_INT_NO + " INTEGER)" ;


        String insert_data = "INSERT INTO " + TABLE_NAME_BIRD_SELECTION + " (" + COLUMN_BIRD_CATEGORY + "," + COLUMN_NO_FORMULATION + ") VALUES ('bird', 0)";

        db.execSQL(bird_table);
        db.execSQL(CROP_SAVE);
        db.execSQL(CROP_TABLE);
        db.execSQL(CROP_NUTRIENT_TABLE);
        db.execSQL(NUTRIENT_REQUIREMENT_TABLE);
        db.execSQL(save_table);
        db.execSQL(insert_data);
        db.execSQL(FORM_TABLE);

        db.execSQL("INSERT INTO " + TABLE_NAME_FORM_NO + " (No_times) VALUES (0)");

        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Maize',3350,8.5,3.8,2.2,30,200.00)");

        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Rice grains',2990,8.7,0.7,9.8,20,450.00)");

        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Rice bran',2980,12.9,13,11.4,25,400.00)");

        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Sorghum grains',3288,8.8,2.9,2.3,50,100.00)");

        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Groundnut cake',2500,42,7.3,12,150,350.00)");
        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Cotton seed',2320,40.9,3.9,12,120,120.00)");

        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Sesame seed or meal',2210,43.8,6.5,7,70,200.00)");
        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_CONTENT + " (nutrient_class,energy,protein,ether_extract,fibre,Qty_Avail,price) VALUES ('Soybean seeds (heat processed)',3300,37,18,5.5,80,500.00)");
        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_REQUIREMENT + " (bird_class,energy,protein,phosphorus,calcium) VALUES ('Brooder',2800,18,0.40,0.80)");
        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_REQUIREMENT + " (bird_class,energy,protein,phosphorus,calcium) VALUES ('Grower',2900,16.0,0.33,0.65)");
        db.execSQL("INSERT INTO " + TABLE_NAME_NUTRIENT_REQUIREMENT + " (bird_class,energy,protein,phosphorus,calcium) VALUES ('Layer',2900,17,0.32,3.40)");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE = "DROP TABLE IF EXITS ";
        db.execSQL(SQL_DELETE + TABLE_NAME_NUTRIENT_REQUIREMENT);
        db.execSQL(SQL_DELETE + TABLE_NAME_BIRD_SELECTION);
        db.execSQL(SQL_DELETE + TABLE_NAME_NUTRIENT_CONTENT);
        db.execSQL(SQL_DELETE + TABLE_NAME_INGREDIENT_SELECTION);
        db.execSQL(SQL_DELETE + TABLE_NAME_SAVING);
        db.execSQL(SQL_DELETE + TABLE_NAME_FORM_NO);
        db.execSQL(SQL_DELETE + TABLE_NAME_LIST_VIEW);
        onCreate(db);
    }

    public boolean insertdata(String selectCrop, int qty_required) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SELECT_INGREDIENT, selectCrop);
        contentValues.put(COLUMN_QUANTITY, qty_required);
        long checkifdata = db.insert(TABLE_NAME_INGREDIENT_SELECTION, null, contentValues);
        db.close();

        return checkifdata != -1;
    }


    public boolean insertdata(String bird_category, Integer no_formulation){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BIRD_CATEGORY,bird_category);
        contentValues.put(COLUMN_NO_FORMULATION,no_formulation);
        long checkifdata = db.insert(TABLE_NAME_BIRD_SELECTION,null,contentValues);
        db.close();

        return checkifdata != -1;

    }

    public boolean update_bird_selection(String bird_category, Integer no_formulation){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BIRD_CATEGORY,bird_category);
        contentValues.put(COLUMN_NO_FORMULATION,no_formulation);
        long checkifdata = db.update(TABLE_NAME_BIRD_SELECTION,contentValues,null,null);
        db.close();

        return checkifdata != -1;

    }

    public boolean firstdata(){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BIRD_CATEGORY,"bird");
        contentValues.put(COLUMN_NO_FORMULATION,0);
        long checkifdata = db.update(TABLE_NAME_BIRD_SELECTION,contentValues,null,null);
        db.close();

        return checkifdata != -1;

    }


    public boolean insertdata(String descr, String formu, String value){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DESCR,descr);
        contentValues.put(COLUMN_FORMU,formu);
        contentValues.put(COLUMN_VALUE,value);
        long checkifdata = db.insert(TABLE_NAME_SAVING,null,contentValues);
        db.close();

        return checkifdata != -1;

    }

    //here
    public boolean insertdata(String bird_class, int energy, int protein, float phosphorus, float calcium){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BIRD_CLASS,bird_class);
        contentValues.put(COLUMN_ENERGY_REQUIREMENT,energy);
        contentValues.put(COLUMN_PROTEIN_REQUIREMENT,protein);
        contentValues.put(COLUMN_PHOSPHORUS_REQUIREMENT,phosphorus);
        contentValues.put(COLUMN_CALCIUM_REQUIREMENT,calcium);
        long checkifdata = db.insert(TABLE_NAME_NUTRIENT_REQUIREMENT,null,contentValues);
        db.close();

        return checkifdata != -1;

    }


    public boolean insertdata(String nutruent_class, int energy, float protein, float ether_extract, float crude_fibre, float calcium,float phosphorus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NUTRIENT_CLASS,nutruent_class);
        contentValues.put(COLUMN_ENERGY_CONTENT,energy);
        contentValues.put(COLUMN_PROTEIN_CONTENT,protein);
        contentValues.put(COLUMN_ETHER_EXTRACT_CONTENT,ether_extract);
        contentValues.put(COLUMN_CRUDE_FIBRE_CONTENT,crude_fibre);
        contentValues.put(COLUMN_CALCIUM_CONTENT,calcium);
        contentValues.put(COLUMN_PHOSPHORUS_CONTENT,phosphorus);

        long checkifdata = db.insert(TABLE_NAME_NUTRIENT_CONTENT,null,contentValues);
        db.close();

        return checkifdata != -1;

    }

    public boolean insertdata_save(String descr_id, String form_no, double value){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DESCR,descr_id);
        contentValues.put(COLUMN_FORMU,form_no);
        contentValues.put(COLUMN_VALUE,value);

        long checkifdata = db.insert(TABLE_NAME_SAVING,null,contentValues);
        db.close();

        return checkifdata != -1;


    }


    public boolean insertdata_listView(String list_cate, String text_info){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BIRD_NO,list_cate);
        contentValues.put(COLUMN_INT_TExT,text_info);
        contentValues.put(COLUMN_INT_REAL,1);


        long checkifdata = db.insert(TABLE_NAME_LIST_VIEW,null,contentValues);
        db.close();

        return checkifdata != -1;


    }

    public Cursor querry_listview_table(){
        SQLiteDatabase db = this.getReadableDatabase();
        String querry = "SELECT * FROM " + TABLE_NAME_LIST_VIEW;
        Cursor cursor = db.rawQuery(querry,null);
        return  cursor;
    }




    public Cursor querry_save_table(){
        SQLiteDatabase db = this.getReadableDatabase();
        String querry = "SELECT * FROM " + TABLE_NAME_SAVING;
        Cursor cursor = db.rawQuery(querry,null);
        return  cursor;
    }

    public Cursor get_crop(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_SELECT_INGREDIENT + " FROM " + TABLE_NAME_INGREDIENT_SELECTION;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    public boolean deletecrop(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_INGREDIENT_SELECTION,null,null);
        db.close();
        return true;

    }

    public boolean deletingsinlecrop(String crop_del){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_INGREDIENT_SELECTION,COLUMN_SELECT_INGREDIENT + "=?",new String[]{crop_del});
        return true;
    }

    public boolean deletelist_view_row(String crop_del){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_LIST_VIEW,COLUMN_INT_TExT + "=?",new String[]{crop_del});
        return true;
    }

    public boolean deletingsinlecrop_whole(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_INGREDIENT_SELECTION,null,null);
        return true;
    }

    public Cursor getnoform() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_NO_FORMULATION + " FROM " + TABLE_NAME_BIRD_SELECTION ;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public Cursor querry_bird_selector() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_BIRD_SELECTION;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public void updatetable(String new_string, int no_form){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BIRD_CATEGORY,new_string);
        contentValues.put(COLUMN_NO_FORMULATION,no_form);
        db.update(TABLE_NAME_BIRD_SELECTION,contentValues,null,null);
    }


    public void updateFormtable(int no_form){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_INT_NO,no_form);
        db.update(TABLE_NAME_FORM_NO,contentValues,null,null);
    }

    public boolean del_table_bird(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_BIRD_SELECTION,null,null);
        db.close();
        return true;

    }

    public Cursor querry_table_content() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_NUTRIENT_CONTENT;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public Cursor querry_table_requirement() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_NUTRIENT_REQUIREMENT;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public Cursor querry_form_table() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_FORM_NO;
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

    public Cursor querry_Selector_table() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_INGREDIENT_SELECTION;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }




}




