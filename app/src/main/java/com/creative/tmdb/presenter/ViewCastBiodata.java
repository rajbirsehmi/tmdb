package com.creative.tmdb.presenter;

import com.creative.tmdb.listener.ImdbCastMemberLinkListener;

public interface ViewCastBiodata {
    void setBirthDate(String birthday);
    void setBirthPlace(String birthPlace);
    void setBiography(String biography);
    void setImdbLink(ImdbCastMemberLinkListener linkListener);
}
