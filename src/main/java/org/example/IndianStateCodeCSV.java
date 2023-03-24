package org.example;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCodeCSV {
    @CsvBindByName(column = "SrNo",required = true)
    private String srNo;

    @CsvBindByName(column = "State Name",required = true)
    private String stateName;

    @CsvBindByName(column = "TIN",required = true)
    private int tin;

    @CsvBindByName(column = "StateCode",required = true)
    private String stateCode;
}
