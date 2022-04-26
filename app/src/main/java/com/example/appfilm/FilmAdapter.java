package com.example.appfilm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    Context context;
    List<Film> filmData;
    FilmItemClickListener filmItemClickListener;

    public FilmAdapter(Context context, List<Film> fData, FilmItemClickListener listener) {
        this.context = context;
        this.filmData = fData;
        filmItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_film,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(filmData.get(position).getTitle());
        holder.imgFilm.setImageResource(filmData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return filmData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private ImageView imgFilm;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_film_title);
            imgFilm = itemView.findViewById(R.id.item_film_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    filmItemClickListener.onFilmClick(filmData.get(getAdapterPosition()), imgFilm);
                }
            });
        }
    }

}
