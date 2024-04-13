package org.example;

import org.example.dailies.impl.*;

public class Main {

    public static void main(String[] args) {
        days1to10();
        days11to20();
    }

    private static void days1to10() {
        FindAllDuplicatesInArray findAllDuplicatesInArray = new FindAllDuplicatesInArray(); // Day 1 Number 442
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive(); // Day 2 Number 41
        SubarraysWhereProductLessThanK subarraysWhereProductLessThanK = new SubarraysWhereProductLessThanK(); // Day 3 Number 713
        LengthOfLongestSubarrayWithAtMostKFreq lengthOfLongestSubarrayWithAtMostKFreq = new LengthOfLongestSubarrayWithAtMostKFreq(); // Day 4 Number 2958
        SubArraysWhereMaxAppearsAtLeastKTimes subArraysWhereMaxAppearsAtLeastKTimes = new SubArraysWhereMaxAppearsAtLeastKTimes(); // Day 5 Number 2962
        SubArraysWithDifferentKIntegers subArraysWithDifferentKIntegers = new SubArraysWithDifferentKIntegers(); // Day 6 Number 992
        SubarraysWithFixedBound subarraysWithFixedBound = new SubarraysWithFixedBound(); // Day 7 Num 2444
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();  // Day 8 Num 58
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();  // Day 9 Num 205
        WordSearch wordSearch = new WordSearch(); // Day 10 Num 79

        findAllDuplicatesInArray.start();
        firstMissingPositive.start();
        subarraysWhereProductLessThanK.start();
        lengthOfLongestSubarrayWithAtMostKFreq.start();
        subArraysWhereMaxAppearsAtLeastKTimes.start();
        subArraysWithDifferentKIntegers.start();
        subarraysWithFixedBound.start();
        lengthOfLastWord.start();
        isomorphicStrings.start();
        wordSearch.start();
    }

    private static void days11to20() {
        MaximumNestingDepth maximumNestingDepth = new MaximumNestingDepth(); // Day 11 Num 1614
        MakeStringGreat makeStringGreat = new MakeStringGreat(); // Day 12 Num 1544
        MinRemoveToMakeValid minRemoveToMakeValid = new MinRemoveToMakeValid(); // Day 13 Num 1249
        CheckValidParenthesisString checkValidParenthesisString = new CheckValidParenthesisString(); // Day 14 Num 678
        StudentsUnableToEatLunch studentsUnableToEatLunch = new StudentsUnableToEatLunch(); // Day 15 Num 1700
        TimeToBuyTickets timeToBuyTickets = new TimeToBuyTickets(); // Day 16 Num 2073
        RevealCardsInOrder revealCardsInOrder = new RevealCardsInOrder(); // Day 17 Num 950
        RemoveKDigits removeKDigits = new RemoveKDigits(); // Day 18 Num 402
        TrappedWater trappedWater = new TrappedWater(); // Day 19 Num 42
        MaximalRectangle maximalRectangle = new MaximalRectangle(); // Day 20 Num 85

        maximumNestingDepth.start();
        makeStringGreat.start();
        minRemoveToMakeValid.start();
        checkValidParenthesisString.start();
        studentsUnableToEatLunch.start();
        timeToBuyTickets.start();
        revealCardsInOrder.start();
        removeKDigits.start();
        trappedWater.start();
        maximalRectangle.start();
    }
}
