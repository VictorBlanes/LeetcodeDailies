package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.Arrays;

public class RemoveKDigits extends DailyProblemBase {
    @Override
    public void start() {
        String[] data = {"1432219", "10200", "10", "112", "1234567890"};
        int[] data1 = {3, 1, 2, 1, 9};
        String[] expected = {"1219", "200", "0", "11" , "0"};
        System.out.print("\nDay 18 Number 402 - Remove K Digits\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, expected[i], removeKdigits(data[i], data1[i]));
        }
    }

    private String removeKdigits(String num, int k) {
        int i = 0;
        StringBuilder sb =  new StringBuilder(num);
        while(i < sb.length() - 1 && k > 0) {
            if(sb.charAt(i) > sb.charAt(i + 1)) {
                k--;
                sb.deleteCharAt(i);
                i = Math.max(i - 1, 0);
            } else {
                i++;
            }
        }

        while(!sb.isEmpty() && k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
