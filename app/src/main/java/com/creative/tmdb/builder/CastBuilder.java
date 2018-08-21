package com.creative.tmdb.builder;

import com.creative.tmdb.pojomapping.CastMember;

public class CastBuilder {
    public static class Builder {
        private CastMember castMember;

        public Builder() {
            castMember = new CastMember();
        }

        public CastMember build() {
            return castMember;
        }

        public Builder setCastId(int castId) {
            castMember.setCastId(castId);
            return this;
        }

        public Builder setCharacterName(String characterName) {
            castMember.setCharacterName(characterName);
            return this;
        }

        public Builder setCreditId(String creditId) {
            castMember.setCreditId(creditId);
            return this;
        }

        public Builder setGender(int gender) {
            castMember.setGender(gender);
            return this;
        }

        public Builder setId(int id) {
            castMember.setId(id);
            return this;
        }

        public Builder setActorName(String actorName) {
            castMember.setActorName(actorName);
            return this;
        }

        public Builder setProfileImageUrl(String profileImageUrl) {
            castMember.setProfileImageUrl(profileImageUrl);
            return this;
        }
    }
}
