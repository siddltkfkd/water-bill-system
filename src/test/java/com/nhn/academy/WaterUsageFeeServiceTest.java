package com.nhn.academy;

import com.nhn.academy.repository.TariffRepository;
import com.nhn.academy.service.WaterUsageFeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WaterUsageFeeServiceTest {
    @Mock
    private TariffRepository tariffRepository;
    @InjectMocks
    private WaterUsageFeeServiceImpl waterUsageFeeService;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void calc(){
        waterUsageFeeService.calc(1000);
        verify(tariffRepository, times(1)).findFeeForUsage(1000);
        verify(tariffRepository, times(0)).findFeeForUsage(1);
    }
}
