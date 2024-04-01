package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class LengthOfLastWord extends DailyProblemBase {
    @Override
    public void start() {
        String[] data = {"Hello World", "   fly me   to   the moon  ", "luffy is still joyboy"};
        int[] expected = {5, 4, 6};
        System.out.print("\nDay 8 Number 58 - Length of Last Word\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], lengthOfLastWord(data[i]));
        }
    }

    private int lengthOfLastWord(String s) {
        String[] sTokenized = s.split(" ");
        return sTokenized[sTokenized.length - 1].length();
    }
}
