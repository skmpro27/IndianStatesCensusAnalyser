package com.censusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class IndianCensusAnalyserTest {
    private static final String INDIAN_CENSUS_FILE = "C:\\Users\\Manish\\Development\\Assignment\\Day29\\IndianStatesCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenRecordFileLoadReturnNumberOfRecords() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int numRecords = stateCensusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_FILE);
        Assert.assertEquals(29, numRecords);
    }
}
