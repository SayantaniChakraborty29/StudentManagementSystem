import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name,int marks) {
        this.id = id;
        this.name =name;
        this.marks=marks;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }


    void display(){
        System.out.println("ID: " + id + "Name:   " + name);
    }   
}
    
public class StudentManagement {
       
    public static void sortStudentsByMarks(ArrayList<Student> students) {

        Collections.sort(students, (s1, s2) -> s2.getMarks() - s1.getMarks());

        System.out.println("Students sorted by marks:");

        for (Student s : students) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getMarks());
        }
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("STUDENT MANAGEMENT SYSTEM");

        System.out.println("=====================================");
         System.out.println("welcome to the Student Management System!");

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            if(students.isEmpty()) {
    System.out.println("No students found!");
} else {
    System.out.println("=== STUDENT LIST ===");

    for(Student s : students) {
        System.out.println("ID: " + s.id + " | Name: " + s.name);
    }

    System.out.println("Total Students: " + students.size());
}
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Total Students");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7.Update Student Name");
            System.out.println("8.Show Topper and Average");
            System.out.println("9.Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                 
             System.out.print("Enter ID: ");
             int id = sc.nextInt();
             sc.nextLine();

             System.out.print("Enter Name: ");
             String name = sc.nextLine();


    if (name.trim().isEmpty()) {
        System.out.println("Name cannot be empty!");
        break;
    }

    System.out.print("Enter Marks: ");
    int marks = sc.nextInt();

    
    if (marks < 0 || marks > 100) {
        System.out.println("Marks must be between 0 and 100!");
        break;
    }

    boolean exists = false;

    for (Student s : students) {
        if (s.id == id) {
            exists = true;
            break;
        }
    }

    if (exists) {
        System.out.println("Student ID already exists!");
        break;
    }

    students.add(new Student(id, name, marks));
    System.out.println("Student Added!");
    break;


                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No Students Found!");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

               case 3:
    sc.nextLine();

    System.out.print("Enter Student Name to Search: ");
    String searchName = sc.nextLine();

    boolean found = false;

    for (Student s : students) {
        if (s.getName().equalsIgnoreCase(searchName)) {
            s.display();
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student Not Found!");
    }
    break;
    
                case 4:
    System.out.print("Enter Student ID to Delete: ");
    int deleteId = sc.nextInt();

    boolean deleted = false;

    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).id == deleteId) {
            students.remove(i);
            deleted = true;
            System.out.println("Student Deleted!");
            break;
        }
    }

    if (!deleted) {
        System.out.println("Student Not Found!");
    }
    break;
 
    case 5:
                System.out.println("Total Students: "+ students.size());
                break;


    case 6:
            sortStudentsByMarks(students);
            break;

    case 7:
            
    System.out.print("Enter Student ID to Update: ");
    int updateId = sc.nextInt();
    sc.nextLine();

    boolean updated = false;

    for(Student s : students) {
        if(s.id == updateId) {

            System.out.print("Enter New Name: ");
            String newName = sc.nextLine();

            s.name = newName;

            System.out.println("Student Updated Successfully!");
            updated = true;
            break;
        }
    }

    if(!updated) {
        System.out.println("Student Not Found!");
    }
    break;

    case 8:
    if (students.isEmpty()) {
        System.out.println("No students available!");
        break;
    }

    int total = 0;
    Student topper = students.get(0);

    for (Student s : students) {
        total += s.marks;
        if (s.marks > topper.marks) {
            topper = s;
        }
    }

    double average = (double) total / students.size();

    System.out.println("Topper: " + topper.name + " (" + topper.marks + ")");
    System.out.println("Average: " + average);
    break;

    case 9:
            System.out.println("Thank You!");
            return;


                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
          
    
 