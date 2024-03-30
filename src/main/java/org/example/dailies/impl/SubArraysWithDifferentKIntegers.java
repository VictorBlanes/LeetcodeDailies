package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;

import java.util.HashMap;
import java.util.Map;

/**
 * Day: 6
 * Number: 992
 * <p>
 * Description:
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * A good array is an array where the number of different integers in that array is exactly k.
 **/
public class SubArraysWithDifferentKIntegers extends DailyProblemBase {


    public SubArraysWithDifferentKIntegers() {
    }

    @Override
    public void start() {
        int[][] data = {{1, 2, 1, 2, 3}, {1, 2, 1, 3, 4}, {2, 1, 1, 1, 2}};
        int[] data1 = {2, 3, 1};
        int[] expected = {7, 3, 8};
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %d\t Result received: %d\n", i, expected[i], subarraysWithKDistinct(data[i], data1[i]));
        }
    }

    /**
     * Post-mortem:
     * <p>
     * Se usa una tecnica de ventanas deslizantes, se va iterando con el indice right sobre el programa y se guardan los
     * elementos encontrados en un hashmap freq. Cada iteracion sobre nums tiene una fase de expansion (Cuando se lee el
     * propio valor de nums y se almacena en freq) y una posible fase de reduccion.
     * <p>
     * Cuando el numero de valores en el hashmap supera la cantidad que el programa requiere se comienza a iterar sobre
     * el puntero left quitando de freq los valores encontrados hasta que estamos una una condicion de freq.size == k
     * <p>
     * Cuando el numero de valores en freq es igual a k se va iterando sobre left hasta encontrar el subarray mas pequeño
     * que sigue cumpliendo la condicion de freq.size() == k. En cada iteracion se incrementa el valor de ans que indica
     * cuantas soluciones se han econtrado y el valor cum.
     * <p>
     * El valor cum guarda el numero de subarrays conocidos que se tienen que añadir con cada nuevo elemento leido por right,
     * esto se hace para no tener que empezar iterando de 0 cada vez que se tiene la condicion freq.size() == k. Este valor
     * se resetea cuando se tiene freq.size() > k.
     * <p>
     * De cierta manera, cum+left indica el indice mas bajo que, junto a right, cumple que freq.size() == k.
     */
    private int subarraysWithKDistinct(int[] nums, int k) {
        int left = 0, right = 0, cum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        while (right < nums.length) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            if (freq.size() == k) {
                ans += cum;
            }

            while (freq.size() > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    cum = 0;
                    freq.remove(nums[left]);
                }
                left++;
            }

            while (freq.size() == k) {
                ans++;
                if (freq.get(nums[left]) == 1) {
                    break;
                }
                freq.put(nums[left], freq.get(nums[left]) - 1);
                cum++;
                left++;
            }

            right++;
        }
        return ans;
    }
}
