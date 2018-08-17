package com.creative.tmdb.jsonmapping.moviedetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMovieDetailImage {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("backdrops")
    @Expose
    private JsonMovieDetailWallpaperAndPoster[] jsonMovieDetailWallpapers;

    @SerializedName("posters")
    @Expose
    private JsonMovieDetailWallpaperAndPoster[] jsonMovieDetailPosters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonMovieDetailWallpaperAndPoster[] getJsonMovieDetailWallpapers() {
        return jsonMovieDetailWallpapers;
    }

    public void setJsonMovieDetailWallpapers(JsonMovieDetailWallpaperAndPoster[] jsonMovieDetailWallpapers) {
        this.jsonMovieDetailWallpapers = jsonMovieDetailWallpapers;
    }

    public JsonMovieDetailWallpaperAndPoster[] getJsonMovieDetailPosters() {
        return jsonMovieDetailPosters;
    }

    public void setJsonMovieDetailPosters(JsonMovieDetailWallpaperAndPoster[] jsonMovieDetailPosters) {
        this.jsonMovieDetailPosters = jsonMovieDetailPosters;
    }
}
