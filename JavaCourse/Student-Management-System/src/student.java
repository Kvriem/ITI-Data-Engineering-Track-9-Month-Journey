public class student {

    private String name;
    private int age;
    private String track;
    private String studentId;
    private double gpa;


    public student(String name, int age, String track, String studentId, double gpa) {
        this.name = name;
        this.age = age;
        this.track = track;
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public void printstudentInfo() {
        System.out.println("=== student Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Track: " + track);
        System.out.println("student ID: " + studentId);
        System.out.println("GPA: " + gpa);
        System.out.println("===========================");
    }


}