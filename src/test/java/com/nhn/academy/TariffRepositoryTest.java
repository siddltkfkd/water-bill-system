package com.nhn.academy;

import com.nhn.academy.data.Tariff;
import com.nhn.academy.parser.DataParser;
import com.nhn.academy.repository.TariffRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TariffRepositoryTest {
    @Mock
    private DataParser dataParser;
    @InjectMocks
    private TariffRepositoryImpl tariffRepository;
    private String path = "/home/nhnacademy/IdeaProjects/water-bills-system/src/test/resources/Tariff_test.csv";
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void csvFileLoad(){
        tariffRepository.fileLoad(path);
        verify(dataParser, times(1)).parse(any());
    }
    @Test
    void findFeeForUsage(){
        List<Tariff> tariffList = new ArrayList<>();
        tariffList.add(new Tariff(215,"고령군","공업용",1,1,200,230,""));
        tariffRepository.findFeeForUsage(10);
        Assertions.assertEquals(1, tariffList.size());

        tariffList = new ArrayList<>();
        tariffRepository.findFeeForUsage(1000);
        Assertions.assertEquals(0, tariffList.size());

        tariffList = new ArrayList<>();
        tariffRepository.findFeeForUsage(0);
        Assertions.assertEquals(0, tariffList.size());


    }
}
