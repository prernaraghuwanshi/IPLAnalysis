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



}
