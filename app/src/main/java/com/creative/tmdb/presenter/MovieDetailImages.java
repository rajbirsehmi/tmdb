package com.creative.tmdb.presenter;

import com.creative.tmdb.adapter.MovieDetailPosterAdapter;
import com.creative.tmdb.adapter.MovieDetailWallpaperAdapter;

public interface MovieDetailImages {
    void setAdapterToWallpaperRecyclerView(MovieDetailWallpaperAdapter wallpaperAdapter);
    void setAdapterToPosterRecyclerView(MovieDetailPosterAdapter posterAdapter);
}
