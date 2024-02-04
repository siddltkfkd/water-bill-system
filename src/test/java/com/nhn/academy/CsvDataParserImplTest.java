package com.nhn.academy;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.parser.CsvDataParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CsvDataParserImplTest {
    String path = "/home/nhnacademy/IdeaProjects/water-bills-system/src/test/resources/Tariff_test.csv";
    CsvDataParserImpl csvDataParserImpl;

    @BeforeEach
    void setUp(){
        csvDataParserImpl = new CsvDataParserImpl();
    }
    @Test
    void parse(){
        List<Tariff> tariffList = csvDataParserImpl.parse(path);
        Assertions.assertEquals(8, csvDataParserImpl.getHeader().size());
        Assertions.assertEquals(10, tariffList.size());
    }

    @Test
    void exception(){
        Assertions.assertThrows(RuntimeException.class, ()->{List<Tariff> test = csvDataParserImpl.parse("");});
    }
}
