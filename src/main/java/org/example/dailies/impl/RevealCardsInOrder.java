package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.Arrays;

public class RevealCardsInOrder extends DailyProblemBase {
    @Override
    public void start() {
        int[][] data = {{17, 13, 11, 2, 3, 5, 7}, {1, 1000}, {1, 2, 3}};
        int[][] expected = {{2, 13, 3, 11, 5, 17, 7}, {1, 1000}, {1, 3, 2}};
        System.out.print("\nDay 17 Number 950 - Reveal Cards in Increasing Order\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, Arrays.toString(expected[i]), Arrays.toString(deckRevealedIncreasing(data[i])));
        }
    }

    private int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        int step = 1, lap = 0, index = 0, earliestFree = 1, newStep;
        Arrays.sort(deck);
        for (int i = 0; i < deck.length; i++) {
            res[index] = deck[i];
            index += (step + step);
            if (index >= deck.length) {
                lap++;
                newStep = (int) Math.pow(2, lap);
                if (index - step >= deck.length) {
                    if (i == deck.length - 2) {
                        index = earliestFree;
                    } else {
                        index = (earliestFree + newStep);
                    }
                } else {
                    index = earliestFree;
                    earliestFree = index + newStep;
                }
                step = newStep;
            }
        }
        return res;
    }
}
