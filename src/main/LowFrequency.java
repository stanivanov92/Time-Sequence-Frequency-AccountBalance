import java.util.*;

public class LowFrequency {

    /**
     * GET the element with the second-lowest frequency of the array
     * if possible, else if more than element have the second lowest
     * frequency, the second lowest value of the elements in this bracket
     * will be returned.
     * If all values are in one frequency bracket, the second lowest integer value
     * will be returned.
     * @param intArray int array to be examined for second lowest frequency
     * @return second lowest frequency element if possible
     */
    public static int secondLowest(int[] intArray){
        if(intArray.length == 0)
            throw new IllegalArgumentException("Array can not be empty");
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        LinkedHashMap<Integer, List<Integer>> frequencySlot = new LinkedHashMap<>();
        frequencySlot.put(1,new ArrayList<>());
        for(int number : intArray) {
            if (null != frequencyMap.putIfAbsent(number, 1)) {
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            }
        }
        int intLowestFrequency = 0;
        int intSecondLowestFrequency = 0;
        HashSet<Integer> lowestFrequency = new HashSet<>();
        HashSet<Integer> secondLowestFrequency = new HashSet<>();
        for(int key : frequencyMap.keySet()){
            int keyValue = frequencyMap.get(key);
            if (keyValue == intLowestFrequency){
                lowestFrequency.add(key);
            }
            if(keyValue == intSecondLowestFrequency) {
                secondLowestFrequency.add(key);
            }
            if(keyValue > intSecondLowestFrequency ){
                if (secondLowestFrequency.size() == 0 || intSecondLowestFrequency == intLowestFrequency){
                    intSecondLowestFrequency = keyValue;
                    secondLowestFrequency.clear();
                    secondLowestFrequency.add(key);
                }
            }
            if (keyValue > intLowestFrequency){
                if(lowestFrequency.size() == 0){
                    intLowestFrequency = keyValue;
                    lowestFrequency.add(key);
                }
            }
            if(keyValue < intLowestFrequency){
                intLowestFrequency = keyValue;
                lowestFrequency.clear();
                lowestFrequency.add(key);
            }
            if(keyValue < intSecondLowestFrequency && keyValue > intLowestFrequency){
                intSecondLowestFrequency = keyValue;
                secondLowestFrequency.clear();
                secondLowestFrequency.add(key);
            }

        }
       int lowestNumber = 0;
       int secondLowestNumber = 0;
       for(int num : secondLowestFrequency){
           if(lowestNumber > num || lowestNumber == 0){
               lowestNumber = num;
           }
           if(secondLowestNumber > num || secondLowestNumber == lowestNumber || secondLowestNumber == 0){
               secondLowestNumber = num;
           }
       }
        return secondLowestNumber;
    }
}
