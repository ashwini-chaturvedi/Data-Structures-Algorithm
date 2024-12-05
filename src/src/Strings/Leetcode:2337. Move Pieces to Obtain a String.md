```java
class Solution {

    public boolean canChange(String start, String target) {
        int n = start.length();

        int i = 0;
        int j = 0;

        while (i < n || j < n) {
            //Skip the underscores
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            //Reached the End of the String
            if (i == n || j == n) return i== n && j== n;//return if both pointers on both of the Strings have reached End. 

            if (start.charAt(i) != target.charAt(j)) return false;//if characters don't match which means either 'R' or 'L' is appeared before 'L' or 'R'.

            if (start.charAt(i) == 'L' && i < j) return false;//'L' cannot come after 'R'
            if (start.charAt(i) == 'R' && i > j) return false;//'R' cannot come before 'L'

            //Move the Pointers simultaneously...
            i++;
            j++;
        }
        return true;
    }
}

```
