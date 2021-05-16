package com.tarekkma;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IO io = new IO();
        JobsDataService jobsDataService = new JobsDataService();
        TestWuzzufJobs wuzzufJobsTest = new TestWuzzufJobs(io, jobsDataService);
        wuzzufJobsTest.test();
    }

}
