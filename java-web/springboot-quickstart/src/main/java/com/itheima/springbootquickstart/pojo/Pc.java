package com.itheima.springbootquickstart.pojo;

public class Pc {
    private String brand;
    private String color;

    public Pc() {
    }

    public Pc(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Pc{brand = " + brand + ", color = " + color + "}";
    }
}
