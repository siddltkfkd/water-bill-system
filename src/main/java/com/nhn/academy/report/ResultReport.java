package com.nhn.academy.report;

import com.nhn.academy.data.WaterBill;

import java.util.List;

public interface ResultReport {
    public List<WaterBill> report(List<WaterBill> data);
}
