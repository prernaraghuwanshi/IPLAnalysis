package com.bl.iplanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLAnalyserTest {
    IPLAnalyser iplAnalyser;
    private static final String BATTING_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLING_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Before
    public void initialize() {
        iplAnalyser = new IPLAnalyser();
    }

    @Test
    public void givenIPLBattingFile_whenLoaded_shouldGiveNumberOfRecords() {
        try {
            int numberOfRecords = iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Assert.assertEquals(101, numberOfRecords);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_whenLoaded_shouldGiveNumberOfRecords() {
        try {
            int numberOfRecords = iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            Assert.assertEquals(99, numberOfRecords);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithHighestBattingAverage() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Batsman batsman = iplAnalyser.getBatsmanWithHighestAverage();
            Assert.assertEquals("MS Dhoni", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithHighestStrikingRate() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Batsman batsman = iplAnalyser.getBatsmanWithHighestStrikingRate();
            Assert.assertEquals("Ishant Sharma", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumSixes() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumSixes();
            Assert.assertEquals("Andre Russell", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumFours() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumFours();
            Assert.assertEquals("Shikhar Dhawan", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumStrikeRateSixesAndFours() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumStrikeRateSixesAndFours();
            Assert.assertEquals("Andre Russell", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithBestAverageAndStrikeRate() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Batsman batsman = iplAnalyser.getBatsmanWithBestAverageAndStrikeRate();
            Assert.assertEquals("MS Dhoni", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumRunsAndBestAverage() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumRunsAndBestAverage();
            Assert.assertEquals("David Warner ", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithMinimumBowlingAverage() {
        try {
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            Bowler bowler = iplAnalyser.getBowlerWithMinimumBowlingAverage();
            Assert.assertEquals("Anukul Roy", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithTopBowlingStrikeRate() {
        try {
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            Bowler bowler = iplAnalyser.getBowlerWithTopBowlingStrikeRate();
            Assert.assertEquals("Alzarri Joseph", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithBestEconomy() {
        try {
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            Bowler bowler = iplAnalyser.getBowlerWithBestEconomy();
            Assert.assertEquals("Shivam Dube", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithTopBowlingStrikeRateWith5WsAnd4Ws() {
        try {
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            Bowler bowler = iplAnalyser.getBowlerWithTopBowlingStrikeRateWith5WsAnd4Ws();
            Assert.assertEquals("Kagiso Rabada", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithBestBowlingAverageAndStrikeRate() {
        try {
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            Bowler bowler = iplAnalyser.getBowlerWithBestBowlingAverageAndStrikeRate();
            Assert.assertEquals("Anukul Roy", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithMaximumWicketsAndBestBowlingAverage() {
        try {
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            Bowler bowler = iplAnalyser.getBowlerWithMaximumWicketsAndBestBowlingAverage();
            Assert.assertEquals("Imran Tahir", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingAndBowlingFile_shouldGiveAllRounderWithBestBattingAndBowlingAverage() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            AllRounder allRounder = iplAnalyser.getAllRounderWithBestBattingAndBowlingAverage();
            Assert.assertEquals("Harpreet Brar", allRounder.getName());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingAndBowlingFile_shouldGiveAllRounderWithMostRunsAndWickets() {
        try {
            iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
            iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
            AllRounder allRounder = iplAnalyser.getAllRounderWithMostRunsAndWickets();
            Assert.assertEquals("Hardik Pandya", allRounder.getName());
        } catch (IPLAnalyserException e) {
        }
    }
}
