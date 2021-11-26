package es.ieslavereda.exercises;

import java.util.Scanner;

public class E3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Float height;

        String[][] heights = {
                {"Peter", "1.85"},
                {"John", "1.86"},
                {"Thomas", "1.78"},
                {"Carl", "1.62"},
                {"Lewis", "1.68"},
                {"Michael", "1.65"},
                {"Vanessa", "1.70"},
                {"Anne", "1.69"}
        };

        System.out.println("Person height to search: ");
        height = sc.nextFloat();
        bubble(heights);
        show(heights);
        System.out.println("Recursively: " + recursiveSearch(heights, height));
        System.out.println("Iteratively: " + iterativeSearch(heights, height));

        sc.close();
    }
    // Only for testing
    private static void show(String[][] heights) {
        for (String[] person : heights) {
            for (String data : person)
                System.out.print(data + "\t");
            System.out.println();
        }
    }

    // Sort
    public static void bubble(String[][] array) {
        int i, j;

        for (i = 1; i < array.length; i++) {
            for (j = 0; j < array.length - 1; j++) {
                if (Float.parseFloat(array[j][1]) > Float.parseFloat(array[j + 1][1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(String[][] arreglo, int j, int i) {
        String[] aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }

    // Recursive
    private static String recursiveSearch(String[][] heights, Float height) {
        return binarySearch(heights, 0, heights.length - 1, height);
    }

    private static String binarySearch(String[][] heights, int i, int d, Float height) {

        int m = (d + i) / 2;

        if (Float.parseFloat(heights[m][1]) == height) {
            return heights[m][0];
        } else if (d < i) {
            return "The height \"" + height + "\" hasn't been found.";
        } else if (Float.parseFloat(heights[m][1]) < height)
            return binarySearch(heights, i + 1, d, height);
        else
            return binarySearch(heights, i, d - 1, height);
    }

    // Iterative
    private static String iterativeSearch(String[][] heights, Float height) {

        int pos = 0;

        while (pos < heights.length && Float.parseFloat(heights[pos][1]) < height)
            pos++;

        if (pos >= heights.length)
            return "The height \"" + height + "\" hasn't been found.";
        else
            return heights[pos][0];
    }
}
