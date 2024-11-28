```java
class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) { //if the s1's length is greater than s2's length then there is none possible Permutations Present.
            return false;
        }

        //Map:1 To Store the Character Occurence in s1 String.
        Map<Character, Integer> s1Map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        //Only s1.length() characters are to be find so as to make the Permutation and hence the window length will be s1.length().
        int window = s1.length();

        //Map:2 To Store the Character Occurence in s2 String.
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < window; i++) {//For the First window length we will store the character Occurence in the Map and then compare it with the s1's Map.
            char currChar = s2.charAt(i);
            s2Map.put(currChar, s2Map.getOrDefault(currChar, 0) + 1);
        }

        if (s1Map.equals(s2Map)) {//if Both the maps are equal this means that we have found our Permutation because the Frequency of the Characters are same and hence return true;
            return true;
        }

        //For the next windows we will now traverse
        for (int i = window; i < s2.length(); i++) {
            //newChar that has just entered into the Window of fixed length.
            char newChar = s2.charAt(i);
            s2Map.put(newChar, s2Map.getOrDefault(newChar, 0) + 1);

            //oldChar which was at smallest index and is now to be removed so as to maintain the length of the Window.
            char oldChar = s2.charAt(i - window); //Important
//Calculation of the Index whose charater to be removed is done as:Window is of fixed length i.e. window so what ever the increased index be the i-window will keep the index in length or in range of the window length.
//e.g.:if i=2; window=2;index=2-2=0=>Hence, the character at index zero in s2 String is to be removed because we are moving forward in the string and we have to maintain the length of the String.
            if (s2Map.get(oldChar) == 1) {//if only single occurence is there so remove it
                s2Map.remove(oldChar);
            } else {
                s2Map.put(oldChar, s2Map.get(oldChar) - 1);//else decrease the occurence
            }

            //Check if the occurences of the characters are same in both the maps and hence.return true;
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }
}

```
