package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.Stack;

public class MaximalRectangle extends DailyProblemBase {
    @Override
    public void start() {
        char[][][] data = {{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}, {{'0'}}, {{'1'}}};
        int[] expected = {6, 0, 1};
        System.out.print("\nDay 20 Number 85 - Maximal Rectangle\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, expected[i], maximalRectangle(data[i]));
        }
    }

    // No lo he hecho yo porque soy stuped
    private int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // Include an extra element for easier calculation
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }

            // Calculate max area using stack-based method
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }

        return maxArea;
    }
}
