package com.creative.tmdb.jsonmapping.moviecredits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonCreditsCast {

    @SerializedName("cast_type")
    @Expose
    private String creditType;

    @SerializedName("department")
    @Expose
    private String department;

    @SerializedName("job")
    @Expose
    private String job;

    @SerializedName("media")
    @Expose
    private JsonCreditsCastMedia creditsCastMedia;

    @SerializedName("media_type")
    @Expose
    private String mediaType;

    @SerializedName("id")
    @Expose
    private String creditId;

    @SerializedName("person")
    @Expose
    private JsonCreditsCastPerson creditsCastPerson;

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public JsonCreditsCastMedia getCreditsCastMedia() {
        return creditsCastMedia;
    }

    public void setCreditsCastMedia(JsonCreditsCastMedia creditsCastMedia) {
        this.creditsCastMedia = creditsCastMedia;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public JsonCreditsCastPerson getCreditsCastPerson() {
        return creditsCastPerson;
    }

    public void setCreditsCastPerson(JsonCreditsCastPerson creditsCastPerson) {
        this.creditsCastPerson = creditsCastPerson;
    }
}
