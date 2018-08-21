package com.creative.tmdb.parser;

import com.creative.tmdb.builder.CastBuilder;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCast;
import com.creative.tmdb.pojomapping.CastMember;

public class CastParser {
    public static CastMember parse(JsonMovieCreditCast cast) {
        return new CastBuilder.Builder()
                .setCastId(cast.getCastId())
                .setCharacterName(cast.getCharacterName())
                .setCreditId(cast.getCreditId())
                .setGender(cast.getGender())
                .setId(cast.getId())
                .setActorName(cast.getActorName())
                .setProfileImageUrl(cast.getProfileImagePath())
                .build();
    }
}
