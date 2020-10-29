package com.bl.iplanalyser;

public class AllRounder {
    private String name;
    private double battingAverage;
    private double bowlingAverage;
    private int wickets;
    private int runs;

    public AllRounder(String name, double battingAverage, double bowlingAverage, int wickets, int runs) {
        this.name = name;
        this.battingAverage = battingAverage;
        this.bowlingAverage = bowlingAverage;
        this.wickets = wickets;
        this.runs = runs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public double getBowlingAverage() {
        return bowlingAverage;
    }

    public void setBowlingAverage(double bowlingAverage) {
        this.bowlingAverage = bowlingAverage;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return "AllRounder{" +
                "name='" + name + '\'' +
                ", battingAverage=" + battingAverage +
                ", bowlingAverage=" + bowlingAverage +
                ", wickets=" + wickets +
                ", runs=" + runs +
                '}';
    }
}
