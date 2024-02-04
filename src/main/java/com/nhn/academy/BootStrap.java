package com.nhn.academy;

import com.nhn.academy.config.JavaConfig;
import com.nhn.academy.data.WaterBill;
import com.nhn.academy.report.ResultReport;
import com.nhn.academy.repository.TariffRepository;
import com.nhn.academy.service.WaterUsageFeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BootStrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        TariffRepository tariffRepository = context.getBean("tariffRepositoryImpl", TariffRepository.class);
        WaterUsageFeeService waterUsageFeeService = context.getBean("waterUsageFeeServiceImpl", WaterUsageFeeService.class);
        ResultReport resultReport = context.getBean("resultReportImpl", ResultReport.class);

        tariffRepository.fileLoad("/home/nhnacademy/IdeaProjects/water-bills-system/src/main/resources/Tariff_20220331.json");
        List<WaterBill> result = resultReport.report(waterUsageFeeService.calc(3000));
        result.stream().forEach(System.out::println);
    }
}
