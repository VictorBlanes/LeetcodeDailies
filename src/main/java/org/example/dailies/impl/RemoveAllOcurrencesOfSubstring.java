package org.example.dailies.impl;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RemoveAllOcurrencesOfSubstring {

    public String removeAllOcurrencesOfSubstring(String s, String part) {
        String s_subset;
        int i = 0;
        while(i + part.length() <= s.length()) {
            s_subset = s.substring(i);
            if(s_subset.startsWith(part)) {
                s = s.replaceFirst(part, "");
                i = Math.max(0, i - (part.length() - 1));
            } else {
                i++;
            }
        }
        return s;
    }
}
