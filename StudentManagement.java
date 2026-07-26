import java.io.*;
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
    System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
}

public String getGrade() {
    if (marks >= 90)
        return "A+";
    else if (marks >= 80)
        return "A";
    else if (marks >= 70)
        return "B";
    else if (marks >= 60)
        return "C";
    else if (marks >= 40)
        return "D";
    else
        return "F";
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

public static void displayPassFailCount(ArrayList<Student> students) {
    int pass = 0;
    int fail = 0;

    for (Student s : students) {
        if (s.marks >= 40) {
            pass++;
        } else {
            fail++;
        }
    }

    System.out.println("Pass Students: " + pass);
    System.out.println("Fail Students: " + fail);
}

public static void displayRank(ArrayList<Student> students) {

    if (students.isEmpty()) {
        System.out.println("No students available!");
        return;
    }

    ArrayList<Student> rankList = new ArrayList<>(students);

    Collections.sort(rankList, (s1, s2) -> s2.marks - s1.marks);

    System.out.println("===== STUDENT RANK LIST =====");

    int rank = 1;

    for (Student s : rankList) {
        System.out.println("Rank " + rank + " : " + s.name + " - " + s.marks);
        rank++;
    }
}

public static void saveStudents(ArrayList<Student> students) {
    try {
        PrintWriter writer = new PrintWriter(new FileWriter("students.txt"));

        for (Student s : students) {
            writer.println(s.id + "," + s.name + "," + s.marks);
        }

        writer.close();
        System.out.println("Students saved successfully!");

    } catch (IOException e) {
        System.out.println("Error saving file!");
    }
}


public static void loadStudents(ArrayList<Student> students) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int marks = Integer.parseInt(data[2]);

            students.add(new Student(id, name, marks));
        }

        reader.close();

    } catch (IOException e) {
        System.out.println("No saved data found.");
    }
}

public static void displayStatistics(ArrayList<Student> students) {

    if (students.isEmpty()) {
        System.out.println("No students available!");
        return;
    }

    int total = 0;
    int highest = students.get(0).marks;
    int lowest = students.get(0).marks;

    for (Student s : students) {
        total += s.marks;

        if (s.marks > highest)
            highest = s.marks;

        if (s.marks < lowest)
            lowest = s.marks;
    }

    double average = (double) total / students.size();

    System.out.println("===== CLASS STATISTICS =====");
    System.out.println("Total Students : " + students.size());
    System.out.println("Highest Marks  : " + highest);
    System.out.println("Lowest Marks   : " + lowest);
    System.out.printf("Average Marks  : %.2f%n", average);
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
            System.out.println("9.Show Pass/Fail Count");
            System.out.println("10:Highest and Lowest Marks");
            System.out.println("11:Update Student Marks");
            System.out.println("12:Save Students");
            System.out.println("13:Display Student Rank");
            System.out.println("14: Load Students");
            System.out.println("15: Display student grades");
            System.out.println("16:Display Class Statistics");
            System.out.println("17:Exit");
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
    System.out.printf("Average: %.2f%n", average);
    break;

case 9:
    displayPassFailCount(students);
    break;


    case 10:

    if (students.isEmpty()) {
        System.out.println("No students available!");
        break;
    }

    Student highest = students.get(0);
    Student lowest = students.get(0);

    for (Student s : students) {
        if (s.marks > highest.marks) {
            highest = s;
        }

        if (s.marks < lowest.marks) {
            lowest = s;
        }
    }

    System.out.println("Highest Marks: " + highest.name + " - " + highest.marks);
    System.out.println("Lowest Marks: " + lowest.name + " - " + lowest.marks);

    break;

case 11:
    System.out.print("Enter Student ID: ");
    int markId = sc.nextInt();

    boolean markUpdated = false;

    for (Student s : students) {
        if (s.id == markId) {
            System.out.print("Enter New Marks: ");
            int newMarks = sc.nextInt();

            if (newMarks >= 0 && newMarks <= 100) {
                s.marks = newMarks;
                System.out.println("Marks Updated Successfully!");
            } else {
                System.out.println("Invalid Marks!");
            }

            markUpdated = true;
            break;
        }
    }

    if (!markUpdated) {
        System.out.println("Student Not Found!");
    }
    break;

    case 12:
           saveStudents(students);
           break;

    case 13:
           displayRank(students);
           break;


case 14:
    students.clear();
    loadStudents(students);
    System.out.println("Students Loaded Successfully!");
    break;

case 15:

    if (students.isEmpty()) {
        System.out.println("No students available!");
        break;
    }

    System.out.println("===== STUDENT GRADES =====");

    for (Student s : students) {
        System.out.println(
            "ID: " + s.id +
            " | Name: " + s.name +
            " | Marks: " + s.marks +
            " | Grade: " + s.getGrade()
        );
    }

    break;

case 16:
    displayStatistics(students);
    break;

    case 17:
            System.out.println("Thank You!");
            return;


                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
          
    
 