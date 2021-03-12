package com.company.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CsvReader {

    public List<County> getCounty() {   //read from csv file

        try {
            Reader in = new FileReader("src/main/java/com/company/data/county.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withDelimiter(';')
                    .withHeader()
                    .parse(in);
            return StreamSupport.stream(records.spliterator(), false)
                    .map(r -> new County(
                            Integer.parseInt(r.get("id")), r.get("name")))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}