package com.nhn.academy.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhn.academy.data.Tariff;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonDataParser implements DataParser{
    @Override
    public List<Tariff> parse(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(file, Tariff[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
