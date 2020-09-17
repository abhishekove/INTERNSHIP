package com.dev.abhishekove;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class ArtistDataRoom {
    public ArtistDataRoom() {
    }

    public ArtistDataRoom(String collectionName, String artistName) {
//        Name = name;
//        KeyWord = keyWord;
        CollectionName = collectionName;
        ArtistName = artistName;
    }


    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return Name;
//    }


    public String getCollectionName() {
        return CollectionName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public int getId() {
        return id;
    }

    @PrimaryKey(autoGenerate = true)
    private  int id;

//    private String Name;



    @SerializedName("collectionName")
    private String CollectionName;

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public void setCollectionName(String collectionName) {
        CollectionName = collectionName;
    }

    @SerializedName("artistName")
    private String ArtistName;
}
