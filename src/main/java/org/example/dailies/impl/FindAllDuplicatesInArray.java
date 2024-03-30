package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{4,3,2,7,8,2,3,1}, {1,1,2}, {1}};
        List<List<Integer>> expected = List.of(List.of(2,3), List.of(1), List.of());
        System.out.print("\nDay 1 Number 442 - Find All Duplicated in an Array\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, toStringList(expected.get(i)), toStringList(findDuplicates(data[i])));
        }
    }

    private List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int[]count = new int[nums.length+1];
        for(int freq : nums)
            count[freq]++;

        for( int i =1 ; i <= nums.length ; i++)
        {
            if(count[i] == 2){
                res.add(i);
            }
        }
        return res;
    }

    private String toStringList(List<Integer> list){
        String res = "[";
        for(int i = 0; i < list.size() - 1; i++){
            res += String.format("%d, ", list.get(i));
        }

        if(list.size() >= 1){
            res += String.format("%d]", list.get(list.size() - 1));
        } else{
            res += "]";
        }
        return res;
    }
}
