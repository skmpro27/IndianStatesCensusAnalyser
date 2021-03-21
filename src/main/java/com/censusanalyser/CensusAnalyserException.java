package com.censusanalyser;

public class CensusAnalyserException extends Exception {
    enum ExceptionType{
        WRONG_FILE_PATH,
        WRONG_TYPE,
        WRONG_DELIMITER
    }

    ExceptionType type;
    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
