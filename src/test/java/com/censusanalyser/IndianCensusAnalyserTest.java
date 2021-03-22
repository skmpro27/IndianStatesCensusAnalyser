package com.censusanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IndianCensusAnalyserTest {
    private static final String INDIAN_CENSUS_FILE = "C:\\Users\\Manish\\Development\\Assignment\\Day29\\IndianStatesCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INDIAN_CENSUS_WRONG_FILE = "C:\\Users\\Manish\\Development\\Assignment\\Day29\\IndianStatesCensusAnalyser\\src\\main\\resources\\CensusData.csv";
    private static final String STATE_CODE_FILE = "C:\\Users\\Manish\\Development\\Assignment\\Day29\\IndianStatesCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";

    StateCensusAnalyser censusAnalyser;

    @Before
    public void setUp() throws Exception {
        censusAnalyser = new StateCensusAnalyser();
    }

    @Test
    public void givenRecordFileLoadReturnNumberOfRecords() throws CensusAnalyserException {
        int numRecords = censusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_FILE, CensusCSV.INDIA_CENSUS_CSV);
        Assert.assertEquals(29, numRecords);
    }

    @Test
    public void givenRecordWrongFileLoadThrowCustomException() {
        try {
            censusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_WRONG_FILE, CensusCSV.INDIA_CENSUS_CSV);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH, e.type);
        }
    }

    @Test
    public void givenRecordWrongHeaderThrowCustomException() {
        try {
            censusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_FILE, CensusCSV.INDIA_CENSUS_CSV);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_HEADER, e.type);
        }
    }

    @Test
    public void givenStateRecordFileLoadReturnNumberOfRecords() throws CensusAnalyserException {
        int numRecords = censusAnalyser.loadNumberOfRecord(STATE_CODE_FILE, CensusCSV.STATE_CENSUS_CSV);
        Assert.assertEquals(37, numRecords);
    }

    @Test
    public void givenStateRecordWrongFileLoadThrowCustomException() {
        try {
            censusAnalyser.loadNumberOfRecord(INDIAN_CENSUS_WRONG_FILE, CensusCSV.STATE_CENSUS_CSV);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH, e.type);
        }
    }

    @Test
    public void givenStateRecordWrongTypeThrowCustomException() {
        try {
            censusAnalyser.loadNumberOfRecord(STATE_CODE_FILE, CensusCSV.WRONG_CENSUS_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_TYPE, e.type);
        }
    }
}
