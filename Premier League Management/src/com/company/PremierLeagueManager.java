package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {
    //Creating array lists
    public static List<FootballClub> allPremierLeagueClubs = new ArrayList<FootballClub>();
    public static List<Match> premierMatch = new ArrayList<Match>();

    //public static final int=20;

    public static Match MatGen() {
        Random MatRan = new Random();
        int teamAScore = MatRan.nextInt(10);
        int teamBScore = MatRan.nextInt(10);
        int noOfTeamA = 0;
        int noOfTeamB = 0;

        while (true) {
            noOfTeamA = MatRan.nextInt(allPremierLeagueClubs.size());
            noOfTeamB = MatRan.nextInt(allPremierLeagueClubs.size());

            if (!(noOfTeamA == noOfTeamB)) {
                break;
            }

        }

        String teamAName = allPremierLeagueClubs.get(noOfTeamA).getNameOfTheClub();
        String teamBName = allPremierLeagueClubs.get(noOfTeamB).getNameOfTheClub();
        LocalDate datLocal = LocalDate.now();
        Match ranMat = new Match(teamAName, teamBName, datLocal.getYear(), datLocal.getMonthValue(), datLocal.getDayOfMonth(), teamAScore, teamBScore);
        premierMatch.add(ranMat);

        if (teamAScore > teamBScore) {
            for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamAName)) {
                    allPremierLeagueClubs.get(i).setNoOfWins(allPremierLeagueClubs.get(i).getNoOfWins() + 1);
                    allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + teamAScore);
                    allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + teamBScore);
                    allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 3);
                    allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                }

            }
        }
        if (teamAScore == teamBScore) {
            for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamAName)) {
                    allPremierLeagueClubs.get(i).setNoOfDraws(allPremierLeagueClubs.get(i).getNoOfDraws() + 1);
                    allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + teamAScore);
                    allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + teamBScore);
                    allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 1);
                    allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                }

            }
        }
        if (teamAScore < teamBScore) {
            for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamAName)) {
                    allPremierLeagueClubs.get(i).setNoOfDefeats(allPremierLeagueClubs.get(i).getNoOfDefeats() + 1);
                    allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + teamAScore);
                    allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + teamBScore);
                    allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                }

            }
        }
        if (teamBScore > teamAScore) {
            for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamBName)) {
                    allPremierLeagueClubs.get(i).setNoOfWins(allPremierLeagueClubs.get(i).getNoOfWins() + 1);
                    allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + teamBScore);
                    allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + teamAScore);
                    allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 3);
                    allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                }

            }
        } else if (teamBScore == teamAScore) {
            for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamBName)) {
                    allPremierLeagueClubs.get(i).setNoOfDraws(allPremierLeagueClubs.get(i).getNoOfDraws() + 1);
                    allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + teamBScore);
                    allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + teamAScore);
                    allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 1);
                    allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                }

            }
        } else if (teamBScore < teamAScore) {
            for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamBName)) {
                    allPremierLeagueClubs.get(i).setNoOfDefeats(allPremierLeagueClubs.get(i).getNoOfDefeats() + 1);
                    allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + teamBScore);
                    allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + teamAScore);
                    allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                }

            }


        }
        return ranMat;
    }

    Scanner sc1 = new Scanner(System.in);


// Method to add a football club to the premier league
    @Override
    public void addClub() {

        String nameOfTheClub, location, nameOfTheCoach;

        nameOfTheClub = StringValidation("Enter your club name : ");

        location = StringValidation("Club location : ");

        nameOfTheCoach = StringValidation("Enter the name of the coach : ");

        FootballClub f1 = new FootballClub(nameOfTheClub, location, nameOfTheCoach, 0, 0, 0, 0, 0, 0, 0);
        allPremierLeagueClubs.add(f1);
        System.out.println(allPremierLeagueClubs);
    }

    //delete a football club from the array
    @Override
    public void deleteClub() {

        String deleteTheClubName;
        deleteTheClubName = StringValidation("Enter the club name you want to delete : ");

        for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
            if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(deleteTheClubName)) {
                allPremierLeagueClubs.remove(i);
                System.out.println(allPremierLeagueClubs);
            }
        }

    }


    //get entered club statistics
    @Override
    public void printStatistics() {

        String searchClubName;
        searchClubName = StringValidation("Enter the club name you want to display : ");


        for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
            if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(searchClubName)) {
                System.out.println("Name of the club : " + allPremierLeagueClubs.get(i).getNameOfTheClub());
                System.out.println("Name of the coach : " + allPremierLeagueClubs.get(i).getNameOfTheCoach());
                System.out.println("Number of wins : " + allPremierLeagueClubs.get(i).getNoOfWins());
                System.out.println("Number of draws : " + allPremierLeagueClubs.get(i).getNoOfDraws());
                System.out.println("Number of defeats : " + allPremierLeagueClubs.get(i).getNoOfDefeats());
                System.out.println("Number of goals received : " + allPremierLeagueClubs.get(i).getNoOfGoalsReceived());
                System.out.println("Number of points : " + allPremierLeagueClubs.get(i).getNoOfPoints());
                System.out.println("Number of matches played : " + allPremierLeagueClubs.get(i).getNoOfMatchesPlayed());

            }
        }

    }


    //https://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java - resource
    @Override
    public void printLeagueTable() {

        allPremierLeagueClubs.sort(FootballClub::compareTo);

        String leftAlignFormat = "|  %-15s  |  %-27d  | %-5d | %-7d| %-7d| %-11d | %-15d | %-15d  |  %-4d  |%n";
        System.out.format("*___________________*_______________________________*_______*________*________*_____________*_________________*__________________*________*%n");
        System.out.format("|     Club name     |   Number of Matches Played    |  Win  |  Draw  |  Loss  |  Goals For  |  Goals Against  | Goal Difference  | Points |%n");
        System.out.format("*-------------------*-------------------------------*-------*--------*--------*-------------*-----------------*------------------*--------*%n");
        for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
            System.out.format(leftAlignFormat, allPremierLeagueClubs.get(i).getNameOfTheClub(), allPremierLeagueClubs.get(i).getNoOfMatchesPlayed(), allPremierLeagueClubs.get(i).getNoOfWins(), allPremierLeagueClubs.get(i).getNoOfDraws(), allPremierLeagueClubs.get(i).getNoOfDefeats(), allPremierLeagueClubs.get(i).getNoOfGoalsScored(), allPremierLeagueClubs.get(i).getNoOfGoalsReceived(), Math.abs(allPremierLeagueClubs.get(i).getNoOfGoalsScored() - allPremierLeagueClubs.get(i).getNoOfGoalsReceived()), allPremierLeagueClubs.get(i).getNoOfPoints());

        }
        System.out.format("*___________________*_______________________________*_______*________*________*_____________*_________________*__________________*________*%n");


    }

    @Override
    public void addPlayedMatch() {

        String teamA, teamB;
        int year, month, date, scoreA, scoreB, a, b;

        a = 0;
        b = 0;


        teamA = StringValidation("Enter team A name : ");

        teamB = StringValidation("Enter team B name : ");


        while (true) {

            year = IntegerValidation("Enter the year match played : ");

            month = IntegerValidation("Enter the month match played");

            date = IntegerValidation("Enter the date match played : ");
            sc1.nextLine();

            if (dateValidation(year, month, date)) {
                break;
            }
        }

        scoreA = IntegerValidation("Enter team A score : ");

        scoreB = IntegerValidation("Enter team B score");


        Match PL = new Match(teamA, teamB, year, month, date, scoreA, scoreB);
        premierMatch.add(PL);
        System.out.println(premierMatch);


        for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
            if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamA)) {
                a = 1;
            } else {
                System.out.println(teamA + "wasn't found in the League");
            }

        }

        for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
            if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamB)) {
                b = 1;
            } else {
                System.out.println(teamB + "wasn't found in the League");
            }
        }
        if (a == 1 && b == 1) {
            if (scoreA > scoreB) {
                for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                    if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamA)) {
                        allPremierLeagueClubs.get(i).setNoOfWins(allPremierLeagueClubs.get(i).getNoOfWins() + 1);
                        allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + scoreA);
                        allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + scoreB);
                        allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 3);
                        allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                    }

                }
            } else if (scoreA == scoreB) {
                for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                    if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamA)) {
                        allPremierLeagueClubs.get(i).setNoOfDraws(allPremierLeagueClubs.get(i).getNoOfDraws() + 1);
                        allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + scoreA);
                        allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + scoreB);
                        allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 1);
                        allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                    }

                }
            } else if (scoreA < scoreB) {
                for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                    if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamA)) {
                        allPremierLeagueClubs.get(i).setNoOfDefeats(allPremierLeagueClubs.get(i).getNoOfDefeats() + 1);
                        allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + scoreA);
                        allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + scoreB);
                        allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                    }

                }
            }
        }

        if (a == 1 && b == 1) {
            if (scoreB > scoreA) {
                for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                    if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamB)) {
                        allPremierLeagueClubs.get(i).setNoOfWins(allPremierLeagueClubs.get(i).getNoOfWins() + 1);
                        allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + scoreB);
                        allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + scoreA);
                        allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 3);
                        allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                    }

                }
            } else if (scoreB == scoreA) {
                for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                    if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamB)) {
                        allPremierLeagueClubs.get(i).setNoOfDraws(allPremierLeagueClubs.get(i).getNoOfDraws() + 1);
                        allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + scoreB);
                        allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + scoreA);
                        allPremierLeagueClubs.get(i).setNoOfPoints(allPremierLeagueClubs.get(i).getNoOfPoints() + 1);
                        allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                    }

                }
            } else if (scoreB < scoreA) {
                for (int i = 0; i < allPremierLeagueClubs.size(); i++) {
                    if (allPremierLeagueClubs.get(i).getNameOfTheClub().equals(teamB)) {
                        allPremierLeagueClubs.get(i).setNoOfDefeats(allPremierLeagueClubs.get(i).getNoOfDefeats() + 1);
                        allPremierLeagueClubs.get(i).setNoOfGoalsScored(allPremierLeagueClubs.get(i).getNoOfGoalsScored() + scoreB);
                        allPremierLeagueClubs.get(i).setNoOfGoalsReceived(allPremierLeagueClubs.get(i).getNoOfGoalsReceived() + scoreA);
                        allPremierLeagueClubs.get(i).setNoOfMatchesPlayed(allPremierLeagueClubs.get(i).getNoOfMatchesPlayed() + 1);
                    }

                }
            }
        }

    }

    //search played matches by date
    @Override
    public String dateSort(String leagueYear, String leagueMonth, String leagueDate) {

        String setInfrm = "";
        int yr = 0, mon1 = 0, dat1 = 0;

        try {
            yr = Integer.parseInt(leagueYear);
            mon1 = Integer.parseInt(leagueMonth);
            dat1 = Integer.parseInt(leagueDate);
        } catch (Exception e) {
            return setInfrm;
        }

        for (int i = 0; 1 < premierMatch.size(); i++) {
            if (premierMatch.get(i).getYear() == (yr) && premierMatch.get(i).getMonth() == (mon1) && premierMatch.get(i).getDate() == (dat1)) {

                return "Team A : " + premierMatch.get(i).getTeamA() + "\t" + "\t" + "Team B : " + premierMatch.get(i).getTeamB() + "\n" + "\t" + premierMatch.get(i).getTeamAScore() + "\t" + "\t" + "\t" + "\t" + "\t" + premierMatch.get(i).getTeamBScore();
            }
        }

        return "Match cannot be found in the league";


    }

//saving program data to files
    @Override
    public void fWrite1() throws IOException {

        File file1 = new File("File1.txt");
        PrintWriter wt = new PrintWriter("File1.txt");
        wt.print("");

        FileOutputStream fileOut = new FileOutputStream(file1, true);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

        Iterator itr1 = allPremierLeagueClubs.iterator();
        while (itr1.hasNext()) {
            FootballClub fbClube = (FootballClub) itr1.next();
            objOut.writeObject(fbClube);
            wt.close();
        }

    }

    @Override
    public void fRead1() throws IOException {

        FileInputStream fileInt = new FileInputStream("File1.txt");
        ObjectInputStream objInt = new ObjectInputStream(fileInt);
        List<FootballClub> footballClubList_read = new ArrayList<FootballClub>();

        while (true) {
            try {
                FootballClub rFbClub = (FootballClub) objInt.readObject();
                footballClubList_read.add(rFbClub);
            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        allPremierLeagueClubs.addAll(footballClubList_read);

    }

    @Override
    public void fWrite2() throws IOException {

        File file2 = new File("File2.txt");
        PrintWriter wt = new PrintWriter("File2.txt");
        wt.print("");

        FileOutputStream fileOut = new FileOutputStream(file2, true);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

        Iterator itr1 = premierMatch.iterator();
        while (itr1.hasNext()) {
            Match match = (Match) itr1.next();
            objOut.writeObject(match);
            wt.close();
        }

    }

    @Override
    public void fRead2() throws IOException {

        FileInputStream fileInt = new FileInputStream("File2.txt");
        ObjectInputStream objInt = new ObjectInputStream(fileInt);
        List<Match> matchesRead = new ArrayList<Match>();

        while (true) {
            try {
                Match readM = (Match) objInt.readObject();
                matchesRead.add(readM);
            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        premierMatch.addAll(matchesRead);
    }

//validation for the inputs - Date Validation
    public boolean dateValidation(int year, int month, int date) {

        boolean leap = false;

        if (year % 4 == 0) {
            // if the year is century
            if (year % 100 == 0) {
                leap = year % 400 == 0;
            } else {
                leap = true;
            }
        }

        if
        (leap && month == 2 && date < 30) {
            return true;
        } else if (!leap && month == 2 && date < 29) {
            return true;
        } else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (date < 32)) {
            return true;
        } else return (month == 4 || month == 6 || month == 9 || month == 11) && (date < 31);

    }

    //integerValidation for the inputs
    public int IntegerValidation(String view) {
        while (true) {
            System.out.println(view);
            String findVal = sc1.nextLine();
            try {
                int parVal = Integer.parseInt(findVal);
                if (parVal > 0) {
                    return parVal;
                }
                System.out.println("Invalid input");
            } catch (Exception e) {
                System.out.println("Invalid input. Input should be an integer. Please try again");
            }
        }
    }


    //StringValidations
    public String StringValidation(String text) {
        while(true) {
        String regex = "^[a-zA-Z_ ]*$";
        System.out.println(text);
        String findStr = sc1.nextLine();
        if (findStr.matches(regex)) {
            return findStr;
        }
            System.out.println("Invalid input. Please try again");
    }
}

}
