package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndianCensusCSV {
    @CsvBindByName(column = "state", required = true)
    public String state;

    @CsvBindByName(column = "population", required = true)
    public String population;

    @CsvBindByName(column = "areaInSqKm", required = true)
    public String areaInSqKm;

    @CsvBindByName(column = "densityPerSqKm", required = true)
    public String densityPerSqKm;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "State='" + state + '\'' +
                ", Population='" + population + '\'' +
                ", AreaInSqKm='" + areaInSqKm + '\'' +
                ", DensityPerSqKm='" + densityPerSqKm + '\'' +
                '}';
    }
}
