package com.dev.abhishekove;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ADRDAO {

    @Insert
    void insert(ArtistDataRoom artistDataRoom);

    @Update
    void update(ArtistDataRoom artistDataRoom);

    @Delete
    void delete(ArtistDataRoom artistDataRoom);

    @Query("DELETE FROM ArtistDataRoom")
    void deleteAll();

    @Query("SELECT * FROM artistdataroom ORDER BY id")
    LiveData<List<ArtistDataRoom>> getAllArtist();

    @Query("SELECT * FROM artistdataroom WHERE ArtistName LIKE LOWER(:term) OR CollectionName LIKE LOWER(:term)")
    List<ArtistDataRoom> getDesired(String term);
}
