package com.example.projecttdd.model;

public class Product {
    
    private Long id;

    private String name;

    private Integer amount;

    private Double discount;

    private Double additional;

    private Double value;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getAdditional() {
        return additional;
    }

    public void setAdditional(Double additional) {
        this.additional = additional;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double calculateTotalValue() {
        return (amount * value) + additional - discount;
    }
    
}
