package org.example;

import org.example.dailies.impl.*;

public class Main {

    public static void main(String[] args) {
        FindAllDuplicatesInArray findAllDuplicatesInArray = new FindAllDuplicatesInArray(); // Day 1 Number 442
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive(); // Day 2 Number 41
        SubarraysWhereProductLessThanK subarraysWhereProductLessThanK = new SubarraysWhereProductLessThanK(); // Day 3 Number 713
        LengthOfLongestSubarrayWithAtMostKFreq lengthOfLongestSubarrayWithAtMostKFreq = new LengthOfLongestSubarrayWithAtMostKFreq(); // Day 4 Number 2958
        SubArraysWhereMaxAppearsAtLeastKTimes subArraysWhereMaxAppearsAtLeastKTimes = new SubArraysWhereMaxAppearsAtLeastKTimes(); // Day 5 Number 2962
        SubArraysWithDifferentKIntegers subArraysWithDifferentKIntegers = new SubArraysWithDifferentKIntegers(); // Day 6 Number 992
        SubarraysWithFixedBound subarraysWithFixedBound = new SubarraysWithFixedBound(); // Day 7 Num 2444
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();  // Day 8 Num 58
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();  // Day 9 Num 205


        findAllDuplicatesInArray.start();
        firstMissingPositive.start();
        subarraysWhereProductLessThanK.start();
        lengthOfLongestSubarrayWithAtMostKFreq.start();
        subArraysWhereMaxAppearsAtLeastKTimes.start();
        subArraysWithDifferentKIntegers.start();
        subarraysWithFixedBound.start();
        lengthOfLastWord.start();
        isomorphicStrings.start();
    }
}
