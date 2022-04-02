/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.rgu.cm2100c2p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Francesco Gruosso
 */
public class MainApp {

    public static void main(String[] args) {

        quickSortExperimentalMethod();
        testQuickSort();

        countSortExperimentalMethod();
        testCountSort();

        System.out.println("CSV generated in /");
    }

    // QuickSort experimental method
    public static void quickSortExperimentalMethod() {

        System.out.println("---- Quick Sort ----");

        // Ranges
        int start = 0, end = 300;

        String quickSortOperationsOutput = "n,ops";
        System.out.println("-------------");
        System.out.println("n\tops");

        for (int i = start; i <= end; i++) {
            int[] input = getRandomArray(i);

            QuickSort.sort(input);
            System.out.println(i + "\t" + QuickSort.operations);

            quickSortOperationsOutput += "\n" + i + "," + QuickSort.operations;

        }
        createCSV("QuickSortOperations", quickSortOperationsOutput);

        // Test space complexity
        System.out.println("-------------");
        String quickSortSpaceOutput = "n,space";
        System.out.println("n\tspace");

        for (int i = start; i <= end; i++) {
            int[] input2 = getRandomArray(i);

            QuickSort.sort(input2);
            System.out.println(i + "\t" + QuickSort.spaceComplexity);

            quickSortSpaceOutput += "\n" + i + "," + QuickSort.spaceComplexity;
        }
        createCSV("QuickSortSpace", quickSortSpaceOutput);
    }

    static void testQuickSort() {
        int[] input = getRandomArray(20);

        List<Integer> l = new ArrayList<>();
        Arrays.stream(input).forEach(l::add);

        Collections.sort(l);
        QuickSort.sort(input);

        boolean correct = true;

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != input[i]) {
                correct = false;
                break;
            }
        }

        System.out.println(correct);

    }

    // Test Count Sort
    static void testCountSort() {
        int[] input = getRandomArray(20);

        List<Integer> l = new ArrayList<>();
        Arrays.stream(input).forEach(l::add);

        Collections.sort(l);
        CountSort.sort(input);

        boolean correct = true;

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != input[i]) {
                correct = false;
                break;
            }
        }

        System.out.println(correct);
    }

    // CountSort experimental method
    public static void countSortExperimentalMethod() {
        System.out.println("---- Count Sort ----");

        // Ranges
        int countStart = 0, countEnd = 100;

        String countSortOperationsOutput = "n,ops";
        System.out.println("n\tops");

        for (int i = countStart; i <= countEnd; i++) {
            int[] input = getRandomArray(i);

            CountSort.sort(input);
            System.out.println(i + "\t" + CountSort.operations);

            countSortOperationsOutput += "\n" + i + "," + CountSort.operations;

        }
        createCSV("CountSortOperations", countSortOperationsOutput);

        // Test space complexity
        String countSortSpaceOutput = "n,space";
        System.out.println("n\tspace");

        for (int i = countStart; i <= countEnd; i++) {
            int[] input2 = getRandomArray(i);

            CountSort.sort(input2);

            System.out.println(i + "\t" + CountSort.spaceComplexity);

            countSortSpaceOutput += "\n" + i + "," + CountSort.spaceComplexity;

        }

        createCSV("CountSortSpace", countSortSpaceOutput);

    }

    public static int[] getRandomArray(int size) {
        // Average case array (unsorted)
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 10000);
        }

        return array;
    }

    public static void createCSV(String filename, String data) {
        try ( FileWriter fw = new FileWriter(filename + ".csv");  BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(data);
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
