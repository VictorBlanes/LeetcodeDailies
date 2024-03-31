package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class SubarraysWithFixedBound extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{1, 3, 5, 2, 7, 5}, {1, 1, 1, 1}, {35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913}};
        int[] data1 = {1, 1, 35054};
        int[] data2 = {5, 1, 945315};
        int[] expected = {2, 10, 81};
        System.out.print("\nDay 7 Number 2444 - Count Subarrays With Fixed Bounds\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], countSubarrays(data[i], data1[i], data2[i]));
        }
    }

    //Not done by me, cuz I'm retarded
    private long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int badIdx = -1, leftIdx = -1, rightIdx = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (minK > nums[i] || nums[i] > maxK) {
                badIdx = i;
            }

            if (nums[i] == minK) {
                leftIdx = i;
            }

            if (nums[i] == maxK) {
                rightIdx = i;
            }

            res += Math.max(0, Math.min(leftIdx, rightIdx) - badIdx);
        }

        return res;
    }
}
