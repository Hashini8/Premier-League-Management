package com.company;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable <FootballClub>, Serializable {
    private static final long serialVersionUID = 1L;

    //creating private variables which are needed
    private int noOfWins;
    private int noOfDraws;
    private int noOfDefeats;
    private int noOfGoalsReceived;
    private int noOfGoalsScored;
    private int noOfPoints;
    private int noOfMatchesPlayed;
    private int goalDiff;

    public int getGoalDiff() {
        return goalDiff = noOfGoalsScored - noOfGoalsReceived;
    }


    public FootballClub(String nameOfTheClub, String location, String nameOfTheCoach, int noOfWins, int noOfDraws, int noOfDefeats, int noOfGoalsReceived, int noOfGoalsScored, int noOfPoints, int noOfMatchesPlayed) {
        super(nameOfTheClub, location, nameOfTheCoach);
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.noOfDefeats = noOfDefeats;
        this.noOfGoalsReceived = noOfGoalsReceived;
        this.noOfGoalsScored = noOfGoalsScored;
        this.noOfPoints = noOfPoints;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    //getter and setter methods for the football class variables
    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfDraws() {
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws) {
        this.noOfDraws = noOfDraws;
    }

    public int getNoOfDefeats() {
        return noOfDefeats;
    }

    public void setNoOfDefeats(int noOfDefeats) {
        this.noOfDefeats = noOfDefeats;
    }

    public int getNoOfGoalsReceived() {
        return noOfGoalsReceived;
    }

    public void setNoOfGoalsReceived(int noOfGoalsReceived) {
        this.noOfGoalsReceived = noOfGoalsReceived;
    }

    public int getNoOfGoalsScored() {
        return noOfGoalsScored;
    }

    public void setNoOfGoalsScored(int noOfGoalsScored) {
        this.noOfGoalsScored = noOfGoalsScored;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    super.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return noOfWins == that.noOfWins &&
                noOfDraws == that.noOfDraws &&
                noOfDefeats == that.noOfDefeats &&
                noOfGoalsReceived == that.noOfGoalsReceived &&
                noOfGoalsScored == that.noOfGoalsScored &&
                noOfPoints == that.noOfPoints &&
                noOfMatchesPlayed == that.noOfMatchesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), noOfWins, noOfDraws, noOfDefeats, noOfGoalsReceived, noOfGoalsScored, noOfPoints, noOfMatchesPlayed);
    }

    @Override
    public int compareTo(FootballClub pleague){
        if (noOfPoints == pleague.noOfPoints) {
            int pL = noOfGoalsScored - getNoOfDefeats();
            int pL1 = pleague.noOfGoalsScored - pleague.getNoOfDefeats();
            return pL1 - pL;
        }

        return pleague.noOfPoints- noOfPoints;
    }

}
