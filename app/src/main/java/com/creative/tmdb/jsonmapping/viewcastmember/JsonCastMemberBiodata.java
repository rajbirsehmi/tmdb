package com.creative.tmdb.jsonmapping.viewcastmember;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonCastMemberBiodata {
    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("known_for_department")
    @Expose
    private String knownForDepartment;

    @SerializedName("deathday")
    @Expose
    private String deathDay;

    @SerializedName("id")
    @Expose
    private int personId;

    @SerializedName("name")
    @Expose
    private String actorName;

    @SerializedName("also_known_as")
    @Expose
    private String[] alsoKnownAs;

    @SerializedName("gender")
    @Expose
    private int gender;

    @SerializedName("biography")
    @Expose
    private String biography;

    @SerializedName("popularity")
    @Expose
    private float popularity;

    @SerializedName("place_of_birth")
    @Expose
    private String birthPlace;

    @SerializedName("profile_path")
    @Expose
    private String profilePath;

    @SerializedName("imdb_id")
    @Expose
    private String imdbId;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String[] getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(String[] alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
