package Session10;

class Vehicle {
    protected String type;
    public Vehicle(String type) {
        this.type = type;
    }

    protected String getType() {
        return type;
    }
}

public class ProtectedDemo {
    static class Car extends Vehicle {
        public Car(String type) {
            super(type);
        }

        public void displayType() {
            System.out.println("Type of vehicle: " + getType());
        }
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota");
        car.displayType();
    }
}