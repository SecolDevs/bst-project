package model;

import java.util.Comparator;

public class Vehicle {
    private String plate, brand, model, color;

    public static final Comparator<Vehicle> compPlate = ( ((o1, o2) -> (o1.getPlate().compareTo(o2.getPlate()))) );

    public Vehicle() {
    }

    public Vehicle(String plate, String brand, String model, String color) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
