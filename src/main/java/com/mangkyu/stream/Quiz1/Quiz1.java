package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Quiz1 {

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .flatMap(line -> Arrays.stream(line[1].split(":")))
                .map(String::trim)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .filter(line -> line[0].startsWith("정"))
                .flatMap(line -> Arrays.stream(line[1].split(":")))
                .map(String::trim)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream().map(line -> countJoa(line[2])).reduce(Integer::sum).get();
    }

    private int countJoa(String s) {
        int result = 0;
        int start = 0;
        while (true) {
            int getJoa = s.indexOf("좋아", start);
            if (getJoa != -1) {
                result++;
                start = getJoa + 2;
            } else {
                break;
            }
        }
        return result;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
