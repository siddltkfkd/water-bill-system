package com.nhn.academy;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.parser.CsvDataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CsvDataParserTest {
    String path = "/home/nhnacademy/IdeaProjects/water-bills-system/src/test/resources/Tariff_test.csv";
    CsvDataParser csvCsvDataParser;

    @BeforeEach
    void setUp(){
        csvCsvDataParser = new CsvDataParser();
    }
    @Test
    void parse(){
        List<Tariff> tariffList = csvCsvDataParser.parse(path);
        Assertions.assertEquals(8, csvCsvDataParser.getHeader().size());
        Assertions.assertEquals(10, tariffList.size());
    }

    @Test
    void exception(){
        Assertions.assertThrows(RuntimeException.class, ()->{List<Tariff> test = csvCsvDataParser.parse("");});
    }
}
