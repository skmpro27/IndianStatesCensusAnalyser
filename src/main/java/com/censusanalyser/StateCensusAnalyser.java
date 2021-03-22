package com.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class StateCensusAnalyser<K> {
    CensusCSV typeCSV = CensusCSV.INDIA_CENSUS_CSV;
    private static final char DELIMITER = ',';
    private static final Class<IndianCensusCSV> TYPE = IndianCensusCSV.class;

    char delimiter = DELIMITER;

    public int loadNumberOfRecord(String indianCensusFile, CensusCSV typeCSV) throws CensusAnalyserException {
        this.typeCSV = typeCSV;
        int numRecords = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(indianCensusFile));
            CsvToBeanBuilder<K> csvCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvCsvToBeanBuilder.withType(typeCSV.censusCSV());
            csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);

            csvCsvToBeanBuilder.withSeparator(delimiter);
            CsvToBean<K> csvToBean = csvCsvToBeanBuilder.build();

            List<K> censusCSVS = csvToBean.parse();
            numRecords = censusCSVS.size();
        } catch (NoSuchFileException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
        } catch (RuntimeException e) {
            if (delimiter != DELIMITER)
                throw new CensusAnalyserException(e.getMessage(),
                        CensusAnalyserException.ExceptionType.WRONG_DELIMITER);
            if (typeCSV.censusCSV() != TYPE)
                throw new CensusAnalyserException(e.getMessage(),
                        CensusAnalyserException.ExceptionType.WRONG_TYPE);

            throw  new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.WRONG_HEADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numRecords;
    }
}
