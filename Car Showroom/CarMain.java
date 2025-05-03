import java.util.ArrayList;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean availability;

    Car(String brand, String model, int year, double price, boolean availibility) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.availability = availibility;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean newAvailability) {
        availability = newAvailability;
    }

    public String toString() {
        return "Brand : " + brand + "\nModel : " + model + "\nYear : " + year + "\nPrice : " + price
                + "\nAvailability : " + availability + "\n";
    }

}

class Showroom {
    List<Car> inventory = new ArrayList<>();

    public void addNewCar(Car newCar) {
        inventory.add(newCar);
    }

    public void findCar(Car car) {
        for (Car c : inventory) {
            if (c.getModel().equals(car.getModel())) {
                System.out.println(car);
            }
        }
        System.out.println("Car not found in showroom");
    }

    public void updateAvailability(String carModel, boolean newAvailability) {
        for (Car c : inventory) {
            if (c.getModel().equalsIgnoreCase(carModel)) {
                c.setAvailability(newAvailability);
                System.out.println("Availability udpated for model");
            }
        }
        System.out.println("Car model not found in inventory.");
    }

    public void showInventory() {
        for (Car c : inventory) {
            System.out.println(c);
        }
    }
}

public class CarMain {
    public static void main(String[] args) {
        Showroom surajPole = new Showroom();
        Car fortuner = new Car("Toyota", "Fortuner", 2025, 4500000, true);
        surajPole.addNewCar(fortuner);
        surajPole.showInventory();
        surajPole.updateAvailability("fortuner", false);
        surajPole.showInventory();
    }
}
