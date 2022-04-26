package com.example.appfilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements FilmItemClickListener {
    private List<Slide> lstSlides;
    private ViewPager sliderpaper;
    private TabLayout indicator;
    private RecyclerView FilmRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderpaper = findViewById(R.id.slider_paper);
        indicator = findViewById(R.id.indicator);
        FilmRV= findViewById(R.id.Rv_film);
        //prepare list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1,"Slite Titele /n test"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slite Titele2 /n test"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slite Titele3 /n test"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slite Titele4 /n test"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpaper.setAdapter(adapter);
        //set up timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderpaper,true);
        // recycleview setup
        //ini data
        List<Film> lstFilm = new ArrayList<>();
        lstFilm.add(new Film("demsongcon", R.drawable.demsongcon));
        lstFilm.add(new Film("haiphuong",R.drawable.haiphuong));
        lstFilm.add(new Film("sapra",R.drawable.sapra));
        lstFilm.add(new Film("spiderman",R.drawable.slide1));
        lstFilm.add(new Film("ironman",R.drawable.slide2));

        FilmAdapter filmAdapter = new FilmAdapter(this, lstFilm, this);
        FilmRV.setAdapter(filmAdapter);
        FilmRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }

    @Override
    public void onFilmClick(Film film, ImageView filmImageView) {
        Intent intent = new Intent(this, FilmDetailActivity.class);
        intent.putExtra("title", film.getTitle());
        intent.putExtra("imgURL", film.getThumbnail());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                                    filmImageView, "sharedName");
        startActivity(intent, options.toBundle());

        Toast.makeText(this, "item clicked : " + film.getTitle(), Toast.LENGTH_LONG).show();
    }

    class SliderTimer extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderpaper.getCurrentItem()<lstSlides.size()-1) {
                        sliderpaper.setCurrentItem(sliderpaper.getCurrentItem()+1);

                    }
                    else sliderpaper.setCurrentItem(0);
                }
            });
        }
    }

}