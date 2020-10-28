package com.bl.iplanalyser;

import com.opencsv.bean.CsvBindByName;

public class Batsman {
    @CsvBindByName(column = "POS")
    public int position;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat")
    public int matches;

    @CsvBindByName(column = "Inns")
    public int innings;

    @CsvBindByName(column = "NO")
    public int notOuts;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "HS")
    public String highestScore;

    @CsvBindByName(column = "Avg")
    public double averageScore;

    @CsvBindByName(column = "BF")
    public int bf;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "100")
    public int hundreds;

    @CsvBindByName(column = "50")
    public int fifties;

    @CsvBindByName(column = "4s")
    public int fours;

    @CsvBindByName(column = "6s")
    public int sixes;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public int getNotOuts() {
        return notOuts;
    }

    public void setNotOuts(int notOuts) {
        this.notOuts = notOuts;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(String highestScore) {
        this.highestScore = highestScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    @Override
    public String toString() {
        return "Batsman{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", notOuts=" + notOuts +
                ", runs=" + runs +
                ", highestScore='" + highestScore + '\'' +
                ", averageScore=" + averageScore +
                ", bf=" + bf +
                ", strikeRate=" + strikeRate +
                ", hundreds=" + hundreds +
                ", fifties=" + fifties +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}
