package org.example;

public class AnalyserExceptions extends RuntimeException {
    public enum ExceptionType{
        FILE_PROBLEM, FILE_TYPE_INCORRECT, INCORRECT_DELIMITER, INCORRECT_HEADER;
    }
    public ExceptionType type;
    public AnalyserExceptions(String message, ExceptionType type){
        super(message);
        this.type=type;
    }
    public AnalyserExceptions(){
    }
}
