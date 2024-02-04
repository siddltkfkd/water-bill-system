package com.nhn.academy.repository;

import com.nhn.academy.data.WaterBill;
import com.nhn.academy.parser.CsvDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TariffRepositoryImpl implements TariffRepository{
    @Autowired
    CsvDataParser dataParser;
    List<WaterBill> waterBillList;

    public TariffRepositoryImpl() {
        waterBillList = new ArrayList<>();
    }

    @Override
    public void csvFileLoad(String path) {
        waterBillList = dataParser.parse(path);
    }

    @Override
    public void findFeeForUsage(int usage) {
        for(WaterBill waterBill:waterBillList){
            waterBill.setBillTotal(waterBill.getUnitPrice() * usage);
        }
    }
}
