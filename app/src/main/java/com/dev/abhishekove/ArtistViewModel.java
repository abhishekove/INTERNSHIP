package com.dev.abhishekove;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ArtistViewModel extends AndroidViewModel {
    private ArtistRepository repository;
    private LiveData<List<ArtistDataRoom>> allArtist;

    public ArtistViewModel(@NonNull Application application) {
        super(application);
        repository=new ArtistRepository(application);
        allArtist=repository.getAllArtist();
    }

    public void insert(ArtistDataRoom artistDataRoom){
        repository.insert(artistDataRoom);
    }
    public void update(ArtistDataRoom artistDataRoom){
        repository.update(artistDataRoom);
    }
    public void delete(ArtistDataRoom artistDataRoom){
        repository.delete(artistDataRoom);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public void search(String term){
        repository.search(term);
    }

    public LiveData<List<ArtistDataRoom>> getAllArtist() {
        return allArtist;
    }
}
