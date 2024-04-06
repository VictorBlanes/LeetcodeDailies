package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.Stack;

public class MinRemoveToMakeValid extends DailyProblemBase {
    @Override
    public void start() {
        String[] data = {"lee(t(c)o)de)", "a)b(c)d", "))(("};
        String[] expected = {"lee(t(c)o)de", "ab(c)d", ""};
        System.out.print("\nDay 13 Number 1249 - Minimum Remove to Make Valid Parentheses\n");
        for (int i = 0; i < data.length; i++)
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, expected[i], minRemoveToMakeValid(data[i]));

    }

    private String minRemoveToMakeValid(String s) {
        Stack<Integer> parenthesis = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == '(') {
                parenthesis.push(index);
                index++;
            } else if (str.charAt(index) == ')') {
                if (parenthesis.isEmpty()) {
                    str.deleteCharAt(index);
                } else {
                    parenthesis.pop();
                    index++;
                }
            } else {
                index++;
            }
        }
        while (!parenthesis.isEmpty()) {
            str.deleteCharAt(parenthesis.pop());
        }
        return str.toString();
    }
}
