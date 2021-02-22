package com.example.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player_table")
public class Player {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "player_name")
    private String name;

    public Player(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // --- GETTER ---

    public long getId() { return id; }
    public String getName() { return name; }

    // --- SETTER ---

    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
