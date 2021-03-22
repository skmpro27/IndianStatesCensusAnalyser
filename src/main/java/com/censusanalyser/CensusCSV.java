package com.censusanalyser;

public enum CensusCSV {
    INDIA_CENSUS_CSV {
        @Override
        public Class censusCSV() {
            return IndianCensusCSV.class;
        }
    },
    STATE_CENSUS_CSV {
        @Override
        public Class censusCSV() {
            return IndiaStateCodeCSV.class;
        }
    };
    public abstract Class censusCSV();
}
