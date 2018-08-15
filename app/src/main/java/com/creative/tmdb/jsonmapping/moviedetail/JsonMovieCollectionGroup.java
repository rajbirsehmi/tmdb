package com.creative.tmdb.jsonmapping.moviedetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMovieCollectionGroup {

    @SerializedName("id")
    @Expose
    private int groupId;

    @SerializedName("name")
    @Expose
    private String groupName;

    @SerializedName("poster_path")
    @Expose
    private String portraitPosterPath;

    @SerializedName("backdrop_path")
    @Expose
    private String widePosterPath;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPortraitPosterPath() {
        return portraitPosterPath;
    }

    public void setPortraitPosterPath(String portraitPosterPath) {
        this.portraitPosterPath = portraitPosterPath;
    }

    public String getWidePosterPath() {
        return widePosterPath;
    }

    public void setWidePosterPath(String widePosterPath) {
        this.widePosterPath = widePosterPath;
    }
}
