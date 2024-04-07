package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckValidParenthesisString extends DailyProblemBase {
    @Override
    public void start() {
        String[] data = {"()", "(*)", "(*))","((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"};
        boolean[] expected = {true, true, false, true};
        System.out.print("\nDay 14 Number 678 - Valid Parenthesis String\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %b\t Result received: %b\n", i, expected[i], checkValidString(data[i]));
        }
    }

    private boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> wildcard = new ArrayList<>();
        int index = 0;
        while(index < s.length()) {
            if(s.charAt(index) == '('){
                stack.push(index);
            } else if(s.charAt(index) == ')') {
                if(stack.isEmpty()) {
                    if(wildcard.isEmpty()){
                        return false;
                    } else {
                        wildcard.remove(0);
                    }
                } else {
                    stack.pop();
                }
            } else if(s.charAt(index) == '*') {
                wildcard.add(index);
            }
            index++;
        }
        while(!wildcard.isEmpty() && !stack.isEmpty()){
            if(wildcard.get(wildcard.size() - 1) < stack.peek()){
                return false;
            } else {
                stack.pop();
                wildcard.remove(wildcard.size() - 1);
            }
        }
        return stack.isEmpty();
    }
}
