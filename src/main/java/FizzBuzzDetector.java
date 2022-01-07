public class FizzBuzzDetector {

    public FizzBuzzDetector(String inputString) {
        this.originalString = inputString;
        this.capacity = originalString.length();
    }

    private final String originalString;
    private final int capacity;
    private String overlappedString;
    private int fizzCounter, buzzCounter, fizzBuzzCounter;

    public String getOriginalString() {
        return originalString;
    }

    public String getOverlappedString() {
        return overlappedString;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFizzCounter() {
        return fizzCounter;
    }

    public int getBuzzCounter() {
        return buzzCounter;
    }

    public int getFizzBuzzCounter() {
        return fizzBuzzCounter;
    }

    public String overlap() {

        if (capacity < 7 || capacity > 100) {
            throw new IllegalArgumentException("Size of string is smaller/bigger than recommended." +
                    " Recommends to use string with length bigger than 7 symbols and lower than 100");
        }

        String[] stringSequence = originalString.split(" ");
        char[] charSequence = new char[0];

        for (int i = 0; i < stringSequence.length; i++) {
            charSequence = stringSequence[i].toCharArray();

            if (i % 3 == 2 && i % 5 == 4) {
                this.fizzBuzzCounter++;
                stringSequence[i] = String.valueOf(replaceWord(charSequence, "FizzBuzz"));
            } else if (i % 3 == 2 ) {
                this.fizzCounter++;
                stringSequence[i] = String.valueOf(replaceWord(charSequence, "Fizz"));
            } else if (i % 5 == 4 ) {
                this.buzzCounter++;
                stringSequence[i] = String.valueOf(replaceWord(charSequence, "Buzz"));
            }

            if (i+1 != stringSequence.length) {
                stringSequence[i] += " ";
            }
        }

        this.overlappedString = "";
        for (String element:stringSequence) {
            this.overlappedString += element;
        }

        return getOverlappedString();
    }

    private char[] replaceWord(char[] charSequence, String word) {

        char[] wordSequence = word.toCharArray();
        char[] cloneCharSequence = charSequence;

        for (int i = 0; i < charSequence.length ; i++) {
            cloneCharSequence = resizeSequenceTo(charSequence, wordSequence.length);
            charSequence = cloneCharSequence;

            if (charSequence[i] > 0x2F || cloneCharSequence[i] == 0x00) {
                cloneCharSequence[i] = wordSequence[i];
            } else {
                cloneCharSequence[i] = charSequence[i];
            }
        }

        return cloneCharSequence;
    }

    private char[] resizeSequenceTo(char[] charSequence, int iterator) {

        char[] clone = new char[iterator];

        if (iterator >= charSequence.length) {
            iterator = charSequence.length;
        }

        for (int j = 0; j < iterator; j++) {
            clone[j] = charSequence[j];
        }

        return clone;
    }

}
