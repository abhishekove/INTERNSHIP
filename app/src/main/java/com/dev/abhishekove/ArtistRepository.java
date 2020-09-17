package com.dev.abhishekove;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtistRepository {
    private ADRDAO adrdao;
    private LiveData<List<ArtistDataRoom>> allArtist;

    public ArtistRepository(Application application){
        ArtistDatabase database=ArtistDatabase.getInstance(application);
        adrdao=database.adrdao();
        allArtist=adrdao.getAllArtist();
    }
    public void search(String term){
//        Log.d("Check", term);
        Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(" https://itunes.apple.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolgerApi jsonPlaceHolgerApi=retrofit.create(JsonPlaceHolgerApi.class);

                Call<ArtistList> call=jsonPlaceHolgerApi.getArtists(term);

                call.enqueue(new Callback<ArtistList>() {
                    @Override
                    public void onResponse(Call<ArtistList> call, Response<ArtistList> response) {
                        ArtistList resp= response.body();
                        List<ArtistDataRoom> res=resp.getResults();
//                        text.setText("");/
                        for(ArtistDataRoom artist:res){
//                            text.append(artist.getArtistName());
//                            Log.d("Check", artist.getArtistName());
                            insert(artist);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArtistList> call, Throwable t) {

                    }
                });
    }

    public void insert(ArtistDataRoom artistDataRoom){
        new InsertAsync(adrdao).execute(artistDataRoom);
    }
    public void update(ArtistDataRoom artistDataRoom){
        new UpdateAsync(adrdao).execute(artistDataRoom);
    }
    public void delete(ArtistDataRoom artistDataRoom){
        new DeleteAsync(adrdao).execute(artistDataRoom);
    }
    public void deleteAll(){
        new DeleteAll(adrdao).execute();
    }
    public LiveData<List<ArtistDataRoom>> getAllArtist(){
        return allArtist;
    }
    private static class InsertAsync extends AsyncTask<ArtistDataRoom,Void,Void>{
        private ADRDAO adrdao;

        private InsertAsync(ADRDAO adrdao){
         this.adrdao=adrdao;
        }


        @Override
        protected Void doInBackground(ArtistDataRoom... artistDataRooms) {
            adrdao.insert(artistDataRooms[0]);
            return null;
        }
    }
    private static class UpdateAsync extends AsyncTask<ArtistDataRoom,Void,Void>{
        private ADRDAO adrdao;

        private UpdateAsync(ADRDAO adrdao){
            this.adrdao=adrdao;
        }


        @Override
        protected Void doInBackground(ArtistDataRoom... artistDataRooms) {
            adrdao.update(artistDataRooms[0]);
            return null;
        }
    }
    private static class DeleteAsync extends AsyncTask<ArtistDataRoom,Void,Void>{
        private ADRDAO adrdao;

        private DeleteAsync(ADRDAO adrdao){
            this.adrdao=adrdao;
        }


        @Override
        protected Void doInBackground(ArtistDataRoom... artistDataRooms) {
            adrdao.delete(artistDataRooms[0]);
            return null;
        }
    }
    private static class DeleteAll extends AsyncTask<Void,Void,Void>{
        private ADRDAO adrdao;

        private DeleteAll(ADRDAO adrdao){
            this.adrdao=adrdao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            adrdao.deleteAll();
            return null;
        }
    }
}
