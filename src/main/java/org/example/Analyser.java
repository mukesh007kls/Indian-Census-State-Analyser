package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;

import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class Analyser {
    int numberOfEntries;
    public<csvClass>  int loadIndianCensusAndStateCodeData(String csvPath,Class csvClass) throws AnalyserExceptions {
        if (!csvPath.contains(".csv")){
            AnalyserExceptions exceptions=new AnalyserExceptions();
            throw new AnalyserExceptions(exceptions.getMessage(), AnalyserExceptions.ExceptionType.FILE_TYPE_INCORRECT);
        }
        try (Reader reader=Files.newBufferedReader(Paths.get(csvPath))){
            CsvToBeanBuilder<csvClass>  csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass).withIgnoreLeadingWhiteSpace(true);
            CsvToBean<csvClass> csvToBean=csvToBeanBuilder.build();

            Iterator<csvClass> csvClassIterator=csvToBean.iterator();
            Iterable<csvClass> csvClassIterable=()->csvClassIterator;
            numberOfEntries=(int) StreamSupport.stream(csvClassIterable.spliterator(),true).count();
            return numberOfEntries;
        }catch (IOException exception){
            throw new AnalyserExceptions(exception.getMessage(),AnalyserExceptions.ExceptionType.FILE_PROBLEM);
        }catch (RuntimeException exception){
            if(!csvPath.contains("IndianStateCode.csv"))
                throw new AnalyserExceptions(exception.getMessage(), AnalyserExceptions.ExceptionType.INCORRECT_HEADER);
            else
                throw new AnalyserExceptions(exception.getMessage(), AnalyserExceptions.ExceptionType.INCORRECT_DELIMITER);
        }
    }
}