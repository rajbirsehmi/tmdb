package com.creative.tmdb.parser;

import com.creative.tmdb.builder.CrewBuilder;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCrew;
import com.creative.tmdb.pojomapping.CrewMember;

public class CrewParser {
    public static CrewMember parse(JsonMovieCreditCrew crew) {
        return new CrewBuilder.Builder()
                .setCreditId(crew.getCreditId())
                .setDepartmentName(crew.getDepartmentName())
                .setGender(crew.getGender())
                .setId(crew.getId())
                .setJobTitle(crew.getJobTitle())
                .setCrewMemberName(crew.getCrewMemberName())
                .setProfileImageUrl(crew.getProfileImagePath())
                .build();
    }
}
