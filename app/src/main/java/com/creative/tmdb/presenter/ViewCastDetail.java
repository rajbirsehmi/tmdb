package com.creative.tmdb.presenter;

public interface ViewCastDetail {
    void setBackgroundImage(String posterUrl);
    void setCastMemberName(String actorName);
    void setCastMemberDepartment(String department);
    void setCastMemberPopularity(float popularity);
    void loadMoreData(int personId);
}
