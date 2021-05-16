package com.tarekkma;

import java.io.IOException;
import java.util.List;

public class TestWuzzufJobs {
    public final IO io;
    public final JobsDataService jobsDataService;

    public TestWuzzufJobs(IO io, JobsDataService jobsDataService) {
        this.io = io;
        this.jobsDataService = jobsDataService;
    }

    public void test() throws IOException {
        List<JobDetails> jobs = io.ReadCSVFile("./Wuzzuf_Jobs.csv");
        jobsDataService.FilterJobsByCountry(jobs);
        jobsDataService.FilterJobsByLevel(jobs);
        jobsDataService.FilterJobsByTitle(jobs);
        jobsDataService.FilterJobsByYearsExp(jobs);
    }
}
