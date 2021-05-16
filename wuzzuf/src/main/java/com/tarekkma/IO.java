package com.tarekkma;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IO {
    private final CsvMapper mapper = new CsvMapper();
    private final CsvSchema schema = mapper
            .schemaFor(JobDetails.class)
            .withHeader();


    public List<JobDetails> ReadCSVFile(String filename) throws IOException {
        File csvFile = new File(filename);

        MappingIterator<JobDetails> jobs = mapper
                .readerFor(JobDetails.class)
                .with(schema)
                .readValues(csvFile);

        return jobs.readAll();
    }
}
