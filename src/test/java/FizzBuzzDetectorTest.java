import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzDetectorTest {

    private FizzBuzzDetector fizzBuzzDetector;
    private final String initialString = "Mary had a little lamb Little lamb, little lamb Mary had a little " +
            "lamb It's fleece was white as snow";
    private final String overlappedString = "Mary had Fizz little Buzz Fizz lamb, little Fizz Buzz had Fizz little " +
            "lamb Fi'zBuzz fleece was Fizz as Buzz";

    private final int capacity = 100;
    private final int fizzCounter = 5,
            buzzCounter = 3,
            fizzBuzzCounter = 1;

    @Before
    public void setUp() throws Exception {
        fizzBuzzDetector = new FizzBuzzDetector(initialString);
        fizzBuzzDetector.overlap();
    }

    @Test
    public void overlap() {
        assertEquals(overlappedString, fizzBuzzDetector.overlap());
    }

    @Test
    public void getOriginalString() {
        assertSame(initialString,fizzBuzzDetector.getOriginalString());
        assertNotSame(overlappedString,fizzBuzzDetector.getOverlappedString());
    }

    @Test
    public void getOverlappedString() {
        assertEquals(overlappedString,fizzBuzzDetector.getOverlappedString());
        assertNotSame(initialString,fizzBuzzDetector.getOverlappedString());
    }

    @Test
    public void getCapacity() {
        assertEquals(capacity,fizzBuzzDetector.getCapacity());
        assertNotEquals(0,fizzBuzzDetector.getCapacity());
    }

    @Test
    public void getFizzCounter() {
        assertEquals(fizzCounter,fizzBuzzDetector.getFizzCounter());
        assertNotEquals(0,fizzBuzzDetector.getFizzCounter());
    }

    @Test
    public void getBuzzCounter() {
        assertEquals(buzzCounter,fizzBuzzDetector.getBuzzCounter());
        assertNotEquals(0,fizzBuzzDetector.getBuzzCounter());
    }

    @Test
    public void getFizzBuzzCounter() {
        assertEquals(fizzBuzzCounter,fizzBuzzDetector.getFizzBuzzCounter());
        assertNotEquals(0,fizzBuzzDetector.getFizzBuzzCounter());
    }
}