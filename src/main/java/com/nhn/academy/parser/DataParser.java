package com.nhn.academy.parser;

import com.nhn.academy.data.Tariff;

import java.util.List;

public interface DataParser {
    public List<Tariff> parse(String path);
}
