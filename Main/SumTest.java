package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @Test
    void threeSum_1() {
        int[] numbers = {};

        assertEquals(null, Sum.threeSum(numbers, 0));
    }

    @Test
    void threeSum_2() {
        assertArrayEquals(new int[]{9, 11, 15}, Sum.threeSum(new int[]{2, 7, 9, 11, 15, 21}, 35));
    }

    @Test
    void threeSum_3() {
        assertArrayEquals(new int[]{3, 3, 3}, Sum.threeSum(new int[]{3, 3, 3}, 9));
    }

    @Test
    void threeSum_4() {
        assertEquals(null, Sum.threeSum(new int[]{3, 3, 3}, 10));
    }

    @Test
    void threeSum_5() {
        assertEquals(null, Sum.threeSum(new int[]{3}, 9));
    }
}