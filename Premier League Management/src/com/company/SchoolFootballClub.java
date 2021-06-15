package com.company;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub{

    //variables in schoolfootball club
    private String schoolName;

    public SchoolFootballClub(String nameOfTheClub, String location, String nameOfTheCoach, int noOfWins, int noOfDraws, int noOfDefeats, int noOfGoalsReceived, int noOfGoalsScored, int noOfPoints, int noOfMatchesPlayed, String schoolName) {
        super(nameOfTheClub, location, nameOfTheCoach, noOfWins, noOfDraws, noOfDefeats, noOfGoalsReceived, noOfGoalsScored, noOfPoints, noOfMatchesPlayed);
        this.schoolName = schoolName;
    }

//getters and setters
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName);
    }
}

