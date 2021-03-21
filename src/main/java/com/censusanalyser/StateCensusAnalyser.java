package com.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class StateCensusAnalyser {
    public int loadNumberOfRecord(String indianCensusFile) throws CensusAnalyserException {
        int numRecords = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(indianCensusFile));
            CsvToBeanBuilder<IndianCensusCSV> csvCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvCsvToBeanBuilder.withType(IndianCensusCSV.class);
            csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            csvCsvToBeanBuilder.withSeparator(',');
            CsvToBean<IndianCensusCSV> csvToBean = csvCsvToBeanBuilder.build();

            List<IndianCensusCSV> censusCSVS = csvToBean.parse();
            numRecords = censusCSVS.size();
            return numRecords;
        } catch (NoSuchFileException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
