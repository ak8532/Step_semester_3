public class Problem2 {

    static void findDuplicateTeam(String[] teamNames) {

        for (int i = 0; i < teamNames.length; i++) {

            for (int j = i + 1; j < teamNames.length; j++) {

                if (teamNames[i].equals(teamNames[j])) {
                    System.out.println("Duplicate Found: " + teamNames[i]);
                    return;
                }
            }
        }

        System.out.println("No Duplicates Found");
    }

    public static void main(String[] args) {

        String[] teams = {"ByteForce", "CodeCrafters", "ByteForce"};

        findDuplicateTeam(teams);
    }
}