package com.nhn.academy.report;

import com.nhn.academy.data.WaterBill;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultReportImpl implements ResultReport{
    @Override
    public List<WaterBill> report(List<WaterBill> data) {
        return data.stream().sorted(Comparator.comparing(d->d.getBillTotal()))
                .limit(5).collect(Collectors.toList());
    }
}
