package com.devdroid.projectday10;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expense.class,exportSchema = false, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String Db_Name = "expensedb";
    private static DatabaseHelper instance;
    public static synchronized DatabaseHelper getDB(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context,DatabaseHelper.class,Db_Name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
        }
        return instance;
    }
    public abstract ExpenseDao expenseDao();
}
