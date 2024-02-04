package com.nhn.academy.service;

import com.nhn.academy.data.WaterBill;

import java.util.List;

public interface WaterUsageFeeService {
    public List<WaterBill> calc(int usage);
}
