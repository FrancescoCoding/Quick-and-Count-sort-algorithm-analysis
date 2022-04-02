package uk.ac.rgu.cm2100c2p1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Francesco Gruosso
 */
public class CountSort {

    static int operations = 0;
    static int spaceComplexity = 0;

    public static void sort(int[] input) {

        operations = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : input) {
            operations++;

            if (number < min) {
                min = number;
            }

            if (number > max) {
                max = number;
            }
        }

        int[] frequencies = new int[max - min + 1];
        spaceComplexity = frequencies.length;

        for (int number : input) {
            operations++;
            frequencies[number - min]++;
        }

        int outputIndex = 0;

        for (int i = 0; i < frequencies.length; i++) {

            for (int j = 0; j < frequencies[i]; j++) {
                operations++;
                input[outputIndex] = i + min;
                outputIndex++;
            }
        }

    }
}
