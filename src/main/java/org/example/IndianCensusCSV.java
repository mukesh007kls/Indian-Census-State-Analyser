package org.example;
import com.opencsv.bean.CsvBindByName;
public class IndianCensusCSV {
    @CsvBindByName(column="State",required = true)
    public String state;

    @CsvBindByName(column = "Population",required = true)
    public long population;

    @CsvBindByName(column = "AreaInSqKm",required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm",required = true)
    public int densityPerSqKm;

    @Override
    public String toString() {
        return "IndianCensusCSV{" +
                "state='" + state + '\'' +
                ", population=" + population + '\'' +
                ", areaInSqKm=" + areaInSqKm + '\'' +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }
}
