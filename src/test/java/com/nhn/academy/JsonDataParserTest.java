package com.nhn.academy;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.parser.JsonDataParser;
import com.nhn.academy.parser.JsonDataParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonDataParserTest {
    String path = "/home/nhnacademy/IdeaProjects/water-bills-system/src/test/resources/Tariff_test.json";
    @Test
    void parse(){
        JsonDataParser jsonDataParser = new JsonDataParserImpl();
        List<Tariff> tariffList = jsonDataParser.parse(path);
        Assertions.assertEquals(10, tariffList.size());
    }
}
