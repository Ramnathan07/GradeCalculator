package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StudentGradeCalculatorGUI extends JFrame {
    private JTextField[] markFields;
    private JButton calculateButton;
    private JLabel resultLabel;

    public StudentGradeCalculatorGUI(int subjectCount) {
        setTitle("Student Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel for subject marks
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(subjectCount, 2));

        markFields = new JTextField[subjectCount];

        for (int i = 0; i < subjectCount; i++) {
            inputPanel.add(new JLabel("Marks for Subject " + (i + 1) + " (out of 100):"));
            markFields[i] = new JTextField();
            inputPanel.add(markFields[i]);
        }

        // Button to calculate
        calculateButton = new JButton("Calculate Grade");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        // Label to display result
        resultLabel = new JLabel("Enter marks and click Calculate.", SwingConstants.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    private void calculateGrade() {
        double total = 0;
        int numSubjects = markFields.length;

        for (int i = 0; i < numSubjects; i++) {
            try {
                double mark = Double.parseDouble(markFields[i].getText());
                if (mark < 0 || mark > 100) {
                    resultLabel.setText("Invalid mark for subject " + (i + 1));
                    return;
                }
                total += mark;
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
                return;
            }
        }

        double average = total / numSubjects;
        String grade = getGrade(average);

        resultLabel.setText(String.format("Total: %.2f | Avg: %.2f%% | Grade: %s", total, average, grade));
    }

    private String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        // Ask how many subjects
        String input = JOptionPane.showInputDialog("Enter number of subjects:");
        try {
            int subjectCount = Integer.parseInt(input);
            if (subjectCount <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a positive number.");
                return;
            }
            new StudentGradeCalculatorGUI(subjectCount);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }
    }
}




