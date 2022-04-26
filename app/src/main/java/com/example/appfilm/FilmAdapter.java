package com.example.appfilm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    Context context;
    List<Film> fData;
    FilmItemClickListener filmItemClickListener;

    public FilmAdapter(Context context, List<Film> fData, FilmItemClickListener listener) {
        this.context = context;
        this.fData = fData;
        filmItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return fData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImgFilm;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgFilm = itemView.findViewById(R.id.detail_movie_img)

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    filmItemClickListener.onFilmClick(fData.get(getAdapterPosition()), ImgFilm);
                }
            });
        }
    }
}
