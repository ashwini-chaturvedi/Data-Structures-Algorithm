/*Approach:
 1. We cannot use Sliding window because it doesn't follows the WINDOW SHRINK LOGIC which means after some
 certain point we can't Shrik the window size toh make it logically follow the conditions given in question
 


*/

class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();//Map to Store the Occurence of the currState
      //here currState shows the state of the vowel in substring wheather they are present even number of times
      //or odd number of times 
        int[] count = new int[5];//Stores the occurences 
      
        map.put("00000", -1);//00000 state that means all the vowels are in even count that is present at index -1
      
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
          //taking %2 because we want to determine whether they are in even count or odd count
            if (s.charAt(i) == 'a') {
                count[0] = (count[0] + 1) % 2;
            } else if (s.charAt(i) == 'e') {
                count[1] = (count[1] + 1) % 2;
            } else if (s.charAt(i) == 'i') {
                count[2] = (count[2] + 1) % 2;
            } else if (s.charAt(i) == 'o') {
                count[3] = (count[3] + 1) % 2;
            } else if (s.charAt(i) == 'u') {
                count[4] = (count[4] + 1) % 2;
            }

            String currState = "";// curr State of the occurences of the vowels
            for (int j = 0; j < 5; j++) {
                currState += count[j] + "";
            }

            if (map.containsKey(currState)) {//if that state is already present in the map that means we have 
              //once found this state earlier so if we have found it earlier and again we are getting the 
              // same state that means all other states in between previously found and curr index will have same state
                //or even number of vowels or same state
                result = Math.max(result, i - map.get(currState));
            } else {
                map.put(currState, i);
            }

        }
        return result;
    }
}
