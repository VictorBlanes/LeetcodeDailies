package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class SubArraysWhereMaxAppearsAtLeastKTimes extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{1, 3, 2, 3, 3}, {1, 4, 2, 1}};
        int[] data1 = {2, 3};
        int[] expected = {6, 0};
        System.out.print("\nDay 5 Number 2962 - Count Subarrays Where Max Element Appears at Least K Times\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], countSubarrays(data[i], data1[i]));
        }
    }

    private long countSubarrays(int[] nums, int k) {
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
                if (freq >= k) {
                    while (freq >= k) {
                        if (nums[left] == max_num) {
                            freq--;
                        }

                        num_subarray += nums.length - right;
                        left++;
                    }
                }
            }

            right++;
        }

        return num_subarray;
    }
}
