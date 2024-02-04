package com.nhn.academy.data;

public class Tariff {
    int no;
    String city;
    String sector;
    int step;
    int startSection;
    int endSection;
    int sectionAmount;
    String BasicFeeByStage;

    public Tariff(int no, String city, String sector, int step, int startSection, int endSection, int sectionAmount, String basicFeeByStage) {
        this.no = no;
        this.city = city;
        this.sector = sector;
        this.step = step;
        this.startSection = startSection;
        this.endSection = endSection;
        this.sectionAmount = sectionAmount;
        BasicFeeByStage = basicFeeByStage;
    }

    public int getNo() {
        return no;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getStep() {
        return step;
    }

    public int getStartSection() {
        return startSection;
    }

    public int getEndSection() {
        return endSection;
    }

    public int getSectionAmount() {
        return sectionAmount;
    }

    public String getBasicFeeByStage() {
        return BasicFeeByStage;
    }
}
