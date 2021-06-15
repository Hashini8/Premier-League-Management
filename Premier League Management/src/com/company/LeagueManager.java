package com.company;

import java.io.IOException;

public interface LeagueManager  {

    public void addClub();
    public void deleteClub();
    public void printStatistics();
    public void printLeagueTable();
    public void addPlayedMatch();
    public String dateSort(String Year, String Month, String Date);
    public void fWrite1() throws IOException;
    public void fRead1() throws IOException;
    public void fWrite2() throws IOException;
    public void fRead2() throws IOException;

}
