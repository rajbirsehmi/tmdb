package com.creative.tmdb.presenter;

import com.creative.tmdb.adapter.MovieCreditsCastAdapter;
import com.creative.tmdb.adapter.MovieCreditsCrewAdapter;

public interface MovieCreditsCastCrew {
    void setCastAdapter(MovieCreditsCastAdapter castAdapter);
    void setCrewAdapter(MovieCreditsCrewAdapter crewAdapter);
}
