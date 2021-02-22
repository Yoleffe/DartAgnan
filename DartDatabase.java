package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Player.class}, version = 1, exportSchema = false)
public abstract class DartDatabase extends RoomDatabase {

    // --- SINGLETON ---
    public static volatile DartDatabase INSTANCE;

    // --- DAO ---
    public abstract PlayerDao playerDao();

    // --- INSTANCE ---
    public static DartDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (DartDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DartDatabase.class, "Database.db")
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // ---

    private static Callback prepopulateDatabase(){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                ContentValues contentValues = new ContentValues();
                contentValues.put("id", 1);
                contentValues.put("player_name", "Didier");

                db.insert("player_table", OnConflictStrategy.IGNORE, contentValues);
            }
        };
    }
}
