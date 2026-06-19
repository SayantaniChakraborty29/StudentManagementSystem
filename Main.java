import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n==== STUDENT MANAGEMENT SYSTEM ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            // ➕ ADD STUDENT
            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                students.add(new Student(id, name));

                System.out.println("Student added successfully!");
            }

            // 📋 VIEW STUDENTS
            else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No students found!");
                } else {
                    System.out.println("=== STUDENT LIST ===");

                    for (Student s : students) {
                        System.out.println("ID: " + s.id + " | Name: " + s.name);
                    }

                    System.out.println("Total Students: " + students.size());
                }
            }

            // 🔍 SEARCH STUDENT
            else if (choice == 3) {

                System.out.print("Enter ID to search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (Student s : students) {
                    if (s.id == searchId) {
                        System.out.println("Student Found!");
                        System.out.println("ID: " + s.id + " | Name: " + s.name);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // 🗑️ DELETE STUDENT
            else if (choice == 4) {

                System.out.print("Enter ID to delete: ");
                int deleteId = sc.nextInt();

                boolean removed = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).id == deleteId) {
                        students.remove(i);
                        removed = true;
                        System.out.println("Student deleted successfully!");
                        break;
                    }
                }

                if (!removed) {
                    System.out.println("Student not found!");
                }
            }

            // 🚪 EXIT
            else if (choice == 5) {
                System.out.println("Exiting... Goodbye!");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}