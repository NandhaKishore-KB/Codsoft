import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = sc.nextInt();
            
            double totalMarks = 0;
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks for subject " + i + ": ");
                double marks = sc.nextDouble();
                totalMarks += marks;
            }
            
            double averagePercentage = totalMarks / numSubjects;
            char grade;
            
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage);
            System.out.println("Grade: " + grade);
        }
    }
}