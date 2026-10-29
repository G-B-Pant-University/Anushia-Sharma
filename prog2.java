
import java.util.Scanner;

class Student {
    String name;
    String gender;
    String course;

    Student(String name, String gender, String course) {
        this.name = name;
        this.gender = gender;
        this.course = course;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Course: " + course);
    }
}

public class prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[21];

        // Take information of 21 students
        for (int i = 0; i < 21; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            students[i] = new Student(name, gender, course);
        }

        // Store students allotted to 10 rooms
        Student[][] rooms = new Student[10][2];

        // Track which students have received a room
        boolean[] allotted = new boolean[21];

        int roomNo = 0;

        // Find two students of the same gender
        for (int i = 0; i < 21 && roomNo < 10; i++) {
            if (allotted[i]) {
                continue;
            }

            for (int j = i + 1; j < 21; j++) {
                if (!allotted[j]
                    && students[i].gender.equalsIgnoreCase(students[j].gender)) {

                    rooms[roomNo][0] = students[i];
                    rooms[roomNo][1] = students[j];

                    allotted[i] = true;
                    allotted[j] = true;

                    roomNo++;
                    break;
                }
            }
        }

        // Display room allocation
        System.out.println("\n===== ROOM ALLOCATION =====");

        for (int i = 0; i < roomNo; i++) {
            System.out.println("\nRoom " + (i + 1));

            rooms[i][0].display();

            rooms[i][1].display();
        }

        // Display students who did not get a room
        System.out.println("\n===== ROOM NOT ALLOTTED =====");

        boolean found = false;

        for (int i = 0; i < 21; i++) {
            if (!allotted[i]) {
                students[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students left without a room.");
        }

        sc.close();
    }
}
