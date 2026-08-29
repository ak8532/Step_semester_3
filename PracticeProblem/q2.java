public class q2 {

    static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length == 3) {

            System.out.println("Name: " + fields[0]
                    + " | Roll No: " + fields[1]
                    + " | Dept: " + fields[2]);

        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {

        String csvLine = "Ananya Verma,RA2211003010123,CSE";

        parseStudentRecord(csvLine);
    }
}