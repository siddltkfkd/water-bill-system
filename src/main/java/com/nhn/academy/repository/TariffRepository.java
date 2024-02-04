package com.nhn.academy.repository;

import com.nhn.academy.data.Tariff;

import java.util.List;

public interface TariffRepository {
    public void csvFileLoad(String path);
    public List<Tariff> findFeeForUsage(int usage);
}
