package com.censusanalyser;

public class CensusAnalyserException extends Exception {
    enum ExceptionType{
        WRONG_FILE_PATH
    }

    ExceptionType type;
    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
