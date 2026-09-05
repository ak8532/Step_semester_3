import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    // CGPA-only eligibility
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // CGPA + Coding Score eligibility
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Composite score
    double score() {
        return cgpa * 10 + codingScore / 2.0;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.score(), this.score());
    }
}

public class Problem5 {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] list = new Candidate[candidates.length];
        int count = 0;

        // Shortlist eligible candidates
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) ||
                Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {

                list[count++] = c;
            }
        }

        // Resize array
        list = Arrays.copyOf(list, count);

        // Sort candidates
        Arrays.sort(list);

        String result = "";

        for (int i = 0; i < list.length; i++) {
            result += (i + 1) + ". " + list[i].getName()
                    + " (" + list[i].score() + ")";

            if (i < list.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}