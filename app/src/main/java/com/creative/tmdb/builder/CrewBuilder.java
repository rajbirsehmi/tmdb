package com.creative.tmdb.builder;

import com.creative.tmdb.pojomapping.CrewMember;

public class CrewBuilder {
    public static class Builder {
        private CrewMember crewMember;

        public Builder() {
            crewMember = new CrewMember();
        }

        public CrewMember build() {
            return crewMember;
        }

        public Builder setCreditId(String creditId) {
            crewMember.setCreditId(creditId);
            return this;
        }

        public Builder setDepartmentName(String department) {
            crewMember.setDepartment(department);
            return this;
        }

        public Builder setGender(int gender) {
            crewMember.setGender(gender);
            return this;
        }

        public Builder setId(int id) {
            crewMember.setId(id);
            return this;
        }

        public Builder setJobTitle(String jobTitle) {
            crewMember.setJobTitle(jobTitle);
            return this;
        }

        public Builder setCrewMemberName(String crewMemberName) {
            crewMember.setCrewMemberName(crewMemberName);
            return this;
        }

        public Builder setProfileImageUrl(String profileImageUrl) {
            crewMember.setProfileImageUrl(profileImageUrl);
            return this;
        }
    }
}