package org.example;
import java.util.Scanner;
public class StudentGradeCalculator {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Number of Subjects: ");
        int subjects = scan.nextInt();

        double totalmarks = 0;

//        ()
        for (int i = 0; i < subjects ; i++) {
            while (true){
                System.out.println("Enter Marks for Subject "+ (i+1) +" Out of 100");
                int subjectmark = scan.nextInt();
                if (subjectmark >= 0 && subjectmark <= 100 ) {
                    totalmarks += subjectmark;
                    break;
                }else {
                    System.out.println("Invalid input! Marks must be between 0 and 100.");
                }
            }
        }

        double average = totalmarks/subjects;
        System.out.println(average);

        String grade;

        if (average >= 90){
            grade = "A+";
        }if (average >= 80 || average <=90) {
            grade ="A";
        }if (average >= 70 || average <= 80){
            grade ="B";
        }
        if (average >= 60 || average <= 70){
            grade ="c";
        }
        if (average >= 50 || average <= 60){
            grade ="D";
        }else {
            grade ="F";
        }

        System.out.println("Result");
        System.out.printf("Total Marks: %.2f / %.0f\n", totalmarks, subjects * 100.0);
        System.out.printf("Average Percentage: %.2f%%\n" ,average);
        System.out.println("Grade: "+ grade);

        scan.close();
    }


}
