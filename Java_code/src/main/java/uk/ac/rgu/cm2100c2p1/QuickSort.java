/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.rgu.cm2100c2p1;

/**
 *
 * @author Francesco Gruosso
 */
public class QuickSort {

    static int operations = 0;
    static int spaceComplexity = 0;

    public static void sort(int[] input) {
        /* Pass to private sort method, using the full size of the array as parameters */
        operations = 0;
        spaceComplexity = 0;
        
        sort(input, 0, input.length - 1);
    }

    private static void sort(int[] input, int low, int high) {
        operations++;

        if (low >= high || low < 0) {
            return;
        }

        int p = partition(input, low, high);

        spaceComplexity += 2; // One per each recursive call

        sort(input, low, p - 1);
        sort(input, p + 1, high);
        
    }

    private static int partition(int[] input, int low, int high) {
        int pivot = input[high];

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            operations++;

            if (input[j] < pivot) {
                operations++;
                i++;

                int tmp = input[j];
                input[j] = input[i];
                input[i] = tmp;
            }
        }

        operations++;
        i++;

        int tmp = input[high];
        input[high] = input[i];
        input[i] = tmp;

        return i;
    }

}
