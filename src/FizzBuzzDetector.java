public class FizzBuzzDetector {

    private String InputString;

    /// Is variables for counting matches of Fizz, Bizz and FizzBuzz words
    private int FizzCounter     =    0,
            BuzzCounter         =    0,
            FizzBuzzCounter     =    0;

    /*
    *   Constructor with one required parameter - "String" - which will use for overlapping
    *   WARNING: If String will be equals null - constructor will throw NullPointerException.
    *  This is implemented in order to protect the programmer
    */
    public FizzBuzzDetector(String InputString) {
        if (InputString == null) {
            throw new NullPointerException("String cannot be null");
        }
        this.InputString = InputString;
    }

    /*
    *
    * This is safe method which checking if string length have required size,
    * if yes - string will be overlapping in 'Overlapping' method, else will be throw exception
    *
    */
    public String getOverlappings() {
        try {
            if (InputString.length() < 7 || InputString.length() > 100) {
                throw new NullPointerException("Size of string is smaller/bigger than recommended." +
                        " Recommends to use string with length bigger than 7 symbols and lower than 100." +
                        " If you still want to use your string, try unsafe method getUnsafeOverlapping");
            }
            InputString = Overlapping(InputString);
        } catch (NullPointerException nullPointerException) {
            return nullPointerException.getMessage();
        }
        return InputString +
                "\nNumbers of FizzBuzz: " + FizzBuzzCounter +
                "\nNumbers of Fizz: " + FizzCounter +
                "\nNumbers of Buzz: " + BuzzCounter +
                "\nTotal number of coincidence: " + (FizzBuzzCounter + FizzCounter + BuzzCounter);
    }

    /*
    *
    * This is unsafe method which checking if string length isn`t empty,
    * if yes - string will be overlapping in 'Overlapping' method, else will be throw exception
    *
    */
    public String getUnsafeOverlappings() throws NullPointerException {
        if (InputString.length() == 0) {
            throw new NullPointerException("String is empty");
        }
        InputString = Overlapping(InputString);
        return InputString +
                "\nNumbers of FizzBuzz: " + FizzBuzzCounter +
                "\nNumbers of Fizz: " + FizzCounter +
                "\nNumbers of Buzz: " + BuzzCounter +
                "\nTotal number of coincidence: " + (FizzBuzzCounter + FizzCounter + BuzzCounter);
    }

    /*
    *
    *   This overlapping realization method, with required String parameter, which will be overlapping,
    *  by splitting to array of words, and in loop will check every third and fifth words, and replacing to
    *  words such as Fizz (every third), Buzz(every fifth), or both - FizzBuzz, when word fits both conditions.
    *   After that all array will be merged to single string and return string.
    *
    */
    private String Overlapping(String input) {
        String[] tempArray = input.split(" ");
        input = "";
        for (int i = 0; i < tempArray.length ; i++) {
            String Fizz = "Fizz"; // string which will replace a default string value to Fizz
            String Buzz = "Buzz"; // string which will replace a default string value to Buzz
            if (i % 3 == 2 && i % 5 == 4) {
                Buzz += check(tempArray[i]); // adding a symbol into end of string
                tempArray[i] = Fizz+Buzz;
                FizzBuzzCounter++;
            }
            else if (i % 3 == 2 ) {
                Fizz += check(tempArray[i]); // adding a symbol into end of string
                tempArray[i] = Fizz;
                FizzCounter++;
            }
            else if (i % 5 == 4 ) {
                Buzz += check(tempArray[i]); // adding a symbol into end of string
                tempArray[i] = Buzz;
                BuzzCounter++;
            }
            input += tempArray[i] + " ";
        }
        return input;
    }

    /*
    *
    *   This method with one required string parameter - which will check for the contains of symbols.
    *   If check is true, then method return a containing symbol, else returns empty string
    *
    */
    private String check(String str) {
        String[] symb = {
                ".",",","!","#","$",
                "%","&","(",")","*",
                "+",",","-",".",":",
                ";","<=",">","?","@",
                "[","\\","]","^","_",
                "`","{","|","}","~"
        };
        for (int i = 0; i < symb.length ; i++) {
            if (str.contains(symb[i])) {
                return symb[i];
            }
        }
        return "";
    }

}
