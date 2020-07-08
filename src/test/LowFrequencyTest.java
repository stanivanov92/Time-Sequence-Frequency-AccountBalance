import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowFrequencyTest {

    @Test
    void secondLowest() {
        int testArray[] = {4, 3, 1, 1, 2};
        assertEquals(1,LowFrequency.secondLowest(testArray));

        int testArray2[] = {4, 3, 1, 1, 2, 2};
        assertEquals(2,LowFrequency.secondLowest(testArray2));

        int testArray3[] = {4, 3, 1, 2};
        assertEquals(2,LowFrequency.secondLowest(testArray3));

        int testArray4[] = {4,5,3,8,8,8,3,2,1,1,3, 3, 1, 2};
        assertEquals(8,LowFrequency.secondLowest(testArray4));

    }
}