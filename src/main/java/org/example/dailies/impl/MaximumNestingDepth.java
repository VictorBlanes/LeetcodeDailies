package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class MaximumNestingDepth extends DailyProblemBase {
    @Override
    public void start() {
        String[] data = {"(1+(2*3)+((8)/4))+1", "(1)+((2))+(((3)))"};
        int[] expected = new int[]{3, 3};
        System.out.print("\nDay 11 Number 1614 - Maximum Nesting Depth of the Parentheses\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], maxDepth(data[i]));
        }
    }

    private int maxDepth(String s) {
        int depth = 0, maxDepth = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                depth--;
            } else if(c == '('){
                depth++;
            }

            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}
