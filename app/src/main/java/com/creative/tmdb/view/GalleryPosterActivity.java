package com.creative.tmdb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieDetailGalleryPosterAdapter;
import com.creative.tmdb.model.GalleryAllPosterImpl;
import com.creative.tmdb.presenter.GalleryAllPoster;

public class GalleryPosterActivity extends AppCompatActivity implements GalleryAllPoster {

    private RecyclerView rvGallery;
    private GalleryAllPosterImpl galleryAllPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_poster);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getBaseContext().getResources().getString(R.string.title_activity_gallery_activity_poster));

        rvGallery = findViewById(R.id.rv_gallery);
        rvGallery.setItemAnimator(new DefaultItemAnimator());
        rvGallery.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));

        galleryAllPoster = new GalleryAllPosterImpl(this, getBaseContext());
        galleryAllPoster.loadAllPosters(getIntent().getIntExtra("movie_id", -1));
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
    public void setAllPosterGaleryAdapterToRecyclerView(MovieDetailGalleryPosterAdapter adapter) {
        rvGallery.setAdapter(adapter);
    }
}
