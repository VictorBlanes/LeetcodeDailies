package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class SubarraysWhereProductLessThanK extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{10,5,2,6}, {1,2,3}};
        int[] data1 = {100, 0};
        int[] expected = {8, 0};
        System.out.print("\nDay 3 Number 713 - Subarrays Product Less Than K\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], numSubarrayProductLessThanK(data[i], data1[i]));
        }
    }

    private int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0, right = 0, product = 1, count = 0;
        int n = nums.length;

        while (right < n) {
            product *= nums[right];
            while (product >= k) product /= nums[left++];
            count += 1 + (right - left);
            right++;
        }

        return count;
    }
}
