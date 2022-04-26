package com.example.appfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class FilmDetailActivity extends AppCompatActivity {
    private ImageView filmThumbnailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
    
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId= getIntent().getExtras().getInt("imgURL");
        filmThumbnailImg = findViewById(R.id.detail_movie_img);
        filmThumbnailImg.setImageResource(imageResourceId);

    }
}