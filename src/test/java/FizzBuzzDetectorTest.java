import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class FizzBuzzDetectorTest {

    private String actualString, expectedString;

    public FizzBuzzDetectorTest(String actualString, String expectedString)
    {
        this.actualString = actualString;
        this.expectedString = expectedString;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data() {
        String[][] data = new String[][] {
                {
                    "Mary had a little lamb Little lamb, little lamb " +
            "Mary had a little lamb It's fleece was white as snow",
                        "Mary had Fizz little Buzz Fizz lamb, little Fizz Buzz had Fizz little lamb " +
                "FizzBuzz fleece was Fizz as Buzz " +
                "\nNumbers of FizzBuzz: 1" +
                "\nNumbers of Fizz: 5" +
                "\nNumbers of Buzz: 3" +
                "\nTotal number of coincidence: 9"
                },
                {
                    "00110001 01001110 01010101 01010101 01011000 " +
                "00010100 00101111 01010010 01100011 01100011 00101011",
                        "00110001 01001110 Fizz 01010101 Buzz Fizz 00101111 01010010 Fizz Buzz 00101011 " +
                "\nNumbers of FizzBuzz: 0"+
                "\nNumbers of Fizz: 3"+
                "\nNumbers of Buzz: 2"+
                "\nTotal number of coincidence: 5"
                },
                {
                    "Contrary to popular belief, Lorem Ipsum is not simply " +
                "random text. It has roots in a piece of",
                        "Contrary to Fizz belief, Buzz Fizz is not Fizz Buzz text. Fizz has roots FizzBuzz a piece Fizz "+
                "\nNumbers of FizzBuzz: 1" +
                "\nNumbers of Fizz: 5" +
                "\nNumbers of Buzz: 2" +
                "\nTotal number of coincidence: 8"
                },
                {
                    null,
                        "Size of string is smaller/bigger than recommended." +
                    " Recommends to use string with length bigger than 7 symbols and lower than 100." +
                    " If you still want to use your string, try unsafe method getUnsafeOverlapping"
                },
                {
                    "",
                        "Size of string is smaller/bigger than recommended." +
                    " Recommends to use string with length bigger than 7 symbols and lower than 100." +
                    " If you still want to use your string, try unsafe method getUnsafeOverlapping"
                }
        };
        return Arrays.asList(data);
    }

    /*  Test-1: Calling getOverlappings method */
    @Test
    public void getOverlappings() {
        FizzBuzzDetector expected = new FizzBuzzDetector(actualString);
        Assertions.assertEquals(expectedString, expected.getOverlappings());
    }


    /*  Test-2: Checking for null with getOverlappings */
    @Test
    public void NULL_VALUE() {
        FizzBuzzDetector expected = new FizzBuzzDetector(expectedString);
        Assertions.assertNotNull(expected.getOverlappings());
    }

    /*  Test-3: Checking for null with getUnsafeOverlappings */
    @Test
    public void Unsafe_Method_NULL_VALUE() {
        FizzBuzzDetector expected = new FizzBuzzDetector(expectedString);
        Assertions.assertNotNull(expected.getUnsafeOverlappings());
    }
}