package com.nhn.academy.repository;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.parser.CsvDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TariffRepositoryImpl implements TariffRepository{
    @Autowired
    private CsvDataParser dataParser;
    private List<Tariff> csvData;

    public TariffRepositoryImpl() {
        csvData = new ArrayList<>();
    }

    @Override
    public void csvFileLoad(String path) {
        csvData = dataParser.parse(path);
    }

    @Override
    public List<Tariff> findFeeForUsage(int usage) {
        List<Tariff> tariffList = new ArrayList<>();
        for(Tariff tariff: csvData){
            if (tariff.getStartStage() < usage && usage < tariff.getEndStage()){
                tariffList.add(tariff);
            }
        }
        return tariffList;
    }
}
