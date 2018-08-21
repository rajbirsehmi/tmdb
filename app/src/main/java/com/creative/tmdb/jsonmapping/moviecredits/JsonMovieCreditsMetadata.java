package com.creative.tmdb.jsonmapping.moviecredits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMovieCreditsMetadata {

    @SerializedName("id")
    @Expose
    private int movieId;

    @SerializedName("cast")
    @Expose
    private JsonMovieCreditCast[] castMembers;

    @SerializedName("crew")
    @Expose
    private JsonMovieCreditCrew[] crewMembers;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public JsonMovieCreditCast[] getCastMembers() {
        return castMembers;
    }

    public void setCastMembers(JsonMovieCreditCast[] castMembers) {
        this.castMembers = castMembers;
    }

    public JsonMovieCreditCrew[] getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(JsonMovieCreditCrew[] crewMembers) {
        this.crewMembers = crewMembers;
    }
}
