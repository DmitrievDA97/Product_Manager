package ru.netology.domain;

public class Phone extends Product{
    private String manufacturer;

    public Phone(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Phone() {
        super();
    }

    public Phone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
