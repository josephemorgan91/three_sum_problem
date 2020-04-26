package Test;

import Main.Sum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @Test
    void threeSum() {
        int a[] = {3, 5, 7, 9, 11, 13, 18, 20};
        assertArrayEquals(Sum.threeSum(a, 29), new int[] {7, 9, 13});
    }
}