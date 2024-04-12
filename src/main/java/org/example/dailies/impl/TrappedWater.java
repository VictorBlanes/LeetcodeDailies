package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class TrappedWater extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, {4, 2, 0, 3, 2, 5}, {4, 2, 3}};
        int[] expected = {6, 9, 1};
        System.out.print("\nDay 19 Number 42 - Trapping Rain Water\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, expected[i], trap(data[i]));
        }
    }

    private int trap(int[] height) {
        int ans = 0;
        int trappedWater = 0;
        int maxHeightIndex = 0;
        int index = 0;
        while (index < height.length) {
            if (height[index] >= height[maxHeightIndex]) {
                ans += trappedWater;
                trappedWater = 0;
                maxHeightIndex = index;
            } else {
                trappedWater += (height[maxHeightIndex] - height[index]);
            }
            index++;
        }

        if (trappedWater != 0) {
            int limit = maxHeightIndex;
            index--;
            maxHeightIndex = index;
            trappedWater = 0;
            while (index >= limit) {
                if (height[index] >= height[maxHeightIndex]) {
                    ans += trappedWater;
                    trappedWater = 0;
                    maxHeightIndex = index;
                } else {
                    trappedWater += (height[maxHeightIndex] - height[index]);
                }
                index--;
            }
        }
        return ans;
    }
}
