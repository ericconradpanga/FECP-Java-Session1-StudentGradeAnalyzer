package org.example;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create scanner object for user input

        int numberOfStudents; // create variable for number of students
        System.out.print("Enter number of students: ");
        numberOfStudents = scanner.nextInt(); // get number of students from user

        ArrayList<String> studentNames = new ArrayList<>(); // create ArrayList for student names
        ArrayList<Integer> studentScores = new ArrayList<>(); // create ArrayList for student scores
        int[] letterGradeSummary = new int[5]; // create array for letter grade summary

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println();

            System.out.printf("Enter name of student %d: ", i + 1);
            String studentName = scanner.next(); // get the current student name from user
            studentNames.add(studentName); // add to studentNames

            System.out.printf("Enter score for %s: ", studentName);
            int studentScore = scanner.nextInt(); // get the current student score from user
            studentScores.add(studentScore); // add to studentScores

            System.out.printf("%s got grade: %c\n", studentName, getLetterGrade(letterGradeSummary, studentScore));
        }

        System.out.print("\n----- Class Summary -----\n");
        System.out.printf("Average Score: %.2f\n", getAverageScore(studentScores));
        System.out.printf("Grade Counts: A:%d B:%d C:%d D:%d E:%d\n",
                letterGradeSummary[0],
                letterGradeSummary[1],
                letterGradeSummary[2],
                letterGradeSummary[3],
                letterGradeSummary[4]);
        System.out.print("Top Student(s):");
        getTopStudents(studentNames, studentScores);
    }

    // method for calculating letter grade based on student's score
    private static char getLetterGrade(int[] letterGradeSummary, int studentScore) {
        char letterGrade;

        if (studentScore >= 90 && studentScore <= 100) {
            letterGrade = 'A';
            letterGradeSummary[0]++;
        } else if (studentScore >= 80 && studentScore <= 89) {
            letterGrade = 'B';
            letterGradeSummary[1]++;
        } else if (studentScore >= 70 && studentScore <= 79) {
            letterGrade = 'C';
            letterGradeSummary[2]++;
        } else if (studentScore >= 60 && studentScore <= 69) {
            letterGrade = 'D';
            letterGradeSummary[3]++;
        } else {
            letterGrade = 'F';
            letterGradeSummary[4]++;
        }

        return letterGrade;
    }

    // method for calculating average of all student scores
    private static float getAverageScore(ArrayList<Integer> studentScores) {
        int sum = 0;

        // iterate over each score and add to sum
        for (int score : studentScores) {
            sum += score;
        }

        return (float) sum / studentScores.size();
    }

    // method for printing all top student(s) and their corresponding score(s)
    private static void getTopStudents(ArrayList<String> studentNames, ArrayList<Integer> studentScores) {
        ArrayList<Integer> topStudents = new ArrayList<>(); // create ArrayList for index(es) of top student(s)
        int highestScore = Collections.max(studentScores);

        // iterate over each score and check if it matches highest score
        for (int i = 0; i < studentScores.size(); i++){
            if (studentScores.get(i) == highestScore){
                topStudents.add(i); // if it matches, add index to topStudents
            }
        }

        for (Integer topStudent : topStudents) {
            System.out.printf(" %s (%d)", studentNames.get(topStudent), studentScores.get(topStudent));
        }
    }
}