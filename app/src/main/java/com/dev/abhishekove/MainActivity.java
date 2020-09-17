package com.dev.abhishekove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private EditText search;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        text=findViewById(R.id.text);
        search=findViewById(R.id.search);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(" https://itunes.apple.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolgerApi jsonPlaceHolgerApi=retrofit.create(JsonPlaceHolgerApi.class);

                Call<ArtistList> call=jsonPlaceHolgerApi.getArtists(search.getText().toString());

                call.enqueue(new Callback<ArtistList>() {
                    @Override
                    public void onResponse(Call<ArtistList> call, Response<ArtistList> response) {
                        ArtistList resp= response.body();
                        List<ArtistDataRoom> res=resp.getResults();
                        text.setText("");
                        for(ArtistDataRoom artist:res){
                            text.append(artist.getArtistName());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArtistList> call, Throwable t) {

                    }
                });
            }
        });
    }
}