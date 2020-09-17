package com.dev.abhishekove;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = ArtistDataRoom.class,version = 1)
public abstract class ArtistDatabase extends RoomDatabase {

    private static ArtistDatabase instance;

    public abstract ADRDAO adrdao();

    public static synchronized ArtistDatabase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    ArtistDatabase.class,"ARDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
