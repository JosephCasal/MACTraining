package com.example.joseph.savingdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 10/2/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    //when you change the schema, change the version number

    private static final String DATABASE_NAME = "Persons.db";

    private static final String TABLE_NAME = "Persons";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_GENDER = "Gender";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_NAME + " TEXT PRIMARY KEY, " +
                COLUMN_AGE + " TEXT, " +
                COLUMN_GENDER + " TEXT" +
                ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }


    //called whenever we change the schema
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE ID EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public long savePerson(Person person){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //key column name, value
        contentValues.put(COLUMN_NAME, person.getName());
        contentValues.put(COLUMN_AGE, person.getAge());
        contentValues.put(COLUMN_GENDER, person.getGender());

        //database.insert returns row value where this data was saved
        long isSaved = database.insert(TABLE_NAME, null, contentValues);

        return isSaved;

    }

    public List<Person> getPersonList(){

        List<Person> personList = new ArrayList<>();
        SQLiteDatabase databse = this.getWritableDatabase();

        String QUERY = "SELECT * from " + TABLE_NAME;
        Cursor cursor = databse.rawQuery(QUERY, null);
//        String QUERY = "SELECT * from " + TABLE_NAME + " where name = ?";
//        Cursor cursor = databse.rawQuery(QUERY, new String[]{"34"});

        //returns boolean true if there is a record
        if(cursor.moveToFirst()){
            do {
                Person person = new Person(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2));
                personList.add(person);
            } while(cursor.moveToNext());
        }

        return personList;

    }

}
