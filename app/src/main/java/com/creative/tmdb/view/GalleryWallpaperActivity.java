package com.creative.tmdb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieDetailGalleryWallpaperAdapter;
import com.creative.tmdb.model.GalleryAllWallpaperImpl;
import com.creative.tmdb.presenter.GalleryAllWallpaper;

public class GalleryWallpaperActivity extends AppCompatActivity implements GalleryAllWallpaper {

    private RecyclerView rvGallery;
    private GalleryAllWallpaperImpl galleryAllWallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_wallpaper);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getBaseContext().getResources().getString(R.string.title_activity_gallery_activity_wallpaper));

        rvGallery = findViewById(R.id.rv_gallery);
        rvGallery.setItemAnimator(new DefaultItemAnimator());
        rvGallery.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        galleryAllWallpaper = new GalleryAllWallpaperImpl(this, getBaseContext());
        galleryAllWallpaper.loadAllPosters(getIntent().getIntExtra("movie_id", -1));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAllWallpaperGaleryAdapterToRecyclerView(MovieDetailGalleryWallpaperAdapter adapter) {
        rvGallery.setAdapter(adapter);
    }
}
