import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void balance() {
        assertEquals(10201.00,Account.balance(10000, 1, 20000, 1, 2),0.1);
        assertEquals(25904.50,Account.balance(25000, 2, 20000, 1, 2),0.1);
        assertEquals(20597.96,Account.balance(19800, 2, 20000, 1, 2),0.1);
        assertThrows(IllegalArgumentException.class,() -> Account.balance(-1,2,20000,1,5));
        assertThrows(IllegalArgumentException.class,() -> Account.balance(250,2,20000,1,-1));
        assertThrows(IllegalArgumentException.class,() -> Account.balance(250,2,-1,1,1));
    }
}