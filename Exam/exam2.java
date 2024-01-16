import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class exam2 {
    static Scanner sc = new Scanner(System.in);
    static TreeMap<String, String> stud = new TreeMap<>();

    public static void main(String[] args) {

        int choice = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Student : ");
            System.out.println("2. View Student : ");
            System.out.println("3. Update Student : ");
            System.out.println("4. Remove Student : ");
            System.out.println("5. Search Student : ");
            System.out.println("6. Exit : ");

            System.out.println("Enter your choice : ");

            choice = sc.nextInt();

            switch ((choice)) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudent();
                    break;

                case 3:
                    updateStudent();
                    break;
                case 4:
                    removeStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                default:
                    break;
            }
        } while (choice < 6);

    }

    static void addStudent() {
        System.out.print("Enter Name : ");
        Scanner sc1 = new Scanner(System.in);
        String stName = sc1.nextLine();
        System.out.print("Enter Grade : ");
        String scGrade = sc1.nextLine();
        stud.put(stName, scGrade);
        System.out.println("Student added successfully");

    }

    static void viewStudent() {
        for (Map.Entry<String, String> entry : stud.entrySet()) {
            System.out.println("ID : " + entry.getKey() + " Name : " + entry.getValue());
        }
    }

    static void updateStudent() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Name : ");
        String stName = sc1.nextLine();
        System.out.print("Enter New Grade : ");
        String scGrade = sc1.nextLine();
        stud.put(stName, scGrade);
        System.out.println("Student updated successfully");
    }

    static void removeStudent() {
        System.out.print("Enter name of student to remove: ");
        String scName = sc.nextLine();
        stud.remove(scName);
        System.out.println("Student removed successfully");
    }

    static void searchStudent() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Name of student to search: ");
        String scName = sc1.nextLine();
        String stuGrade = stud.get(scName);
        System.out.println("Grade of " + scName + " is " + stuGrade);

    }

}
// public Class Student{
// String name;
// String grade;
// public void Student(String name, String grade) {
// this.name = name;
// this.grade = grade;
// }

// @Override
// public String toString() {
// return "Product{" +
// "name='" + name + '\'' +
// "grade='" + grade + '\'' +
// '}';
// }
// }
