package com.nhn.academy.data;

public class Tariff {
    int no;
    String city;
    String section;
    int stage;
    int startStage;
    int endStage;
    int feeForStage;
    String basicFee;

    public Tariff(int no, String city, String section, int stage, int startStage, int endStage, int feeForStage, String basicFee) {
        this.no = no;
        this.city = city;
        this.section = section;
        this.stage = stage;
        this.startStage = startStage;
        this.endStage = endStage;
        this.feeForStage = feeForStage;
        this.basicFee = basicFee;
    }

    public int getNo() {
        return no;
    }

    public String getCity() {
        return city;
    }

    public String getSection() {
        return section;
    }

    public int getStage() {
        return stage;
    }

    public int getStartStage() {
        return startStage;
    }

    public int getEndStage() {
        return endStage;
    }

    public int getFeeForStage() {
        return feeForStage;
    }

    public String getBasicFee() {
        return basicFee;
    }
}
