import java.time.LocalDate;
import java.util.*;

public class q5 {

    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int getDays();
    }

    static class Basic extends Plan {
        Basic(String name, LocalDate date) {
            super(name, date);
        }

        int getDays() {
            return 30;
        }
    }

    static class Standard extends Plan {
        Standard(String name, LocalDate date) {
            super(name, date);
        }

        int getDays() {
            return 90;
        }
    }

    static class Premium extends Plan {
        Premium(String name, LocalDate date) {
            super(name, date);
        }

        int getDays() {
            return 365;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(name, date);
            else if (type.equals("STANDARD"))
                p = new Standard(name, date);
            else
                p = new Premium(name, date);

            LocalDate renewalDate = p.startDate.plusDays(p.getDays());

            System.out.println(p.name + ": " + renewalDate);
        }
    }
}