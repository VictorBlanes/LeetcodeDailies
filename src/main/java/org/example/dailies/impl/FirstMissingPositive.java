package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class FirstMissingPositive extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{1,2,0}, {3,4,-1,1}, {7,8,9,11,12}};
        int[] expected = {3, 2, 1};
        System.out.print("\nDay 2 Number 41 - First Missing Positive\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], firstMissingPositive(data[i]));
        }
    }

    private int firstMissingPositive(int[] nums) {
        int[] checks = new int[nums.length];
        for(int num: nums){
            if(num > 0 && num <= nums.length){
                checks[num -1] = 1;
            }
        }

        int res = nums.length +1;
        for(int i = 0; i < checks.length;i ++) {
            if(checks[i] != 1){
                res = i + 1;
                break;
            }
        }
        return res;
    }

}
