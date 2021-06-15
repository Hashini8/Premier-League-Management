package com.company;

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {

    //private variables created
    private String universityName;

    public UniversityFootballClub(String nameOfTheClub, String location, String nameOfTheCoach, int noOfWins, int noOfDraws, int noOfDefeats, int noOfGoalsReceived, int noOfGoalsScored, int noOfPoints, int noOfMatchesPlayed, String universityName) {
        super(nameOfTheClub, location, nameOfTheCoach, noOfWins, noOfDraws, noOfDefeats, noOfGoalsReceived, noOfGoalsScored, noOfPoints, noOfMatchesPlayed);
        this.universityName = universityName;
    }

    //getters and setters
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), universityName);
    }
}


