package com.nhn.academy;

import com.nhn.academy.data.WaterBill;
import com.nhn.academy.parser.DataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataParserTest {
    String path = "/home/nhnacademy/IdeaProjects/water-bills-system/src/test/resources/Tariff_test.csv";
    DataParser dataParser;

    @BeforeEach
    void setUp(){
        dataParser = new DataParser();
    }
    @Test
    void parse(){
        List<WaterBill> tariffList = dataParser.parse(path);
        Assertions.assertEquals(8, dataParser.getHeader().size());
        Assertions.assertEquals(10, tariffList.size());
    }

    @Test
    void exception(){
        Assertions.assertThrows(RuntimeException.class, ()->{List<WaterBill> test = dataParser.parse("");});
    }
}
