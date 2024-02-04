package com.nhn.academy.repository;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.parser.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TariffRepositoryImpl implements TariffRepository{
    @Autowired
    @Qualifier("jsonDataParser")
    private DataParser dataParser;
    private List<Tariff> data;

    public TariffRepositoryImpl() {
        data = new ArrayList<>();
    }

    @Override
    public void fileLoad(String path) {
        data = dataParser.parse(path);
    }

    @Override
    public List<Tariff> findFeeForUsage(int usage) {
        List<Tariff> tariffList = new ArrayList<>();
        for(Tariff tariff: data){
            if (tariff.getStartStage() < usage && usage < tariff.getEndStage()){
                tariffList.add(tariff);
            }
        }
        return tariffList;
    }
}
