import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name =name;
    }

    void display(){
        System.out.println("ID: " + id + "Name:   " + name);
    }
    }
   public class StudentManagement {

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
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    students.add(new Student(id, name));
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
                    System.out.print("Enter Student ID to Search: ");
    int searchId = sc.nextInt();

    boolean found = false;

    for (Student s : students) {
        if (s.id == searchId) {
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
                System.out.println("Thank You!");
                return;


                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
            
    
 