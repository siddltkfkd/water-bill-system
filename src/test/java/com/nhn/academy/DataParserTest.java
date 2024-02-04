package com.nhn.academy;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.parser.DataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
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
        List<Tariff> tariffList = dataParser.parse(path);
        Assertions.assertEquals(8, dataParser.getHeader().size());
        Assertions.assertEquals(10, tariffList.size());
    }
}
