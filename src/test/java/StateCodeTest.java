import org.example.Analyser;
import org.example.AnalyserExceptions;
import org.example.IndianStateCodeCSV;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("ALL")
public class StateCodeTest {
    private  static final String CSV_PATH="D:\\BridgeLabzz\\IndianStatestateAnalyser\\src\\main\\resources\\IndianStateCode.csv";
    private  static final String CSV_PATH_INCORRECT="D:\\IndianStatestateAnalyser\\src\\main\\resources\\IndianStateCode.csv";
    private  static final String CSV_FILE_TYPE_INCORRECT="D:\\BridgeLabzz\\IndianStatestateAnalyser\\src\\main\\resources\\IndianStateCode.txt";
    private  static final String CSV_PATH_DELIMITER="D:\\BridgeLabzz\\IndianStatestateAnalyser\\src\\main//resources\\IndianStateCode.csv";
    private  static final String CSV_PATH_HEADER="D:\\BridgeLabzz\\IndianStatestateAnalyser\\src\\main\\resources\\IndianStateCodeHeader.csv";


    @Test
    public void givenIndianStateCodeCsvFileReturnsCorrectRecordsCount(){
        Analyser stateAnalyser=new Analyser();
        try {
            int numberOFEntries=stateAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH, IndianStateCodeCSV.class);
            Assert.assertEquals(37,numberOFEntries);
        }catch (AnalyserExceptions exceptions){
            System.out.println(exceptions.getMessage());
        }
    }
    @Test
    public void given_Indian_StateCode_CsvFile_Path_Incorrect_Should_Throw_Exception(){
        try {
            Analyser stateAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            stateAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH_INCORRECT,IndianStateCodeCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.FILE_PROBLEM,exceptions.type);
        }
    }

    @Test
    public void given_Indian_StateCode_CsvFile_WithWrong_FileType_Should_ThrowException(){
        try {
            Analyser stateAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            stateAnalyser.loadIndianCensusAndStateCodeData(CSV_FILE_TYPE_INCORRECT,IndianStateCodeCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.FILE_TYPE_INCORRECT,exceptions.type);
        }
    }

    @Test
    public void given_Indian_StateCode_CsvFile_WithWrong_Delimiter_Should_ThrowException(){
        try {
            Analyser stateAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            stateAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH_DELIMITER,IndianStateCodeCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.INCORRECT_DELIMITER,exceptions.type);
        }
    }

    @Test
    public void given_Indian_StateCode_CsvFile_WithWrong_Head_Should_ThrowException(){
        try {
            Analyser stateAnalyser=new Analyser();
            ExpectedException exception=ExpectedException.none();
            exception.expect(AnalyserExceptions.class);
            stateAnalyser.loadIndianCensusAndStateCodeData(CSV_PATH_HEADER,IndianStateCodeCSV.class);
        }catch (AnalyserExceptions exceptions){
            Assert.assertEquals(AnalyserExceptions.ExceptionType.INCORRECT_HEADER,exceptions.type);
        }
    }
}
