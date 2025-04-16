import java.util.Random;
import java.util.Arrays;
import java.io.FileWriter;
/**
 * This program selection sorts an array of random numbers.
 * Author: Alex Kapajika
 * Version: 1.0
 * Since: 2025-03-18
 */
public final class SelectSort {
    /** Defining MAX_SIZE. */
    private static final int MAX_SIZE = 6;
    /** Defining MAX_VALUE. */
    private static final int MAX_VALUE = 100;
    /** Defining MAX_ARRAYS. */
    private static final int MAX_ARRAYS = 100;
    /**
     * Private constructor to prevent instantiation.
     * @throws IllegalStateException Utility class.
     */
    private SelectSort() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * Main method to generate, sort, and write arrays.
     *
     * @param args Unused.
     * @throws Exception IO exception.
     */
    public static void main(final String[] args) throws Exception {
        // Create a file writer to write the arrays to a file
        FileWriter inputFile = new FileWriter("input.txt");
        FileWriter outputFile = new FileWriter("output.txt");
        Random randomGenerator = new Random();
        for (int arrayIndex = 0; arrayIndex < MAX_ARRAYS; arrayIndex++) {
            int[] numberArray = new int[MAX_SIZE];
            for (int elementIndex = 0; elementIndex < MAX_SIZE;
             elementIndex++) {
                int randomNumber = randomGenerator.nextInt(MAX_VALUE);
                numberArray[elementIndex] = randomNumber;
            }
            inputFile.write("Array " + (arrayIndex + 1)
                    + " Unsorted: " + Arrays.toString(numberArray) + "\n\n");
            selectionSort(numberArray);
            outputFile.write("Array " + (arrayIndex + 1)
                    + " Sorted:   " + Arrays.toString(numberArray) + "\n\n");
        }
        inputFile.close();
        outputFile.close();
    }

    /**
     * Sorts an array using the selection sort algorithm.
     *
     * @param arrayToSort The array to be sorted.
     */
    public static void selectionSort(final int[] arrayToSort) {
        int arrayLength = arrayToSort.length;
        // Loop through the array
        for (int counter = 0; counter < arrayLength - 1; counter++) {
            int indexOfMinimum = counter;
            // Find the index of the minimum element in the unsorted array
            for (int comparisonIndex = counter + 1;
             comparisonIndex < arrayLength; comparisonIndex++) {
                if (arrayToSort[comparisonIndex] <
                 arrayToSort[indexOfMinimum]) {
                    indexOfMinimum = comparisonIndex;
                }
            }
            // If the minimum is not the current element, swap them
            // Swap the minimum element found with the current element
            int temporaryValue = arrayToSort[indexOfMinimum];
            arrayToSort[indexOfMinimum] = arrayToSort[counter];
            arrayToSort[counter] = temporaryValue;
        }
    }
}
