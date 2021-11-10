
public class Launcher {
    private static String input = "Mary had a little lamb Little lamb, little lamb Mary had a little lamb It's fleece was white as snow";

    public static void main(String[] args) {
        FizzBuzzDetector fizzBuzzDetector = new FizzBuzzDetector(input);
        System.out.println(fizzBuzzDetector.getOverlappings());
    }
}
