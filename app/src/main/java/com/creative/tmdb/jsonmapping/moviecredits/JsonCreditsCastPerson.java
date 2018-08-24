package com.creative.tmdb.jsonmapping.moviecredits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonCreditsCastPerson {
    @SerializedName("adult")
    @Expose
    private boolean isAdult;

    @SerializedName("gender")
    @Expose
    private int gender;

    @SerializedName("name")
    @Expose
    private String actorName;

    @SerializedName("id")
    @Expose
    private int actorId;

    @SerializedName("known_for")
    @Expose
    private JsonCreditsCastMedia[] personKnownFor;

    @SerializedName("known_for_department")
    @Expose
    private String knownForDepartment;

    @SerializedName("profile_path")
    @Expose
    private String profileImageUrl;

    @SerializedName("popularity")
    @Expose
    private float popularity;

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public JsonCreditsCastMedia[] getPersonKnownFor() {
        return personKnownFor;
    }

    public void setPersonKnownFor(JsonCreditsCastMedia[] personKnownFor) {
        this.personKnownFor = personKnownFor;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
}
