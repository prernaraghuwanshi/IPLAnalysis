package com.bl.iplanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLAnalyserTest {
    IPLAnalyser iplAnalyser;
    private static final String BATTING_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLING_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Before
    public void initialize() throws IPLAnalyserException {
        iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadBattingFile(BATTING_FILE_PATH);
        iplAnalyser.loadBowlingFile(BOWLING_FILE_PATH);
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
            Batsman batsman = iplAnalyser.getBatsmanWithHighestAverage();
            Assert.assertEquals("MS Dhoni", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithHighestStrikingRate() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithHighestStrikingRate();
            Assert.assertEquals("Ishant Sharma", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumSixes() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumSixes();
            Assert.assertEquals("Andre Russell", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumFours() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumFours();
            Assert.assertEquals("Shikhar Dhawan", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumStrikeRateSixesAndFours() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumStrikeRateSixesAndFours();
            Assert.assertEquals("Andre Russell", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithBestAverageAndStrikeRate() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithBestAverageAndStrikeRate();
            Assert.assertEquals("MS Dhoni", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumRunsAndBestAverage() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumRunsAndBestAverage();
            Assert.assertEquals("David Warner ", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithMinimumBowlingAverage() {
        try {
            Bowler bowler = iplAnalyser.getBowlerWithMinimumBowlingAverage();
            Assert.assertEquals("Anukul Roy", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithTopBowlingStrikeRate() {
        try {
            Bowler bowler = iplAnalyser.getBowlerWithTopBowlingStrikeRate();
            Assert.assertEquals("Alzarri Joseph", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithBestEconomy() {
        try {
            Bowler bowler = iplAnalyser.getBowlerWithBestEconomy();
            Assert.assertEquals("Shivam Dube", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithTopBowlingStrikeRateWith5WsAnd4Ws() {
        try {
            Bowler bowler = iplAnalyser.getBowlerWithTopBowlingStrikeRateWith5WsAnd4Ws();
            Assert.assertEquals("Kagiso Rabada", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithBestBowlingAverageAndStrikeRate() {
        try {
            Bowler bowler = iplAnalyser.getBowlerWithBestBowlingAverageAndStrikeRate();
            Assert.assertEquals("Anukul Roy", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBowlingFile_shouldGiveBowlerWithMaximumWicketsAndBestBowlingAverage() {
        try {
            Bowler bowler = iplAnalyser.getBowlerWithMaximumWicketsAndBestBowlingAverage();
            Assert.assertEquals("Imran Tahir", bowler.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingAndBowlingFile_shouldGiveAllRounderWithBestBattingAndBowlingAverage() {
        AllRounder allRounder = iplAnalyser.getAllRounderWithBestBattingAndBowlingAverage();
        Assert.assertEquals("Harpreet Brar", allRounder.getName());
    }

    @Test
    public void givenIPLBattingAndBowlingFile_shouldGiveAllRounderWithMostRunsAndWickets() {
        AllRounder allRounder = iplAnalyser.getAllRounderWithMostRunsAndWickets();
        Assert.assertEquals("Hardik Pandya", allRounder.getName());
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithMaximumHundredsAndBestAverage() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithMaximumHundredsAndBestAverage();
            Assert.assertEquals("David Warner ", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLBattingFile_shouldGiveBatsmanWithNoHundredsAndFiftiesButBestAverage() {
        try {
            Batsman batsman = iplAnalyser.getBatsmanWithNoHundredsAndFiftiesButBestAverage();
            Assert.assertEquals("Marcus Stoinis", batsman.getPlayer());
        } catch (IPLAnalyserException e) {
        }
    }
}
