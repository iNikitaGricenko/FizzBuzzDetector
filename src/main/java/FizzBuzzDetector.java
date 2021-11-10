public class FizzBuzzDetector {

    /// It is String variable with that class works and overlap it
    private String overlapString;

    /// Is variables for counting matches of fizz, bizz and fizzBuzz words
    private int fizzCounter     =    0,
            buzzCounter         =    0,
            fizzBuzzCounter     =    0;

    /*
    *
    *   Constructor with one required parameter - "String" - which will use for overlapping
    *   If String will be equals null - constructor will insert empty value.
    *  This is implemented in order to protect the programmer
    *
    */
    public FizzBuzzDetector(String inputString) {
        this.overlapString = inputString != null ? inputString : "";
    }

    /*
    *
    * This is safe method which checking if string length have required size,
    * if yes - string will be overlapping in 'overlap()' method, else will be return message
    *  which says what string is does not fit the condition
    *
    */
    public String getOverlappings() {
        if (overlapString.length() < 7 || overlapString.length() > 100) {
            return "Size of string is smaller/bigger than recommended." +
                    " Recommends to use string with length bigger than 7 symbols and lower than 100." +
                    " If you still want to use your string, try unsafe method getUnsafeOverlapping";
        }
        overlapString = overlap(overlapString);
        return overlapString +
                "\nNumbers of FizzBuzz: " + fizzBuzzCounter +
                "\nNumbers of Fizz: " + fizzCounter +
                "\nNumbers of Buzz: " + buzzCounter +
                "\nTotal number of coincidence: " + (fizzBuzzCounter + fizzCounter + buzzCounter);
    }

    /*
    *
    * This is unsafe method which checking if string length isn`t empty,
    * if yes - string will be overlapping in 'overlap()' method, else will return empty value
    *
    */
    public String getUnsafeOverlappings() {
        if (overlapString.length() == 0) {
            return "";
        }
        overlapString = overlap(overlapString);
        return overlapString +
                "\nNumbers of FizzBuzz: " + fizzBuzzCounter +
                "\nNumbers of Fizz: " + fizzCounter +
                "\nNumbers of Buzz: " + buzzCounter +
                "\nTotal number of coincidence: " + (fizzBuzzCounter + fizzCounter + buzzCounter);
    }

    /*
    *
    *   This overlapping realization method, with required String parameter, which will be overlapping,
    *  by splitting to array of words, and in loop will check every third and fifth words, and replacing to
    *  words such as Fizz (every third), Buzz(every fifth), or both - FizzBuzz, when word fits both conditions.
    *   After that all array will be merged to single string and return string.
    *
    */
    private String overlap(String input) {
        String[] array = input.split(" ");
        input = "";
        for (int i = 0; i < array.length ; i++) {
            String fizz = "Fizz"; // string which will replace a default string value to Fizz
            String buzz = "Buzz"; // string which will replace a default string value to Buzz
            if (i % 3 == 2 && i % 5 == 4) {
                buzz += check(array[i]); // adding a symbol into end of string
                array[i] = fizz+buzz;
                fizzBuzzCounter++;
            } else if (i % 3 == 2 ) {
                fizz += check(array[i]); // adding a symbol into end of string
                array[i] = fizz;
                fizzCounter++;
            } else if (i % 5 == 4 ) {
                buzz += check(array[i]); // adding a symbol into end of string
                array[i] = buzz;
                buzzCounter++;
            }
            input += array[i] + " ";
        }
        return input;
    }

    /*
    *
    *   This method with one required string parameter - which will check for the contains of symbols.
    *   If check is true, then method return a containing symbol, else returns empty string
    *
    */
    private String check(String string) {
        String[] symbols = {
                ".",",","!","#","$",
                "%","&","(",")","*",
                "+",",","-",".",":",
                ";","<=",">","?","@",
                "[","\\","]","^","_",
                "`","{","|","}","~"
        };
        for (int i = 0; i < symbols.length ; i++) {
            if (string.contains(symbols[i])) {
                return symbols[i];
            }
        }
        return "";
    }

}
