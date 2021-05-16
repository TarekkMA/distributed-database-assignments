package com.tarekkma;

import java.util.*;

public class JobsDataService {

    public static final int LIMIT = 5;
    public static final int HEADER_LENGTH = 35;

    public void FilterJobsByTitle(List<JobDetails> jobs) {
        printHeader("FilterJobsByTitle");
        buildFrequencyMap(jobs, JobDetails::getTitle);
    }

    public void FilterJobsByCountry(List<JobDetails> jobs) {
        printHeader("FilterJobsByCountry");
        buildFrequencyMap(jobs, JobDetails::getCountry);
    }

    public void FilterJobsByLevel(List<JobDetails> jobs) {
        printHeader("FilterJobsByLevel");
        buildFrequencyMap(jobs, JobDetails::getLevel);
    }

    public void FilterJobsByYearsExp(List<JobDetails> jobs) {
        printHeader("FilterJobsByYearsExp");
        buildFrequencyMap(jobs, JobDetails::getYearsOfExperience);
    }

    private LinkedHashMap<String, Long> sortMap(Map<String, Long> map) {
        List<Map.Entry<String, Long>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        LinkedHashMap<String, Long> orderedMap = new LinkedHashMap<>(map.size());
        for (Map.Entry<String, Long> entry : entryList) {
            orderedMap.put(entry.getKey(), entry.getValue());
        }
        return orderedMap;
    }

    private void printHeader(String header) {
        System.out.print("+");
        for (int i = 0; i < HEADER_LENGTH-2; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        int spaces = HEADER_LENGTH - header.length() - 2;
        int spaceBefore = spaces / 2;
        int spaceAfter = spaces - spaceBefore;
        System.out.print("|");
        for (int i = 0; i < spaceBefore; i++) {
            System.out.print(" ");
        }
        System.out.print(header);
        for (int i = 0; i < spaceAfter; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("+");
        for (int i = 0; i < HEADER_LENGTH-2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    private interface AtterSupplier<O, R> {
        R getAtter(O from);
    }

    private <T> void buildFrequencyMap(List<T> list, AtterSupplier<T, String> atterSupplier) {
        Map<String, Long> map = new HashMap<>();
        for (T item : list) {
            String key = atterSupplier.getAtter(item);
            Long value = map.getOrDefault(key, 1L);
            map.put(key, value + 1);
        }
        LinkedHashMap<String, Long> sorted = sortMap(map);
        sorted.entrySet()
                .stream()
                .limit(LIMIT)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
