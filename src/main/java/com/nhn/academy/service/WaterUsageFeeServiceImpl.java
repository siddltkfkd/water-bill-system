package com.nhn.academy.service;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.data.WaterBill;
import com.nhn.academy.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WaterUsageFeeServiceImpl implements WaterUsageFeeService{
    @Autowired
    private TariffRepository tariffRepository;

    public WaterUsageFeeServiceImpl() {
    }

    @Override
    public List<WaterBill> calc(int usage) {
        List<WaterBill> waterBillList = new ArrayList<>();
        for(Tariff tariff:tariffRepository.findFeeForUsage(usage)){
            waterBillList.add(new WaterBill(tariff.getCity(), tariff.getSection(), tariff.getFeeForStage(), tariff.getFeeForStage() * usage));
        }
        return waterBillList;
    }
}