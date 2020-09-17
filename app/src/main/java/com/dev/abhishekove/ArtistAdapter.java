package com.dev.abhishekove;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistHolder> {
    private List<ArtistDataRoom> list=new ArrayList<>();
    @NonNull
    @Override
    public ArtistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_item,parent,false);


        return new ArtistHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistHolder holder, int position) {
        ArtistDataRoom current=list.get(position);
        holder.artistName.setText(current.getArtistName());
        holder.collectionName.setText(current.getCollectionName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setArtist(List<ArtistDataRoom> artist){
        this.list=artist;
        notifyDataSetChanged();
    }

    class ArtistHolder extends RecyclerView.ViewHolder{
        private TextView artistName,collectionName;

        public ArtistHolder(@NonNull View itemView) {
            super(itemView);
            artistName=itemView.findViewById(R.id.name);
            collectionName=itemView.findViewById(R.id.description);
        }
    }
}
