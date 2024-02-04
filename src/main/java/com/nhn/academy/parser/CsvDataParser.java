package com.nhn.academy.parser;

import com.nhn.academy.data.WaterBill;

import java.util.List;

public interface CsvDataParser {
    public List<WaterBill> parse(String path);
}
