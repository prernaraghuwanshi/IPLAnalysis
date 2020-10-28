package com.bl.iplanalyser;

import org.junit.Before;

public class IPLAnalyserTest {
    IPLAnalyser iplAnalyser;

    @Before
    public void initialize() {
        iplAnalyser = new IPLAnalyser();
        iplAnalyser.welcomeMessage();
    }
}
