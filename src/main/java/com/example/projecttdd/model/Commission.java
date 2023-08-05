package com.example.projecttdd.model;

public class Commission {

    public Double calculate(Double salesValue) {
        return salesValue > 1000.0 ? salesValue * 0.15 : salesValue * 0.10;
    }

}
