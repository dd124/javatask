package com.damyan.pojo;

public class Item {

    private String name;
    private Warmth warmth;
    private Type type;
    private Double price;

    public Item(String name, Warmth warmth, Type type, Double price) {
        this.name = name;
        this.warmth = warmth;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warmth getWarmth() {
        return warmth;
    }

    public void setWarmth(Warmth warmth) {
        this.warmth = warmth;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
