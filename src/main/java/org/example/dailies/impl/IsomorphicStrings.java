package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings extends DailyProblemBase {
    @Override
    public void start() {
        String[] data = {"egg", "foo", "paper", "badc"};
        String[] data1 = {"add", "bar", "title", "baba"};
        boolean[] expected = {true, false, true, false};
        System.out.print("\nDay 9 Number 205 - Isomorphic Strings\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %b\t Result received: %b\n", i, expected[i], isIsomorphic(data[i], data1[i]));
        }
    }

    private boolean isIsomorphic(String s, String t) {
        Map<Character, Character> transform = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(transform.containsKey(cs)){
                if(!transform.get(cs).equals(ct)) return false;
            } else {
                if(transform.containsValue(ct)) return false;
                transform.put(cs, ct);
            }
        }

        return true;
    }
}
