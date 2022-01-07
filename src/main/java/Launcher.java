import java.io.IOException;

public class Launcher {
    private static String input = "Mary had a little lamb Little lamb, little lamb Mary had a little " +
            "lamb It's fleece was white as snow";
    private static String input2 = "Mary d";

    public static void main(String[] args) {
        FizzBuzzDetector fizzBuzzDetector = new FizzBuzzDetector(input);
        System.out.println(fizzBuzzDetector.overlap());
        System.out.println(fizzBuzzDetector.getCapacity());
        System.out.println(fizzBuzzDetector.getFizzCounter());
        System.out.println(fizzBuzzDetector.getBuzzCounter());
        System.out.println(fizzBuzzDetector.getFizzBuzzCounter());
        System.out.println(fizzBuzzDetector.getOverlappedString());
        System.out.println(fizzBuzzDetector.getOriginalString());

        fizzBuzzDetector = new FizzBuzzDetector(input2);
        System.out.println(fizzBuzzDetector.overlap());
    }
}
