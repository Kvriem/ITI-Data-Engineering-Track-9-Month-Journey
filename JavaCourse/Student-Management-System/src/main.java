import java.util.ArrayList;
public class main {

        public static void main(String[] args) {
            ArrayList<student> students = new ArrayList<>();

            students.add(new student("Kariem Abd-Elmoniem", 20, "Computer Science", "1", 3.8));
            students.add(new student("Adely Mansour", 22, "Information Technology", "2", 3.5));
            students.add(new student("Mobark", 21, "Software Engineering", "3", 3.9));
            students.add(new student("Bashar", 19, "Cybersecurity", "4", 3.6));
            students.add(new student("Rayan Cherki", 23, "Data Science", "5", 3.7));

            for (int i = 0; i < students.size(); i++) {
                System.out.println("\nstudent #" + (i + 1) + ":");
                students.get(i).printstudentInfo();
            }


    }
}
