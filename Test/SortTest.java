package Test;

import Main.Sort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void mergeSort_1() {
        int[] empty = {};
        int[] emptyCopy = {};
        Sort.MergeSort(empty);
        assertArrayEquals(empty, emptyCopy);
    }

    @Test
    void mergeSort_2() {
        Random rand = new Random();
        int arrayLen;
        for (int i = 0; i < 10000; ++i) {
            arrayLen = rand.nextInt(10000);
            int[] arrayToSort = new int[arrayLen];
            for (int j = 0; j < arrayLen; ++j) {
                arrayToSort[j] = rand.nextInt(1024) - 512;
            }
            int[] arrayCopy = arrayToSort.clone();

            Arrays.sort(arrayCopy);
            Sort.MergeSort(arrayToSort);

            assertArrayEquals(arrayToSort, arrayCopy);
        }
    }
}