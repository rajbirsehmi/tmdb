package com.creative.tmdb.presenter;

import com.creative.tmdb.adapter.MovieDetailCastAdapter;
import com.creative.tmdb.adapter.MovieDetailCrewAdapter;

public interface MovieDetailCastCrew {
    void setCastAdapter(MovieDetailCastAdapter castAdapter);
    void setCrewAdapter(MovieDetailCrewAdapter crewAdapter);
}
