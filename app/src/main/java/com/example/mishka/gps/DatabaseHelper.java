package com.example.mishka.gps;

/**
 * Created by Mishka on 4/25/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import java.util.ArrayList;

public class DatabaseHelper {
//    extends SQLiteOpenHelper

        /**
         * A column for each piece of data is created.
         */
        public static final String DATABASE_NAME = "items_table.data";
        public static final String TABLE_NAME = "items_tables";
        public static final String COL_1 = "ID";
        public static final String COL_2 = "numberContact";
        public static final String COL_3 = "addressContact";
        public static final String COL_4 = "currentAddress";
//
//        /**
//         * A new DatabaseHelper object is created from a given context.
//         * @param context The given context.
//         */
//        public DatabaseHelper(Context context) {
//            super(context, DATABASE_NAME, null, 1);
//        }
//
//        /**
//         * This method is called when a DatabaseHelper object is constructed.
//         * The table is generated from each of the initialized columns.
//         * @param db The database.
//         */
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY," + COL_2 + " TEXT," + COL_3 +" TEXT," + COL_3 +" TEXT" + ");");
//        }
//
//        /**
//         * This method is called when the database table is upgraded.
//         * @param db The database.
//         * @param oldVersion The old version number of the table.
//         * @param newVersion The new version number of the table.
//         */
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//            onCreate(db);
//        }
//
//        /**
//         * This method adds an item to the data table.
//         * Each piece of data of an item is put into a separate row.
//         * @param newAdventure new item.
//         */
//        public void addItem(EveryAdventure newAdventure) {
//            SQLiteDatabase db = this.getWritableDatabase();
//            ContentValues values = new ContentValues();
//            values.put(COL_1, newAdventure.getID());
//            values.put(COL_2, (newAdventure.getNumContact()).toString());
//            values.put(COL_3, newAdventure.getAddressContact());
//            values.put(COL_4, newAdventure.getCurrentAddress());
//            db.insert(TABLE_NAME, null, values);
//            db.close(); // Closing database connection
//        }
//
//        /**
//         * This method returns an ArrayList of all of the items stored in the table.
//         * @return The ArrayList of items.
//         */
//        public ArrayList<EveryAdventure> getAllItems() {
//            ArrayList<EveryAdventure> itemlist = new ArrayList<EveryAdventure>();
//            // Select All Query
//            String selectQuery = "SELECT * FROM " + TABLE_NAME;
//            SQLiteDatabase db = this.getWritableDatabase();
//            Cursor cursor = db.rawQuery(selectQuery, null);
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    EveryAdventure item = new EveryAdventure();
//                    item.setNumContact(cursor.getString(1));
//                    item.setAddressContact((cursor.getString(2)));
//                    item.setCurrentAddress((cursor.getString(3)));
//                    // Adding item to list
//                    itemlist.add(item);
//                } while (cursor.moveToNext());
//            }
//            // return item list
//            return itemlist;
//        }
//
//        /**
//         * This method clears the database.
//         * @param TABLE_NAME The name of the database table.
//         */
//        public void clearDatabase(String TABLE_NAME) {
//            SQLiteDatabase db = this.getWritableDatabase();
//            String clearDBQuery = "DELETE FROM " + TABLE_NAME;
//            db.execSQL(clearDBQuery);
//        }

}
