package com.creative.tmdb.jsonmapping.moviecredits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMovieCreditCast {

    @SerializedName("cast_id")
    @Expose
    private int castId;

    @SerializedName("character")
    @Expose
    private String characterName;

    @SerializedName("credit_id")
    @Expose
    private String creditId;

    @SerializedName("gender")
    @Expose
    private int gender;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String actorName;

    @SerializedName("profile_path")
    @Expose
    private String profileImagePath;

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }
}
