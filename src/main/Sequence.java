import javafx.util.Pair;

public class Sequence {


    /**
     * Gets the character with the longest sequence and the length of this sequence
     * The case of the letters is ignored, if more than one letter has the same sequence length
     * the letter with the smallest ascii value is favoured and returned
     *
     * @param str string to be be examined for character sequences
     *
     * @return a pair with the character with the longest sequence number and the length of the longest sequence
     */
    public static Pair<Character,Integer> longestSequence(String str){
        if(str == null || str.length() == 0)
            return null;

        char charArray[] = str.toLowerCase().toCharArray();
        char lastChar = charArray[0];
        Pair<Character, Integer> tuple = new Pair<>(lastChar,1);
        int currentNumber = 0;
        int maxOccurrences = 1;

        for(char c : charArray){
            if(c == lastChar) {
                currentNumber++;
                continue;
            }
            if(currentNumber > maxOccurrences || (currentNumber == maxOccurrences && lastChar < tuple.getKey())){
                maxOccurrences = currentNumber;
                tuple = new Pair<>(lastChar,maxOccurrences);
            }
                lastChar = c;
                currentNumber = 1;
        }
        if(currentNumber > maxOccurrences || (currentNumber == maxOccurrences && lastChar < tuple.getKey()))
            tuple = new Pair<>(lastChar,currentNumber);
        return tuple;
    }

}
