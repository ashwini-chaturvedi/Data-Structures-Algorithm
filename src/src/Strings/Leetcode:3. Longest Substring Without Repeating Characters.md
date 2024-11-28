```java
class Solution {

    public int lengthOfLongestSubstring(String s) { 

        int len = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();// Using Set for checking of repeating characters
        // Modified Sliding Window
        while (j < s.length()) {
            // if duplicate element is found in the Set then move i and remove the character
            // from the set untill the duplicate Element is Removed

            while (i <= j && set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;//Slide the Window
            }

            set.add(s.charAt(j));//Add the Element into the Set
            len = Math.max(len, (j - i + 1));
            j++;//Increase the size of the window.
        }
        return len;
    }
}

```
