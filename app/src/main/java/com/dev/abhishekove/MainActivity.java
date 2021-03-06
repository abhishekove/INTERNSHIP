package com.dev.abhishekove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private EditText search;
    private Button button;
    private ArtistViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        ArtistAdapter adapter=new ArtistAdapter();
        recyclerView.setAdapter(adapter);
        viewModel= ViewModelProviders.of(this).get(ArtistViewModel.class);
        viewModel.getAllArtist().observe(this, new Observer<List<ArtistDataRoom>>() {
            @Override
            public void onChanged(List<ArtistDataRoom> artistDataRooms) {
                adapter.setArtist(artistDataRooms);
            }
        });

        button=findViewById(R.id.button);
        search=findViewById(R.id.search);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.search(search.getText().toString());
            }
        });
    }
}