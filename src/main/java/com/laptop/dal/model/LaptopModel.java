package com.laptop.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "laptops")
public class LaptopModel {

    @Id
    private String id;
    private String name;
    private String code;
    private int availableUnit;
    private double price;
    private double taxPrice;
    private String productDescription;
    private String imagePath;
    private String type;
    private LocalDateTime datetime;

    public LaptopModel() {
    }

    public LaptopModel(String id, String name, String code, int availableUnit, double price, double taxPrice, String productDescription, String imagePath, String type, LocalDateTime datetime) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.availableUnit = availableUnit;
        this.price = price;
        this.taxPrice = taxPrice;
        this.productDescription = productDescription;
        this.imagePath = imagePath;
        this.type = type;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Laptop Model{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", availableUnit=" + availableUnit +
                ", price=" + price +
                ", taxPrice=" + taxPrice +
                ", productDescription='" + productDescription + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", type='" + type + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAvailableUnit() {
        return availableUnit;
    }

    public void setAvailableUnit(int availableUnit) {
        this.availableUnit = availableUnit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(double taxPrice) {
        this.taxPrice = taxPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}
