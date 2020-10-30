package com.bl.iplanalyser;

import csvbuilder.CSVBuilderFactory;
import csvbuilder.CSVException;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
            bowlerList = csvBuilder.getCsvFileList(reader, Bowler.class);
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

    // Returns Batsman with highest batting average
    public Batsman getBatsmanWithHighestAverage() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        List<Batsman> batsmanAverageList = batsmanList.stream().sorted(Comparator.comparing(Batsman::getAverageScore).reversed()).collect(Collectors.toList());
        return batsmanAverageList.get(0);
    }

    // Returns Batsman with highest striking rate
    public Batsman getBatsmanWithHighestStrikingRate() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        List<Batsman> batsmanStrikingRateList = batsmanList.stream().sorted(Comparator.comparing(Batsman::getStrikeRate).reversed()).collect(Collectors.toList());
        return batsmanStrikingRateList.get(0);
    }

    // Returns Batsman with maximum number of sixes
    public Batsman getBatsmanWithMaximumSixes() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        List<Batsman> batsmanMaximumSixes = batsmanList.stream().sorted(Comparator.comparing(Batsman::getSixes).reversed()).collect(Collectors.toList());
        return batsmanMaximumSixes.get(0);
    }

    // Returns Batsman with maximum number of fours
    public Batsman getBatsmanWithMaximumFours() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        List<Batsman> batsmanMaximumSixes = batsmanList.stream().sorted(Comparator.comparing(Batsman::getFours).reversed()).collect(Collectors.toList());
        return batsmanMaximumSixes.get(0);
    }

    // Returns Batsman with maximum strike rate, sixes and fours
    public Batsman getBatsmanWithMaximumStrikeRateSixesAndFours() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        Comparator<Batsman> batsmanComparator = Comparator.comparing(Batsman::getSixes, Comparator.reverseOrder())
                .thenComparing(Batsman::getFours, Comparator.reverseOrder())
                .thenComparing(Batsman::getStrikeRate, Comparator.reverseOrder());
        List<Batsman> batsmanMaximumSixesFoursStrikeRate = batsmanList.stream().sorted(batsmanComparator).collect(Collectors.toList());
        return batsmanMaximumSixesFoursStrikeRate.get(0);
    }

    // Returns Batsman with best average and strike rate
    public Batsman getBatsmanWithBestAverageAndStrikeRate() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        Comparator<Batsman> batsmanComparator = Comparator.comparing(Batsman::getAverageScore, Comparator.reverseOrder())
                .thenComparing(Batsman::getStrikeRate, Comparator.reverseOrder());
        List<Batsman> batsmanBestAverageAndStrikeRate = batsmanList.stream().sorted(batsmanComparator).collect(Collectors.toList());
        return batsmanBestAverageAndStrikeRate.get(0);
    }

    // Returns Batsman with maximum runs and best average
    public Batsman getBatsmanWithMaximumRunsAndBestAverage() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        Comparator<Batsman> batsmanComparator = Comparator.comparing(Batsman::getRuns, Comparator.reverseOrder())
                .thenComparing(Batsman::getAverageScore, Comparator.reverseOrder());
        List<Batsman> batsmanMaximumRunsAndBestAverage = batsmanList.stream().sorted(batsmanComparator).collect(Collectors.toList());
        return batsmanMaximumRunsAndBestAverage.get(0);
    }

    //Returns bowler with best bowling average
    public Bowler getBowlerWithMinimumBowlingAverage() throws IPLAnalyserException {
        checkEmptyList(bowlerList);
        Comparator<Bowler> bowlerComparator = Comparator.comparing(Bowler::getAverage);
        List<Bowler> bowlerBestAverage = bowlerList.stream().filter(bowler -> bowler.getAverage() > 0).sorted(bowlerComparator).collect(Collectors.toList());
        return bowlerBestAverage.get(0);
    }

    //Returns bowler with top bowling strike rate
    public Bowler getBowlerWithTopBowlingStrikeRate() throws IPLAnalyserException {
        checkEmptyList(bowlerList);
        Comparator<Bowler> bowlerComparator = Comparator.comparing(Bowler::getStrikeRate);
        List<Bowler> bowlerBestStrikeRate = bowlerList.stream().filter(bowler -> bowler.getStrikeRate() > 0).sorted(bowlerComparator).collect(Collectors.toList());
        return bowlerBestStrikeRate.get(0);
    }

    //Returns bowler with best economy
    public Bowler getBowlerWithBestEconomy() throws IPLAnalyserException {
        checkEmptyList(bowlerList);
        Comparator<Bowler> bowlerComparator = Comparator.comparing(Bowler::getEconomy);
        List<Bowler> bowlerBestEconomy = bowlerList.stream().filter(bowler -> bowler.getEconomy() > 0).sorted(bowlerComparator).collect(Collectors.toList());
        return bowlerBestEconomy.get(0);
    }

    //Returns bowler with top bowling strike rate, 5Ws and 4Ws
    public Bowler getBowlerWithTopBowlingStrikeRateWith5WsAnd4Ws() throws IPLAnalyserException {
        checkEmptyList(bowlerList);
        Comparator<Bowler> bowlerComparator = Comparator.comparing(s -> s.getFourWicket() + s.getFiveWicket());
        bowlerComparator = bowlerComparator.reversed();
        bowlerComparator = bowlerComparator.thenComparing(Bowler::getStrikeRate);
        List<Bowler> bowlerBestStrikeRate5W4W = bowlerList.stream().filter(bowler -> bowler.getStrikeRate() > 0).sorted(bowlerComparator).collect(Collectors.toList());
        return bowlerBestStrikeRate5W4W.get(0);
    }

    //Returns bowler with best bowling average and strike rate
    public Bowler getBowlerWithBestBowlingAverageAndStrikeRate() throws IPLAnalyserException {
        checkEmptyList(bowlerList);
        Comparator<Bowler> bowlerComparator = Comparator.comparing(Bowler::getAverage).thenComparing(Bowler::getStrikeRate);
        List<Bowler> bowlerBestAverageAndStrikeRate = bowlerList.stream().filter(bowler -> bowler.getStrikeRate() > 0).sorted(bowlerComparator).collect(Collectors.toList());
        return bowlerBestAverageAndStrikeRate.get(0);
    }

    //Returns bowler with maximum wickets and best bowling average
    public Bowler getBowlerWithMaximumWicketsAndBestBowlingAverage() throws IPLAnalyserException {
        checkEmptyList(bowlerList);
        Comparator<Bowler> bowlerComparator = Comparator.comparing(Bowler::getWickets).reversed().thenComparing(Bowler::getAverage);
        List<Bowler> bowlerMaxWicketsAndBestAverage = bowlerList.stream().filter(bowler -> bowler.getAverage() > 0).sorted(bowlerComparator).collect(Collectors.toList());
        return bowlerMaxWicketsAndBestAverage.get(0);
    }

    //Returns all-rounder with best batting and bowling average
    public AllRounder getAllRounderWithBestBattingAndBowlingAverage() throws IPLAnalyserException {
        List<AllRounder> allRounderList = populateAllRounderList();
        Comparator<AllRounder> allRounderComparator = Comparator.comparing(allRounder -> (allRounder.getBattingAverage() / allRounder.getBowlingAverage()), Comparator.reverseOrder());
        List<AllRounder> allRounderBestBattingAndBowlingAverage = allRounderList.stream().sorted(allRounderComparator).collect(Collectors.toList());
        return allRounderBestBattingAndBowlingAverage.get(0);
    }

    //Returns all-rounder with most runs and wickets
    public AllRounder getAllRounderWithMostRunsAndWickets() {
        List<AllRounder> allRounderList = populateAllRounderList();
        Comparator<AllRounder> allRounderComparator = Comparator.comparing(allRounder -> (allRounder.getRuns() * allRounder.getWickets()), Comparator.reverseOrder());
        List<AllRounder> allRounderMostRunsAndWickets = allRounderList.stream().sorted(allRounderComparator).collect(Collectors.toList());
        return allRounderMostRunsAndWickets.get(0);
    }

    // Returns Batsman with maximum hundreds and best average
    public Batsman getBatsmanWithMaximumHundredsAndBestAverage() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        Comparator<Batsman> batsmanComparator = Comparator.comparing(Batsman::getHundreds, Comparator.reverseOrder())
                .thenComparing(Batsman::getAverageScore, Comparator.reverseOrder());
        List<Batsman> batsmanMaximumHundredsAndBestAverage = batsmanList.stream().sorted(batsmanComparator).collect(Collectors.toList());
        return batsmanMaximumHundredsAndBestAverage.get(0);
    }

    // Returns Batsman with no hundreds and fifties but best average
    public Batsman getBatsmanWithNoHundredsAndFiftiesButBestAverage() throws IPLAnalyserException {
        checkEmptyList(batsmanList);
        Comparator<Batsman> batsmanComparator = Comparator.comparing(Batsman::getAverageScore, Comparator.reverseOrder());
        List<Batsman> batsmanNoHundredsFiftiesButBestAverage = batsmanList.stream().filter(batsman -> batsman.hundreds==0 && batsman.fifties==0)
                .sorted(batsmanComparator).collect(Collectors.toList());
        return batsmanNoHundredsFiftiesButBestAverage.get(0);
    }

    //Fill allrounders list
    private List<AllRounder> populateAllRounderList() {
        List<AllRounder> allRounderList = new ArrayList<>();
        batsmanList.stream().forEach(batsman -> {
            bowlerList.stream().forEach(bowler -> {
                if (batsman.player.equals(bowler.player))
                    allRounderList.add(new AllRounder(batsman.player, batsman.averageScore, bowler.average, bowler.wickets, batsman.runs));
            });
        });
        return allRounderList;
    }

    // Check if file is CSV or not
    private void checkFileType(String csvFilePath) throws IPLAnalyserException {
        Pattern patternForCSV = Pattern.compile(".+[.csv]");
        if (!patternForCSV.matcher(csvFilePath).matches())
            throw new IPLAnalyserException("Incorrect file type",
                    IPLAnalyserException.ExceptionType.FILE_TYPE_PROBLEM);
    }

    //Check empty list or not
    private <E> void checkEmptyList(List<E> list) throws IPLAnalyserException {
        if (list.size() == 0 || list == null) {
            throw new IPLAnalyserException("No Data Available", IPLAnalyserException.ExceptionType.NO_DATA);
        }
    }
}
