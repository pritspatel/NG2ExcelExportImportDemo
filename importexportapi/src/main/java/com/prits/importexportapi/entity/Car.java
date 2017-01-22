package com.prits.importexportapi.entity;

/**
 * Created by 3ppat on 1/22/2017.
 */
public class Car {

    private String vin;
    private Integer year;
    private String brand;
    private String color;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
