package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dailies.impl.LengthOfLongestSubarrayWithAtMostKFreq;
import org.example.dailies.impl.SubArraysWhereMaxAppearsAtLeastKTimes;
import org.example.dailies.impl.SubArraysWithDifferentKIntegers;
import org.example.dailies.impl.SubarraysWhereProductLessThanK;
import org.example.models.ListNode;

import java.util.*;

import static java.util.Objects.nonNull;

public class Main {

    public static void main(String[] args) {
        SubarraysWhereProductLessThanK subarraysWhereProductLessThanK = new SubarraysWhereProductLessThanK(); // Day 3 Number 713
        LengthOfLongestSubarrayWithAtMostKFreq lengthOfLongestSubarrayWithAtMostKFreq = new LengthOfLongestSubarrayWithAtMostKFreq(); // Day 4 Number 2958
        SubArraysWhereMaxAppearsAtLeastKTimes subArraysWhereMaxAppearsAtLeastKTimes = new SubArraysWhereMaxAppearsAtLeastKTimes(); // Day 5 Number 2962
        SubArraysWithDifferentKIntegers subArraysWithDifferentKIntegers = new SubArraysWithDifferentKIntegers(); // Day 6 Number 992

//        testListNode();
//        testLongestSubstring();
//        testSubarrayProduct();
//        countSubarraysTest();

        subarraysWhereProductLessThanK.start();
        lengthOfLongestSubarrayWithAtMostKFreq.start();
        subArraysWhereMaxAppearsAtLeastKTimes.start();
        subArraysWithDifferentKIntegers.start();
    }

    private static void testSubarrayProduct() {
        int[] nums = {10, 5, 2, 6};
        int[] nums1 = {1, 1, 1};
        int k = 100;
        int k1 = 2;
        System.out.println(numSubarrayProductLessThanK(nums1, k1));
    }

    private static void testLongestSubstring() {
        String s = "abcabcbb";
        String s1 = " ";
        String s2 = "";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
    }

    private static void testListNode() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);

        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);


        l5.setNext(l6);
        l6.setNext(l7);
        l7.setNext(l8);
        l8.setNext(l9);
        l9.setNext(l10);
        l10.setNext(l11);

        Integer[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        ListNode res = addTwoNumbers(l1, l5);

        while (nonNull(res)) {
            System.out.print(res.getVal());
            res = res.getNext();
        }
    }

    public static List<Integer> sorter(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entrySet : counter.entrySet()) {
            if (entrySet.getValue() >= 2) {
                res.add(entrySet.getKey());
            }
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> needs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (needs.containsKey(target - nums[i])) {
                return new int[]{needs.get(target - nums[i]), i};
            } else {
                needs.put(nums[i], i);
            }
        }
        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(l1.getVal() + l2.getVal());
        ListNode start = res;

        while (nonNull(l1.getNext()) && nonNull(l2.getNext())) {
            res.setNext(new ListNode(l1.getNext().getVal() + l2.getNext().getVal()));
            res = res.getNext();
            l1 = l1.getNext();
            l2 = l2.getNext();
            System.out.println("HOLA");
        }

        if (nonNull(l1.getNext())) {
            res.setNext(l1.getNext());
        } else if (nonNull(l2.getNext())) {
            res.setNext(l2.getNext());
        }

        ListNode finalUntreated = start;
        while (nonNull(finalUntreated)) {
            if (finalUntreated.getVal() >= 10) {
                if (nonNull(finalUntreated.getNext())) {
                    finalUntreated.getNext().changeVal(1);
                    finalUntreated.changeVal(-10);
                } else {
                    finalUntreated.setNext(new ListNode(1));
                    finalUntreated.changeVal(-10);
                }
                finalUntreated = finalUntreated.getNext();
            } else {
                finalUntreated = finalUntreated.getNext();
            }
        }
        return start;
    }

    public static int lengthOfLongestSubstring(String s) {
        int highestNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            for (int j = i + 1; j < s.length(); j++) {
                String toAdd = s.substring(j, j + 1);
                if (substring.contains(toAdd)) {
                    break;
                } else {
                    substring += toAdd;
                }
            }
            if (substring.length() > highestNumber) {
                highestNumber = substring.length();
            }
        }
        return highestNumber;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int index_start = 0, index_end = 0, res_product = 1, res = 0;
        while (index_start < nums.length) {
            if (index_end < nums.length) {
                res_product *= nums[index_end];
                if (res_product < k) {
                    if (index_end - index_start > 1) {
                        res += (index_end - index_start - 1);
                    }
                    index_end++;
                    if (index_end < nums.length && nums[index_end] < k) {
                        res++;
                    }
                    res++;
                } else {
                    res_product /= nums[index_start];
                    index_start++;
                    index_end++;
                    if (index_end < nums.length && nums[index_end] < k) {
                        res++;
                    }
                }
            } else {
                res_product /= nums[index_start];
                index_start++;
                if (res_product < k && (index_end - index_start > 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int howManyAreMoreThan(int[] nums, int start_index, int k, int start_num) {
        int accumulated_res = 0;
        if (start_index < (nums.length) && start_num * nums[start_index] < k) {
            accumulated_res++;
            accumulated_res += howManyAreMoreThan(nums, start_index + 1, k, start_num * nums[start_index]);
        }
        return accumulated_res;
    }
}
