package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFreq extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{1, 2, 3, 1, 2, 3, 1, 2}, {1, 2, 1, 2, 1, 2, 1, 2}, {5, 5, 5, 5, 5, 5, 5}};
        int[] data1 = {2, 1, 4};
        int[] expected = {6, 2, 4};
        System.out.print("\nDay 4 Number 2958 - Length of Longest Subarray With at Most K Frequency\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], maxSubarrayLength(data[i], data1[i]));
        }
    }

    private int maxSubarrayLength(int[] nums, int k) {
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
}
