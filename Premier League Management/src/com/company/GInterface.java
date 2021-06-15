package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;

public class GInterface extends Application {

    public static PremierLeagueManager clubs = new PremierLeagueManager();

    //sorting by goals scored
    public static Comparator goalSorting() {
        Comparator<FootballClub>gSort = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o_1, FootballClub o_2) {
                return o_2.getNoOfGoalsScored()-o_1.getNoOfGoalsScored();
            }
        };
        return gSort;
    }

    //sorting by wins
    public static Comparator winsSorting() {
        Comparator<FootballClub>wSort = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o1, FootballClub o2) {
                return o2.getNoOfWins()-o1.getNoOfWins();
            }
        };
        return wSort;
    }

    MainCons mainLeaguePre = new MainCons();

    public static void main(String[] args)throws IOException {
        launch(args);
    }

    @Override
    public  void start(Stage primaryStage) throws Exception {

        mainLeaguePre.consMain();

    }


        public static void guInter_Main () throws FileNotFoundException {
            Stage stageLeague = new Stage();
            Scene sn1, sn2, sn3, sn4,sn5;


            //Creating SCENE1  (head interface)

            Pane paneMain1 = new Pane();
            sn1 = new Scene(paneMain1, 600, 550);


            Pane paneMain2 = new Pane();
            sn2 = new Scene(paneMain2, 600, 600);


            Pane paneMain3 = new Pane();
            sn3 = new Scene(paneMain3, 600, 550);


            Pane paneMain4 = new Pane();
            sn4 = new Scene(paneMain4, 600, 550);

            Pane paneMain5 = new Pane();
            sn5 = new Scene(paneMain5, 600, 550);


            //<<<<<<<Pane1-MainPage>>>>>>>>

            //Label for the title
            Label mainLbl1 = new Label("Premier League - 2021");
            mainLbl1.setLayoutX(125);
            mainLbl1.setLayoutY(45);
            mainLbl1.setPrefWidth(450);
            mainLbl1.setPrefHeight(60);
            mainLbl1.setStyle("-fx-font-size:34px ;-fx-text-fill:black");


            //Button1 to view the table
            Button mainBtn1 = new Button("Premier League Table");
            mainBtn1.setLayoutX(200);
            mainBtn1.setLayoutY(145);
            mainBtn1.setPrefWidth(200);
            mainBtn1.setPrefHeight(40);
            mainBtn1.setStyle("-fx-font-size:16px");


            //Button to start a random match
            Button mainBtn2 = new Button("Start a match");
            mainBtn2.setLayoutX(200);
            mainBtn2.setLayoutY(230);
            mainBtn2.setPrefWidth(200);
            mainBtn2.setPrefHeight(40);
            mainBtn2.setStyle("-fx-font-size:16px");
            mainBtn2.setOnAction(e -> stageLeague.setScene(sn3));


            //Button to view history
            Button mainBtn3 = new Button("History");
            mainBtn3.setLayoutX(200);
            mainBtn3.setLayoutY(310);
            mainBtn3.setPrefWidth(200);
            mainBtn3.setPrefHeight(40);
            mainBtn3.setStyle("-fx-font-size:16px");


            //Button to quit
            Button mainBtn4 = new Button("Quit");
            mainBtn4.setLayoutX(200);
            mainBtn4.setLayoutY(380);
            mainBtn4.setPrefWidth(200);
            mainBtn4.setPrefHeight(40);
            mainBtn4.setStyle("-fx-font-size:16px");
            mainBtn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = (Stage) mainBtn4.getScene().getWindow();
                    stage.close();
                }
            });

            //an image for the main page
            Image picPrem1 =new Image("Image/Gri.png");
            ImageView coverImg1 =new ImageView();
            coverImg1.setImage(picPrem1);
            coverImg1.setFitWidth(600);
            coverImg1.setFitHeight(600);

            paneMain1.getChildren().addAll(coverImg1,mainLbl1, mainBtn1, mainBtn2, mainBtn3, mainBtn4);


            //Creating SCENE2  (table)

            //Creating the table

            //label for the table title
            Label tabLab = new Label("Table");
            tabLab.setLayoutX(250);
            tabLab.setLayoutY(3);
            tabLab.setPrefWidth(450);
            tabLab.setPrefHeight(60);
            tabLab.setStyle("-fx-font-size:34px ;-fx-text-fill:white");


            TableView<FootballClub> tableStats = new TableView();
            tableStats.setPrefSize(590, 470);
            tableStats.setLayoutX(5);
            tableStats.setLayoutY(60);
            TableColumn<FootballClub, String> colTab = new TableColumn();
            colTab.setMaxWidth(120);
            colTab.setMinWidth(120);
            PropertyValueFactory colTabNam = new PropertyValueFactory("nameOfTheClub");
            colTab.setCellValueFactory(colTabNam);


            tableStats.getColumns().addAll(
                    columnNumberString("Club Name", "nameOfTheClub", 125),
                    columnNumberInt("matchers", "noOfMatchesPlayed", 60),
                    columnNumberInt("Wins", "noOfWins", 40),
                    columnNumberInt("Draws", "noOfDraws", 40),
                    columnNumberInt("Losses", "noOfDefeats", 42),
                    columnNumberInt("Goals For", "noOfGoalsScored", 60),
                    columnNumberInt("Goals Against", "noOfGoalsReceived", 82),
                    columnNumberInt("Goal Difference", "goalDiff", 93),
                    columnNumberInt("Points", "noOfPoints", 45)

            );


            for (FootballClub updateTable :clubs.allPremierLeagueClubs) {
                tableStats.getItems().addAll(updateTable);
            }


            //Button to go back to the main page
            Button backBtn1 = new Button("BACK");
            backBtn1.setLayoutX(60);
            backBtn1.setLayoutY(550);
            backBtn1.setPrefWidth(100);
            backBtn1.setPrefHeight(40);
            backBtn1.setStyle("-fx-font-size:15px");
            backBtn1.setOnAction(e -> stageLeague.setScene(sn1));


            //button to sort by goals
            Button glBtn = new Button("GOALS");
            glBtn.setLayoutX(185);
            glBtn.setLayoutY(550);
            glBtn.setPrefWidth(100);
            glBtn.setPrefHeight(40);
            glBtn.setStyle("-fx-font-size:15px");
            glBtn.setOnAction(e -> {
                tableStats.getItems().clear();
                clubs.allPremierLeagueClubs.sort(goalSorting());

                for (FootballClub updateTable : clubs.allPremierLeagueClubs) {
                    tableStats.getItems().addAll(updateTable);
                }

            });


            //button to sort by wins
            Button vnBtn = new Button("WINS");
            vnBtn.setLayoutX(435);
            vnBtn.setLayoutY(550);
            vnBtn.setPrefWidth(100);
            vnBtn.setPrefHeight(40);
            vnBtn.setStyle("-fx-font-size:15px");
            vnBtn.setOnAction(e -> {
                tableStats.getItems().clear();
                clubs.allPremierLeagueClubs.sort(winsSorting());

                for (FootballClub Iterate : clubs.allPremierLeagueClubs) {
                    tableStats.getItems().addAll(Iterate);
                }

            });


            Button statsBtn = new Button("STATISTICS");
            statsBtn.setLayoutX(310);
            statsBtn.setLayoutY(550);
            statsBtn.setPrefWidth(100);
            statsBtn.setPrefHeight(40);
            statsBtn.setStyle("-fx-font-size:15px");
            statsBtn.setOnAction(e -> {
                tableStats.getItems().clear();
                clubs.allPremierLeagueClubs.sort(FootballClub::compareTo);

                for (FootballClub updateTable : clubs.allPremierLeagueClubs) {
                    tableStats.getItems().addAll(updateTable);
                }

            });

            Image picPrem2 =new Image("Image/ath.png");
            ImageView coverImg2 =new ImageView();
            coverImg2.setImage(picPrem2);
            coverImg2.setFitWidth(600);
            coverImg2.setFitHeight(600);

            paneMain2.getChildren().addAll( coverImg2,backBtn1,tabLab, glBtn, statsBtn, vnBtn, tableStats);


            //generate random matches


            //label for the match title
            Label mat1 = new Label("Match");
            mat1.setLayoutX(250);
            mat1.setLayoutY(30);
            mat1.setPrefWidth(200);
            mat1.setPrefHeight(60);
            mat1.setStyle("-fx-font-size:34px ;-fx-text-fill:black");

            //new pane for the generated output to display
            Pane matP = new Pane();
            matP.setPrefHeight(200);
            matP.setPrefWidth(350);
            matP.setLayoutY(150);
            matP.setLayoutX(130);
            matP.setStyle("-fx-background-color: white");

            //labels for the outputs
            Label matLbl1 = new Label("");
            matLbl1.setLayoutX(150);
            matLbl1.setLayoutY(100);
            matLbl1.setPrefWidth(200);
            matLbl1.setPrefHeight(60);

            Label matLbl2 = new Label("");
            matLbl2.setLayoutX(150);
            matLbl2.setLayoutY(150);
            matLbl2.setPrefWidth(200);
            matLbl2.setPrefHeight(60);

            //button to go back for the main page
            Button backBtn2 = new Button("BACK");
            backBtn2.setLayoutX(340);
            backBtn2.setLayoutY(400);
            backBtn2.setPrefWidth(100);
            backBtn2.setPrefHeight(40);
            backBtn2.setStyle("-fx-font-size:15px");
            backBtn2.setOnAction(e -> stageLeague.setScene(sn1));

            //generate button is used to generate random matches
            Button genBtn1 = new Button("GENERATE");
            genBtn1.setLayoutX(180);
            genBtn1.setLayoutY(400);
            genBtn1.setPrefWidth(100);
            genBtn1.setPrefHeight(40);
            genBtn1.setStyle("-fx-font-size:15px");
            genBtn1.setOnAction(e -> stageLeague.setScene(sn1));
            genBtn1.setOnAction(e -> {
                Match newMatchclub = clubs.MatGen();
                matLbl1.setText("" + newMatchclub.getDate() + "/" + newMatchclub.getMonth() + "/" + newMatchclub.getYear());
                matLbl2.setText("" + newMatchclub.getTeamA() + "\t" + newMatchclub.getTeamAScore() + "\t" + "VS" + "\t" + newMatchclub.getTeamBScore() + "\t" + newMatchclub.getTeamB());
            });


            Image picPrem3 =new Image("Image/Chel.png");
            ImageView coverImg3 =new ImageView();
            coverImg3.setImage(picPrem3);
            coverImg3.setFitWidth(600);
            coverImg3.setFitHeight(600);


            paneMain3.getChildren().addAll(coverImg3,matP,mat1, backBtn2, genBtn1,matLbl1,matLbl2);

            //HistOry button to view the past matches

            //label for the past matches title
            Label LH_1 =new Label("Past Matches");
            LH_1.setLayoutX(100);
            LH_1.setLayoutY(2);
            LH_1.setPrefWidth(280);
            LH_1.setPrefHeight(60);
            LH_1.setStyle("-fx-font-size:35px ;-fx-text-fill:black");

            //goes back to the main page
            Button backBtn3 = new Button("Back");
            backBtn3.setLayoutX(480);
            backBtn3.setLayoutY(500);
            backBtn3.setStyle("-fx-font-size:15px");
            backBtn3.setPrefSize(70, 20);
            backBtn3.setOnAction(event -> stageLeague.setScene(sn1));

            //text field to enter the year
            TextField textF1 = new TextField();
            textF1.setLayoutX(380);
            textF1.setLayoutY(5);
            textF1.setPrefSize(80,20);
            textF1.setStyle("-fx-font-size:20px");

            //month is entered to this text field
            TextField textF2 = new TextField();
            textF2.setLayoutX(470);
            textF2.setLayoutY(5);
            textF2.setPrefSize(50,20);
            textF2.setStyle("-fx-font-size:20px");


            //date entered to this text field
            TextField textF3 = new TextField();
            textF3.setLayoutX(530);
            textF3.setLayoutY(5);
            textF3.setPrefSize(50,20);
            textF3.setStyle("-fx-font-size:20px");

            //button to search the past played matches
            Button bt_sear= new Button("Search");
            bt_sear.setLayoutX(430);
            bt_sear.setLayoutY(55);
            bt_sear.setPrefWidth(80);
            bt_sear.setPrefHeight(30);
            bt_sear.setStyle("-fx-font-size:15px");


            //second Table - 2


            TableView<Match> tabMat = new TableView();
            tabMat.setPrefSize(565, 400);
            tabMat.setLayoutX(20);
            tabMat.setLayoutY(90);
            TableColumn<Match, String> colTab_l = new TableColumn();
            colTab_l.setMaxWidth(120);
            colTab_l.setMinWidth(120);
            PropertyValueFactory tabColNam2 = new PropertyValueFactory("Home Club Name");
            colTab_l.setCellValueFactory(tabColNam2);

            tabMat.getColumns().addAll(
                    columnMatchString("HomeClub Name ", "teamA", 120),
                    columnNumberString("AwayClub Name", "teamB", 120),
                    columnNumberInt("HomeClub Goal", "teamAScore", 100),
                    columnNumberInt("AwayClub Goal", "teamBScore", 90),
                    columnNumberInt("Year", "year", 45),
                    columnNumberInt("Month", "month", 45),
                    columnNumberInt("Date", "date", 45)


            );

            for (Match updateTable_2 : clubs.premierMatch) {
                tabMat.getItems().addAll(updateTable_2);
            }


            Image picPrem4 =new Image("Image/Haza.png");
            ImageView coverImg4 =new ImageView();
            coverImg4.setImage(picPrem4);
            coverImg4.setFitWidth(760);
            coverImg4.setFitHeight(840);

            paneMain4.getChildren().addAll(coverImg4,LH_1,tabMat,bt_sear, backBtn3, textF1, textF2,textF3);


            /////search by date

            Button backBtn4 = new Button("Back");
            backBtn4.setLayoutX(60);
            backBtn4.setLayoutY(450);
            backBtn4.setStyle("-fx-font-size:20px");
            backBtn4.setPrefSize(90, 25);
            backBtn4.setOnAction(event -> stageLeague.setScene(sn1));

            //textarea to get the sorted matches played in a day
            TextArea Tarea1 = new TextArea();
            Tarea1.setLayoutX(65);
            Tarea1.setLayoutY(50);
            Tarea1.setPrefSize(470,340);
            Tarea1.setStyle("-fx-font-size:35px;");


            paneMain5.getChildren().addAll(backBtn4,Tarea1);


            //action for update and main

            //1 Table

            mainBtn1.setOnAction(e -> {
                        stageLeague.setScene(sn2);
                        tableStats.getItems().clear();
                        clubs.allPremierLeagueClubs.sort(FootballClub::compareTo);

                        for (FootballClub updateTable : clubs.allPremierLeagueClubs) {
                            tableStats.getItems().addAll(updateTable);
                        }

                    }
            );

            //2 Table

            mainBtn3.setOnAction(e -> {
                stageLeague.setScene(sn4);
                tabMat.getItems().clear();
                clubs.premierMatch.sort(Match::compareTo);

                for (Match updateTable_2 : clubs.premierMatch) {
                    tabMat.getItems().addAll(updateTable_2);
                }
            }
        );

            //search

            bt_sear.setOnAction(e -> {


                stageLeague.setScene(sn5);
                Tarea1.setText(clubs.dateSort(textF1.getText(), textF2.getText(), textF3.getText()));

            });

            stageLeague.setScene(sn1);
            stageLeague.showAndWait();


        }

        public static TableColumn columnNumberString (String titCol, String valColm,int colWidth){
            TableColumn<FootballClub, String> tblCol = new TableColumn(titCol);
            tblCol.setMaxWidth(colWidth);
            tblCol.setMinWidth(colWidth);
            PropertyValueFactory colName = new PropertyValueFactory(valColm);
            tblCol.setCellValueFactory(colName);
            return tblCol;

        }
        public static TableColumn columnNumberInt (String titCol, String valColm,int widCol){
            TableColumn<FootballClub, Integer> colTab = new TableColumn(titCol);
            colTab.setMaxWidth(widCol);
            colTab.setMinWidth(widCol);
            PropertyValueFactory colTabNam = new PropertyValueFactory(valColm);
            colTab.setCellValueFactory(colTabNam);
            return colTab;

        }
        //table 2
        public static TableColumn columnMatchInt (String titCol, String colValue,int widCol){
            TableColumn<Match, Integer> colTab = new TableColumn(titCol);
            colTab.setMaxWidth(widCol);
            colTab.setMinWidth(widCol);
            PropertyValueFactory colTabNam = new PropertyValueFactory(colValue);
            colTab.setCellValueFactory(colTabNam);
            return colTab;

        }

        public static TableColumn columnMatchString (String titCol, String valColm,int widCol){
            TableColumn<Match, String> colTab = new TableColumn(titCol);
            colTab.setMaxWidth(widCol);
            colTab.setMinWidth(widCol);
            PropertyValueFactory colTabNam = new PropertyValueFactory(valColm);
            colTab.setCellValueFactory(colTabNam);
            return colTab;

        }

}
