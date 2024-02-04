package com.nhn.academy.repository;

public interface TariffRepository {
    public void csvFileLoad(String path);
    public void findFeeForUsage(int usage);
}
