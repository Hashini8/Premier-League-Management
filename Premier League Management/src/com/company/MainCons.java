package com.company;



import java.util.Scanner;
import java.io.IOException;

public class MainCons {

    public void consMain() {
        PremierLeagueManager clubs = new PremierLeagueManager();
        GInterface guInter = new GInterface();

        try {
            clubs.fRead1();
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            clubs.fRead2();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }

        int userChoice;

        while(true) {

            try{
                //User choices display
                Scanner sc = new Scanner(System.in);
                System.out.println("Choose an option \n");
                System.out.println("Press 1 to Add a club");
                System.out.println("Press 2 to Delete a club");
                System.out.println("Press 3 to Print a club");
                System.out.println("Press 4 to Print the table");
                System.out.println("Press 5 to Start a match");
                System.out.println("Press 6 to Open GUI");
                System.out.println("Press 7 to Save and Quit\n");
                //Getting the choice input
                System.out.print("Your choice : ");
                userChoice = sc.nextInt();

                //Choosing the numbers by the users to the required functions
                if (userChoice == 1) {
                    clubs.addClub();
                }
                else if (userChoice == 2) {
                    clubs.deleteClub();
                }
                else if (userChoice == 3) {
                    clubs.printStatistics();
                }
                else if (userChoice == 4) {
                    clubs.printLeagueTable();
                }
                else if (userChoice == 5) {
                    clubs.addPlayedMatch();
                }
                else if (userChoice == 6) {
                    guInter.guInter_Main();
                }
                else if (userChoice == 7) {
                    clubs.fWrite1();
                    clubs.fWrite2();
                    System.exit(0);
                }
                else{
                    System.out.println("Choice is not valid");
                }
            }
            catch(Exception e3){
                System.out.println("Invalid choice");
            }
        }
    }
}