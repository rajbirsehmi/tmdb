package com.creative.tmdb.jsonmapping.moviedetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMovieGenre {

    @SerializedName("id")
    @Expose
    private int genreId;

    @SerializedName("name")
    @Expose
    private String genreName;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
