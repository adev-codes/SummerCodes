import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement{
    public static int totalStudents;
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("======Student Management System======");
         int numberOfStudents;
        // Ensure user enters at least 2 students
        do {
            System.out.print("Enter the number of students (minimum 2): ");
            numberOfStudents = input.nextInt();
            input.nextLine();
            if (numberOfStudents < 2) {
                System.out.println("You must enter at least 2 students.");
            }
        } while (numberOfStudents < 2);

        // Loop to add students
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Enter name of student " + i + ": ");
            String name = input.nextLine();
            System.out.print("Enter marks of student " + i + ": ");
            double marks = input.nextDouble();
            input.nextLine();

            Student s = new Student(name, marks);
            students.add(s);
            System.out.println("Student added successfully!\n");
        }
    System.out.println("-----Declaration of Result-----");
    findTopper(students);
    
}

    public static void findTopper(ArrayList<Student> s){
        double maxMarks = s.get(0).getMarks();
        for(Student s1:s){
            if(s1.getMarks() > maxMarks){
                maxMarks = s1.getMarks();
            }
        }
        for(Student s1: s){
            if(s1.getMarks() == maxMarks){
                System.out.println(s1.getName()+" is the topper of the class with "+s1.getMarks()+" marks.");
            }
        }
    }
}

class Student{
    private String name;
    private double marks;
    //Constructor
    public Student(String n,double m){
        this.name = n;
        this.marks = m;
        StudentManagement.totalStudents++;
    }

    //Getters
    public String getName(){
        return name;
    }
    public double getMarks(){
        return marks;
    }

    //Setters
    public void setName(String n){
        this.name = n;
    }
    public void setMarks(double m){
        this.marks = m;
    }

}


