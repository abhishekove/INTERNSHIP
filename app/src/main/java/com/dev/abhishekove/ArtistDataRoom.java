package com.dev.abhishekove;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ArtistDataRoom {
    public ArtistDataRoom(String keyWord, String collectionName, String artistName) {
//        Name = name;
        KeyWord = keyWord;
        CollectionName = collectionName;
        ArtistName = artistName;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return Name;
//    }

    public String getKeyWord() {
        return KeyWord;
    }

    public String getCollectionName() {
        return CollectionName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    @PrimaryKey(autoGenerate = true)
    private  int id;

//    private String Name;

    private String KeyWord,CollectionName,ArtistName;
}
