package com.company;

import java.io.Serializable;

public class Match implements Serializable,Comparable<Match> {
    private static final Long serialVersionUID = 1L;

    //created private variables for the match class
    String teamA;
    String teamB;
    int year;
    int month;
    int date;
    int teamAScore;
    int teamBScore;

    public Match(String teamA, String teamB, int year, int month, int date, int teamAScore, int teamBScore) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.year = year;
        this.month = month;
        this.date = date;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) { this.month = month;
    }

    public int getDate() { return date; }

    public void setDate(int date) { this.date = date;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    @Override
    public int compareTo (Match o) {
        if (year==o.year) {
            if (month==o.month) {
                return date - o.date;
            }
            return month - o.month;
        }
        return year - o.year;
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", date=" + date +
                ", teamAScore=" + teamAScore +
                ", teamBScore=" + teamBScore +
                '}';
    }
}