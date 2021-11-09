import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzDetectorTest {


    @Test
    void getOverlappings() {

        Logger logger = Logger.getLogger(String.valueOf(FizzBuzzDetector.class));

        /*  Test-1: Calling method with string from example  */
        FizzBuzzDetector test1 = new FizzBuzzDetector("Mary had a little lamb Little lamb, little lamb " +
            "Mary had a little lamb It's fleece was white as snow");
        assertEquals("Mary had Fizz little Buzz Fizz lamb, little Fizz Buzz had Fizz little lamb " +
                "FizzBuzz fleece was Fizz as Buzz " +
                "\nNumbers of FizzBuzz: 1" +
                "\nNumbers of Fizz: 5" +
                "\nNumbers of Buzz: 3" +
                "\nTotal number of coincidence: 9",
                test1.getOverlappings());

        /*  Test-2: random string from Internet  */
        FizzBuzzDetector test2 = new FizzBuzzDetector("Contrary to popular belief, Lorem Ipsum is not simply " +
                "random text. It has roots in a piece of");
        assertEquals("Contrary to Fizz belief, Buzz Fizz is not Fizz Buzz text. " +
                "Fizz has roots FizzBuzz a piece Fizz " +
                "\nNumbers of FizzBuzz: 1" +
                "\nNumbers of Fizz: 5" +
                "\nNumbers of Buzz: 2" +
                "\nTotal number of coincidence: 8",
                test2.getOverlappings());

        /*  Test-3: String which contains symbols and numbers  */
        FizzBuzzDetector test3 = new FizzBuzzDetector("Lorem Ipsum is simply dummy text of the printing. " +
                "Lorem Ipsum has been the industry's standard 1500s");
        assertEquals("Lorem Ipsum Fizz simply Buzz Fizz of the Fizz. Buzz Ipsum Fizz been the FizzBuzz standard 1500s " +
                "\nNumbers of FizzBuzz: 1" +
                "\nNumbers of Fizz: 4" +
                "\nNumbers of Buzz: 2" +
                "\nTotal number of coincidence: 7",
                test3.getOverlappings());

        /*  Test-4: String which only numbers  */
        FizzBuzzDetector test4 = new FizzBuzzDetector("00110001 01001110 01010101 01010101 01011000 " +
                "00010100 00101111 01010010 01100011 01100011 00101011");
        assertEquals("00110001 01001110 Fizz 01010101 Buzz Fizz 00101111 01010010 Fizz Buzz 00101011 " +
                "\nNumbers of FizzBuzz: 0" +
                "\nNumbers of Fizz: 3" +
                "\nNumbers of Buzz: 2" +
                "\nTotal number of coincidence: 5",
                test4.getOverlappings());

        /*  Test-5: String which symbols more than 100  */
        FizzBuzzDetector test5 = new FizzBuzzDetector("There are many variations of passages of Lorem Ipsum " +
                "available, but the majority have suffered alteration in some form");
        assertEquals("Size of string is smaller/bigger than recommended. Recommends to use string with " +
                        "length bigger than 7 symbols and lower than 100. If you still want to use your string, " +
                        "try unsafe method getUnsafeOverlapping",
                test5.getOverlappings());

        FizzBuzzDetector emptyTest = new FizzBuzzDetector("");
        assertNotNull(emptyTest);

        /*  Test-6: Trying to overlap empty string  */
        try {
            assertEquals("String is empty", emptyTest.getUnsafeOverlappings());
            fail("Method didn't throw exception when I expected it to");
        } catch (NullPointerException nullPointerException) {
            logger.warning(nullPointerException.getMessage());
        }

        /*  Test-6: Trying to overlap string with null value  */
        try {
            emptyTest = new FizzBuzzDetector(null);
            fail("Method didn't throw exception when I expected it to");
        } catch (NullPointerException nullPointerException) {
            logger.warning(nullPointerException.getMessage());
        }
    }
}