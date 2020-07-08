import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {

    @Test
    void longestSequenceTest() {
        Pair<Character, Integer> testPair = new Pair<>('h',3);
        assertEquals(testPair,Sequence.longestSequence("dghhhmhmx"));

        testPair = new Pair<>('a',1);
        assertEquals(testPair,Sequence.longestSequence("A"));
        assertEquals(testPair,Sequence.longestSequence("a"));
        assertEquals(null,Sequence.longestSequence(null));
        assertEquals(null,Sequence.longestSequence(""));

        testPair = new Pair<>('k',3);
        assertEquals(testPair,Sequence.longestSequence("dhkkhhKKKt"));

        testPair = new Pair<>('l',4);
        assertEquals(testPair,Sequence.longestSequence("aAabbaAcccKaBakCkQaMNaLaLlLlqQqqlqqq"));

        testPair = new Pair<>('b',3);
        assertEquals(testPair,Sequence.longestSequence("aBbBadddadd"));
    }

}