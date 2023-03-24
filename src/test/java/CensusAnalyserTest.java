import org.example.Analyser;
import org.example.AnalyserExceptions;
import org.example.IndianCensusCSV;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("ALL")
public class CensusAnalyserTest {
    private  static final String CSV_PATH="D:\\BridgeLabzz\\IndianStateCensusAnalyser\\src\\main\\resources\\IndianCensusData.csv";
    private  static final String CSV_PATH_INCORRECT="D:\\IndianStateCensusAnalyser\\src\\main\\resources\\IndianCensusData.csv";
    private  static final String CSV_FILE_TYPE_INCORRECT="D:\\BridgeLabzz\\IndianStateCensusAnalyser\\src\\main\\resources\\IndianCensusData.txt";
    private  static final String CSV_PATH_DELIMITER="D:\\BridgeLabzz\\IndianStateCensusAnalyser\\src\\main//resources\\IndianCensusData.csv";
    private  static final String CSV_PATH_HEADER="D:\\BridgeLabzz\\IndianStateCensusAnalyser\\src\\main\\resources\\IndianCensusDataHeader.csv";


    @Test
    public void givenIndianCensusCsvFileReturnsCorrectRecordsCount(){
        Analyser censusAnalyser=new Analyser();
        try {
            int numberOFEntries=censusAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH, IndianCensusCSV.class);
            Assert.assertEquals(29,numberOFEntries);
        }catch (AnalyserExceptions exceptions){
            exceptions.printStackTrace();
        }
    }

    @Test
    public void given_Indian_Census_CsvFile_Path_Incorrect_Should_Throw_Exception(){
        try {
            Analyser censusAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            censusAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH_INCORRECT,IndianCensusCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.FILE_PROBLEM,exceptions.type);
        }
    }

    @Test
    public void given_Indian_Census_CsvFile_WithWrong_FileType_Should_ThrowException(){
        try {
            Analyser censusAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            censusAnalyser.loadIndianCensusAndStateCodeData(CSV_FILE_TYPE_INCORRECT,IndianCensusCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.FILE_TYPE_INCORRECT,exceptions.type);
        }
    }

    @Test
    public void given_Indian_Census_CsvFile_WithWrong_Delimiter_Should_ThrowException(){
        try {
            Analyser censusAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            censusAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH_DELIMITER,IndianCensusCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.INCORRECT_DELIMITER,exceptions.type);
        }
    }

    @Test
    public void given_Indian_Census_CsvFile_WithWrong_Head_Should_ThrowException(){
        try {
            Analyser censusAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            censusAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH_HEADER,IndianCensusCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.INCORRECT_HEADER,exceptions.type);
        }
    }
}