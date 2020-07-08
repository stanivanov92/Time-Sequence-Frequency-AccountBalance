import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    @Test
    void createIllegallyNewTimeThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> new Time(5,10,-1));
        assertThrows(IllegalArgumentException.class, () -> new Time(-1,10,21));
        assertThrows(IllegalArgumentException.class, () -> new Time(5,-1,5));
    }

    @Test
    void createsTimeObjectTest(){
        assertDoesNotThrow(() -> new Time(23,59,59));
        assertDoesNotThrow(() -> new Time(0,0,0));
        assertDoesNotThrow(() -> new Time(24,60,60));
    }

    @Test
    void timeStringTest() {
        Time time = new Time(3,8,5);
        assertEquals("03:08:05", time.timeString());
        time = new Time(23,58,47);
        assertEquals("23:58:47",time.timeString());
    }

    @Test
    void timeNormaliserTest(){
        Time time = new Time(21,58,205);
        assertEquals("22:01:25",time.timeString());
        time = new Time(23, 128, 500);
        assertEquals("01:16:20", time.timeString());
    }

    @Test
    void scale() {
        final Time time = new Time(15,49,50);
        time.scale(4588);
        assertEquals("17:06:18",time.timeString());
        assertThrows(IllegalArgumentException.class, () -> time.scale(-1));

    }
}