package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class MakeStringGreat extends DailyProblemBase {
    @Override
    public void start() {
        String[] data = {"leEeetcode", "abBAcC", "s"};
        String[] expected = {"leetcode", "", "s"};
        System.out.print("\nDay 12 Number 1544 - Make The String Great\n");
        for (int i = 0; i < data.length; i++)
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, expected[i], makeGood(data[i]));
    }

    private String makeGood(String s) {
        int left = 0;
        StringBuilder sb = new StringBuilder(s);
        while(left < sb.length() - 1) {
            char l = sb.charAt(left);
            char r = sb.charAt(left + 1);
            if((Character.isUpperCase(l) ^ Character.isUpperCase(r)) && (Character.toLowerCase(l) == Character.toLowerCase(r))){
                sb.deleteCharAt(left);
                sb.deleteCharAt(left);
                left = Math.max(left - 1, 0);
            } else {
                left++;
            }
        }
        return sb.toString();
    }
}
