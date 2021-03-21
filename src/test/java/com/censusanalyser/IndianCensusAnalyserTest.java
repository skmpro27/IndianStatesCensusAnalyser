package com.censusanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IndianCensusAnalyserTest {
    private static final String INDIAN_CENSUS_FILE = "C:\\Users\\Manish\\Development\\Assignment\\Day29\\IndianStatesCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INDIAN_CENSUS_WRONG_FILE = "C:\\Users\\Manish\\Development\\Assignment\\Day29\\IndianStatesCensusAnalyser\\src\\main\\resources\\CensusData.csv";

    StateCensusAnalyser censusAnalyser;

    @Before
    public void setUp() throws Exception {
        censusAnalyser = new StateCensusAnalyser();
    }

    @Test
    public void givenRecordFileLoadReturnNumberOfRecords() throws CensusAnalyserException {
        int numRecords = censusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_FILE);
        Assert.assertEquals(29, numRecords);
    }

    @Test
    public void givenRecordWrongFileLoadThrowCustomException() {
        try {
            censusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_WRONG_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH, e.type);
        }
    }

    @Test
    public void givenRecordWrongTypeThrowCustomException() {
        try {
            censusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_TYPE, e.type);
        }
    }
}
