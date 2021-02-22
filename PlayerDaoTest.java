package com.example.myapplication.database;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
//@LargeTest
public class PlayerDaoTest {
    // FOR DATA
    private DartDatabase database;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    /*@BeforeClass
    public void initDb() throws Exception {
        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getTargetContext(),
                DartDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @AfterClass
    public void closeDb() throws Exception {
        database.close();
    }

    // DATA SET FOR TEST
    public long USER_ID = 1;
    //public Player USER_DEMO = new Player(USER_ID, "Didier");
    public Player player = new Player(1, "Didier");

    @Test
    public void insertAndGetPlayer() throws InterruptedException {
        // BEFORE : Adding a new user
        this.database.playerDao().insertPlayer(player);
        // TEST
        Player player = (Player) LiveDataTestUtil.getValue(this.database.playerDao().getPlayers(USER_ID));
        assertTrue(player.getName().equals(player.getName()) && player.getId() == USER_ID);
    }*/

}
