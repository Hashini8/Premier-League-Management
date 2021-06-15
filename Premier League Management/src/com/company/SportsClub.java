package com.company;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    private static final long serialVersionUID = 1L;

    //private variables created
    private String nameOfTheClub;
    private String location;
    private String nameOfTheCoach;

    public SportsClub(){

    }

    public SportsClub(String nameOfTheClub, String location, String nameOfTheCoach) {
        super();
        this.nameOfTheClub = nameOfTheClub;
        this.location = location;
        this.nameOfTheCoach = nameOfTheCoach;
    }

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNameOfTheCoach() {
        return nameOfTheCoach;
    }

    public void setNameOfTheCoach(String nameOfTheCoach) {
        this.nameOfTheCoach = nameOfTheCoach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return nameOfTheCoach == that.nameOfTheCoach &&
                Objects.equals(nameOfTheClub, that.nameOfTheClub) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheClub, location, nameOfTheCoach);
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "nameOfTheClub='" + nameOfTheClub + '\'' +
                ", location='" + location + '\'' +
                ", nameOfTheCoach='" + nameOfTheCoach + '\'' +
                '}';
    }
}

