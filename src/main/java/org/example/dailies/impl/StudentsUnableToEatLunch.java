package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class StudentsUnableToEatLunch extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{1, 1, 0, 0}, {1, 1, 1, 0, 0, 1}};
        int[][] data1 = {{0, 1, 0, 1}, {1, 0, 0, 0, 1, 1}};
        int[] expected = {0, 3};
        System.out.print("\nDay 15 Number 1700 - Number of Students Unable to Eat Lunch\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %b\t Result received: %b\n", i, expected[i], countStudents(data[i], data1[i]));
        }
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int studentsLeft = students.length;
        int noPickedTop = 0;
        int topSandwitch = 0;
        while (studentsLeft != 0 && noPickedTop < studentsLeft) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] != -1) {
                    if (students[i] == sandwiches[topSandwitch]) {
                        students[i] = -1;
                        noPickedTop = 0;
                        studentsLeft--;
                        topSandwitch++;
                    } else {
                        noPickedTop++;
                    }
                }
            }
        }
        return studentsLeft;
    }
}
