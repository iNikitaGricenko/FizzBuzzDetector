import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzDetectorTest {


    /*  Test-1: Calling method with string from example  */
    @Test
    void STRING_FROM_EXAMPLE() {
        FizzBuzzDetector expected = new FizzBuzzDetector("Mary had a little lamb Little lamb, little lamb " +
            "Mary had a little lamb It's fleece was white as snow");
        assertEquals("Mary had Fizz little Buzz Fizz lamb, little Fizz Buzz had Fizz little lamb " +
                "FizzBuzz fleece was Fizz as Buzz " +
                "\nNumbers of FizzBuzz: 1" +
                "\nNumbers of Fizz: 5" +
                "\nNumbers of Buzz: 3" +
                "\nTotal number of coincidence: 9",
                expected.getOverlappings());
    }

    /*  Test-2: random string from Internet  */
    @Test
    void RANDOM_STRING_FROM_INTERNET() {
        FizzBuzzDetector expected = new FizzBuzzDetector("Contrary to popular belief, Lorem Ipsum is not simply " +
                "random text. It has roots in a piece of");
        assertEquals("Contrary to Fizz belief, Buzz Fizz is not Fizz Buzz text. " +
                "Fizz has roots FizzBuzz a piece Fizz " +
                "\nNumbers of FizzBuzz: 1" +
                "\nNumbers of Fizz: 5" +
                "\nNumbers of Buzz: 2" +
                "\nTotal number of coincidence: 8",
                expected.getOverlappings());
    }

    /*  Test-3: String which only numbers  */
    @Test
    void NumericString() {
        FizzBuzzDetector test4 = new FizzBuzzDetector("00110001 01001110 01010101 01010101 01011000 " +
                "00010100 00101111 01010010 01100011 01100011 00101011");
        assertEquals("00110001 01001110 Fizz 01010101 Buzz Fizz 00101111 01010010 Fizz Buzz 00101011 " +
                "\nNumbers of FizzBuzz: 0" +
                "\nNumbers of Fizz: 3" +
                "\nNumbers of Buzz: 2" +
                "\nTotal number of coincidence: 5",
                test4.getOverlappings());
    }

    /*  Test-4: String which symbols more than 100  */
    @Test
    void BigString() {
        FizzBuzzDetector expected = new FizzBuzzDetector("There are many variations of passages of Lorem Ipsum " +
                "available, but the majority have suffered alteration in some form");
        assertEquals("Size of string is smaller/bigger than recommended. Recommends to use string with " +
                        "length bigger than 7 symbols and lower than 100. If you still want to use your string, " +
                        "try unsafe method getUnsafeOverlapping",
                expected.getOverlappings());
    }

    /*  Test-5: String with null value  */
    @Test
    void NULL_VALUE() {
        FizzBuzzDetector expected = new FizzBuzzDetector(null);
        assertNotNull(expected.getOverlappings());
    }

    /*  Test-8: String with null value on UnsafeMethod  */
    @Test
    void NULL_VALUE_UNSAFE_METHOD() {
        FizzBuzzDetector expected = new FizzBuzzDetector(null);
        assertNotNull(expected.getUnsafeOverlappings());
    }

    /*  Test-7: String with empty value  */
    @Test
    void EMPTY_STRING() {
        FizzBuzzDetector expected  = new FizzBuzzDetector("");
        assertNotNull(expected.getOverlappings());
    }

    /*  Test-8: String with empty value on UnsafeMethod  */
    @Test
    void EMPTY_STRING_WITH_UNSAFE_METHOD() {
        FizzBuzzDetector expected = new FizzBuzzDetector("");
        assertNotNull(expected.getUnsafeOverlappings());
    }
}