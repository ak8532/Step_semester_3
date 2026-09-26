import java.util.*;

public class q1 {

    static abstract class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double finalAmount();

        String type() {
            return getClass().getSimpleName();
        }
    }

    static class Card extends Payment {
        Card(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 1.02;
        }

        String type() {
            return "CARD";
        }
    }

    static class Wallet extends Payment {
        Wallet(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 1.01;
        }

        String type() {
            return "WALLET";
        }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount;
        }

        String type() {
            return "BANKTRANSFER";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment p;

            if (type.equals("CARD"))
                p = new Card(amount);
            else if (type.equals("WALLET"))
                p = new Wallet(amount);
            else
                p = new BankTransfer(amount);

            double result = p.finalAmount();

            System.out.printf("%s: %.2f%n", p.type(), result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}