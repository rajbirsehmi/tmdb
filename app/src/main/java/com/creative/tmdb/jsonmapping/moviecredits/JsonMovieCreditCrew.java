package com.creative.tmdb.jsonmapping.moviecredits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMovieCreditCrew {

    @SerializedName("credit_id")
    @Expose
    private String creditId;

    @SerializedName("department")
    @Expose
    private String departmentName;

    @SerializedName("gender")
    @Expose
    private int gender;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("job")
    @Expose
    private String jobTitle;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("profile_path")
    @Expose
    private String profileImagePath;

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCrewMemberName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }
}
