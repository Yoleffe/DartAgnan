package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.PlayersActivity;

import java.util.List;

@Dao
public interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    String insertPlayer(Player player);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Query("SELECT * FROM player_table WHERE id = :idPlayer")
    LiveData<List<Player>> getPlayers(long idPlayer);

}
