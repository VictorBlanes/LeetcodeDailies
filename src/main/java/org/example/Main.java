package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dailies.impl.*;
import org.example.models.ListNode;

import java.util.*;

import static java.util.Objects.nonNull;

public class Main {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive(); // Day 2 Number 41
        SubarraysWhereProductLessThanK subarraysWhereProductLessThanK = new SubarraysWhereProductLessThanK(); // Day 3 Number 713
        LengthOfLongestSubarrayWithAtMostKFreq lengthOfLongestSubarrayWithAtMostKFreq = new LengthOfLongestSubarrayWithAtMostKFreq(); // Day 4 Number 2958
        SubArraysWhereMaxAppearsAtLeastKTimes subArraysWhereMaxAppearsAtLeastKTimes = new SubArraysWhereMaxAppearsAtLeastKTimes(); // Day 5 Number 2962
        SubArraysWithDifferentKIntegers subArraysWithDifferentKIntegers = new SubArraysWithDifferentKIntegers(); // Day 6 Number 992

//        testListNode();
//        testLongestSubstring();
//        testSubarrayProduct();
//        countSubarraysTest();

        firstMissingPositive.start();
        subarraysWhereProductLessThanK.start();
        lengthOfLongestSubarrayWithAtMostKFreq.start();
        subArraysWhereMaxAppearsAtLeastKTimes.start();
        subArraysWithDifferentKIntegers.start();
    }
}
