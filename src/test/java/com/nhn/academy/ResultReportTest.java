package com.nhn.academy;

import com.nhn.academy.data.WaterBill;
import com.nhn.academy.report.ResultReport;
import com.nhn.academy.report.ResultReportImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultReportTest {
    List<WaterBill> data;
    List<WaterBill> expected;
    @BeforeEach
    void setData(){
        data = new ArrayList<>();
        data.add(new WaterBill("city", "sector", 370, 3700000));
        data.add(new WaterBill("city", "sector", 370, 37000));
        data.add(new WaterBill("city", "sector", 370, 370001));
        data.add(new WaterBill("city", "sector", 370, 370010));
        data.add(new WaterBill("city", "sector", 370, 370100));
        data.add(new WaterBill("city", "sector", 370, 371000));
        data.add(new WaterBill("city", "sector", 370, 370002));
        data.add(new WaterBill("city", "sector", 370, 370020));
        data.add(new WaterBill("city", "sector", 370, 370020));
        data.add(new WaterBill("city", "sector", 370, 370200));

        expected = new ArrayList<>();
        expected.add(new WaterBill("city", "sector", 370, 37000));
        expected.add(new WaterBill("city", "sector", 370, 370001));
        expected.add(new WaterBill("city", "sector", 370, 370002));
        expected.add(new WaterBill("city", "sector", 370, 370010));
        expected.add(new WaterBill("city", "sector", 370, 370020));

    }

    @Test
    void report(){
        ResultReport resultReport = new ResultReportImpl();
        List<WaterBill> result = resultReport.report(data);
        Assertions.assertEquals(5, result.size());
        for(int i=0; i<5; i++){
            Assertions.assertEquals(expected.get(i).getBillTotal(), result.get(i).getBillTotal());
        }
    }
}
