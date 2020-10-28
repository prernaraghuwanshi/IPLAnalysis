package com.bl.iplanalyser;

import csvbuilder.CSVBuilderFactory;
import csvbuilder.CSVException;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class IPLAnalyser {
    List<Batsman> batsmanList = null;
    List<Bowler> bowlerList = null;

    // Welcome message display function
    public void welcomeMessage() {
        System.out.println("Welcome to IPL Analyser!");
    }

    // Function to load batsmen statistics file
    public int loadBattingFile(String battingFilePath) throws IPLAnalyserException {
        checkFileType(battingFilePath);
        try (Reader reader = Files.newBufferedReader(Paths.get(battingFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            batsmanList = csvBuilder.getCsvFileList(reader, Batsman.class);
            return batsmanList.size();
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.HEADER_DELIMETER_PROBLEM);
        } catch (CSVException e) {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
        }
    }
    // Function to load bowler statistics file
    public int loadBowlingFile(String bowlingFilePath) throws IPLAnalyserException {
        checkFileType(bowlingFilePath);
        try (Reader reader = Files.newBufferedReader(Paths.get(bowlingFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            bowlerList = csvBuilder.getCsvFileList(reader, Batsman.class);
            return bowlerList.size();
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.HEADER_DELIMETER_PROBLEM);
        } catch (CSVException e) {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
        }
    }

    // Check if file is CSV or not
    private void checkFileType(String csvFilePath) throws IPLAnalyserException {
        Pattern patternForCSV = Pattern.compile(".+[.csv]");
        if (!patternForCSV.matcher(csvFilePath).matches())
            throw new IPLAnalyserException("Incorrect file type",
                    IPLAnalyserException.ExceptionType.FILE_TYPE_PROBLEM);
    }


}
