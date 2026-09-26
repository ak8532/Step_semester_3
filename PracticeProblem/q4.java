import java.util.*;

public class q4 {

    static abstract class Question {
        String correct;
        String student;
        double points;

        Question(String correct, String student, double points) {
            this.correct = correct;
            this.student = student;
            this.points = points;
        }

        abstract double score();
        abstract String type();
    }

    static class MCQ extends Question {
        MCQ(String c, String s, double p) {
            super(c, s, p);
        }

        double score() {
            return student.equals(correct) ? points : 0;
        }

        String type() {
            return "MCQ";
        }
    }

    static class TF extends Question {
        TF(String c, String s, double p) {
            super(c, s, p);
        }

        double score() {
            return student.equals(correct) ? points : 0;
        }

        String type() {
            return "TF";
        }
    }

    static class Essay extends Question {
        Essay(String c, String s, double p) {
            super(c, s, p);
        }

        double score() {
            String[] keywords = correct.split(",");
            int found = 0;

            for (String key : keywords) {
                if (student.toLowerCase().contains(key.trim().toLowerCase()))
                    found++;
            }

            if (found >= 2)
                return points * 0.75;
            if (found == 1)
                return points * 0.50;

            return 0;
        }

        String type() {
            return "ESSAY";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String correct = parts[2];
            String student = parts[4];
            double points = Double.parseDouble(parts[5].trim());

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(correct, student, points);
            else if (type.equals("TF"))
                q = new TF(correct, student, points);
            else
                q = new Essay(correct, student, points);

            double score = q.score();

            System.out.printf("%s: %.2f%n", q.type(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}