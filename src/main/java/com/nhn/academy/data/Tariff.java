package com.nhn.academy.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tariff {
    @JsonProperty("순번")
    int no;
    @JsonProperty("지자체명")
    String city;
    @JsonProperty("업종")
    String section;
    @JsonProperty("단계")
    int stage;
    @JsonProperty("구간시작(세제곱미터)")
    int startStage;
    @JsonProperty("구간끝(세제곱미터)")
    int endStage;
    @JsonProperty("구간금액(원)")
    int feeForStage;
    @JsonProperty("단계별 기본요금(원)")
    String basicFee;

    public Tariff() {
    }

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

    @Override
    public String toString() {
        return "Tariff{" +
                "no=" + no +
                ", city='" + city + '\'' +
                ", section='" + section + '\'' +
                ", stage=" + stage +
                ", startStage=" + startStage +
                ", endStage=" + endStage +
                ", feeForStage=" + feeForStage +
                ", basicFee='" + basicFee + '\'' +
                '}';
    }
}
