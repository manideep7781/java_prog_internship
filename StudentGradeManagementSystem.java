import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[3];

    double average() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / 3.0;
    }

    String grade() {
        double avg = average();
        if (avg >= 80) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 40) return "C";
        else return "Fail";
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.println("Enter Student name: ");
        s.name = sc.nextLine();

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + ":");
            s.marks[i] = sc.nextInt();
        }

        double avg = s.average();
        String grade = s.grade();

        System.out.println("--------- Student Report ---------------");
        System.out.println("Name: " + s.name + " | Marks: " + s.marks[0] + ", " + s.marks[1] + ", " + s.marks[2]);
        System.out.println("Average: %.2f\n"+ avg);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
