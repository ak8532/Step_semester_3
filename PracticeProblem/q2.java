public class q2 {

    static class Scorecard {
        private boolean[] answers;
        private int count;
        private int score;

        Scorecard(int questions) {
            answers = new boolean[questions];
            count = 0;
            score = 0;
        }

        void recordAnswer(boolean correct) {
            if (count < answers.length) {
                answers[count] = correct;

                if (correct)
                    score++;

                count++;
            }
        }

        int getScore() {
            return score;
        }
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}