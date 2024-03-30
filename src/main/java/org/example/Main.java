package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dailies.impl.SubArraysWhereMaxAppearsAtLeastKTimes;
import org.example.dailies.impl.SubArraysWithDifferentKIntegers;
import org.example.models.ListNode;

import java.util.*;

import static java.util.Objects.nonNull;

public class Main {

    public static void main(String[] args) {
        SubArraysWhereMaxAppearsAtLeastKTimes subArraysWhereMaxAppearsAtLeastKTimes = new SubArraysWhereMaxAppearsAtLeastKTimes(); // Day 5 Number 2962
        SubArraysWithDifferentKIntegers subArraysWithDifferentKIntegers = new SubArraysWithDifferentKIntegers(); // Day 6 Number 992

//        testListNode();
//        testLongestSubstring();
//        testSubarrayProduct();
//        longestSubarrayWithKFreq();
//        countSubarraysTest();

        subArraysWhereMaxAppearsAtLeastKTimes.start();
        subArraysWithDifferentKIntegers.start();
    }

    private static void countSubarraysTest() {
        int[] test = {1, 3, 2, 3, 3};
        int[] test1 = {61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82};
        int[] test2 = {28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49};
        int k = 2;
        int k1 = 2;
        int k2 = 1;
        System.out.println(countSubarrays(test2, k2));
        System.out.println(countSubarrays2(test2, k2));
    }

    private static void longestSubarrayWithKFreq() {
        int[] nums = {5, 5, 5, 5, 5, 5, 5};
        int[] nums1 = {1};
        int[] nums2 = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 4;
        int k1 = 1;
        int k2 = 2;
        System.out.println(maxSubarrayLength(nums2, k2));
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

    public static int maxSubarrayLength(int[] nums, int k) {
        int index = 0, starting_index_subarray = 0, longest_subarray = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (index < nums.length) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            if (map.get(nums[index]) > k) {
                while (map.get(nums[index]) > k) {
                    map.put(nums[starting_index_subarray], map.get(nums[starting_index_subarray]) - 1);
                    starting_index_subarray++;
                }
            }
            longest_subarray = Math.max(index - starting_index_subarray + 1, longest_subarray);
            index++;
        }
        return longest_subarray;
    }

    public static long countSubarrays(int[] nums, int k) {
        int max_num = 0, freq = 0, right = 0, left = 0;
        long num_subarray = 0;

        while (right < nums.length) {
            if (nums[right] > max_num) {
                max_num = nums[right];
                num_subarray = 0;
                freq = 0;
                left = 0;
            }

            if (nums[right] == max_num) {
                freq++;
                while (freq >= k) {
                    if (nums[left] == max_num) {
                        freq--;
                    }

                    num_subarray += nums.length - right;
                    left++;
                }
            }

            right++;
        }

        return num_subarray;
    }

    public static long countSubarrays2(int[] nums, int k) {
        long maxNum = Long.MIN_VALUE, count = 0;
        long left = 0, right = 0, ans = 0;

        // Find the maximum element in the array
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        while (right < nums.length || left > right) {
            if (nums[(int) right] == maxNum) {
                count++;
            }
            // If count is greater than or equal to k, calculate subarrays count
            while (count >= k) {
                if (nums[(int) left] == maxNum) {
                    count--;
                }
                left++;
                ans += nums.length - right;
            }
            right++;
        }
        return ans;
    }
}
