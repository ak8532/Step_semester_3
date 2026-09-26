import java.util.*;

public class q2 {

    static abstract class Vehicle {
        int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double getCharge();

        abstract String getType();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        double getCharge() {
            return hours * 10;
        }

        String getType() {
            return "BIKE";
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        double getCharge() {
            return 30 + (hours - 1) * 20;
        }

        String getType() {
            return "CAR";
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        double getCharge() {
            return Math.max(hours * 50, 100);
        }

        String getType() {
            return "TRUCK";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle v;

            if (type.equals("BIKE"))
                v = new Bike(hours);
            else if (type.equals("CAR"))
                v = new Car(hours);
            else
                v = new Truck(hours);

            double charge = v.getCharge();

            System.out.printf("%s: %.2f%n", v.getType(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}