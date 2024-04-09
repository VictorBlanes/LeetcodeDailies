package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

public class TimeToBuyTickets extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{2, 3, 2}, {5, 1, 1, 1}};
        int[] data1 = {2, 0};
        int[] expected = {6, 8};
        System.out.print("\nDay 16 Number 2073 - Time Needed to Buy Tickets\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %b\t Result received: %b\n", i, expected[i], timeRequiredToBuy(data[i], data1[i]));
        }
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                res += Math.min(tickets[i], tickets[k]);
            } else {
                res += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return res;
    }
}
