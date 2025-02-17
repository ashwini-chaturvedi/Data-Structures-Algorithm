You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1

```java
class Solution {

    public void solve(String tiles, StringBuilder sb, Set<String> res,boolean[] used) {

        res.add(sb.toString());//insert the current arrangement

        for (int i = 0; i < tiles.length(); i++) {//always start from i==0

            if(used[i]) continue;//if we have used the character at i for this branch of the Recursive tree move to the next character.

            used[i]=true;//mark it true
            sb.append(tiles.charAt(i));

            solve(tiles, sb, res,used);

            //Backtrack.
            sb.deleteCharAt(sb.length() - 1);
            used[i]=false;
        }
    }

    public int numTilePossibilities(String tiles) {
        StringBuilder sb = new StringBuilder();
        Set<String>res=new HashSet<>();//so that the Arrangements are Unique.
        boolean[] used = new boolean[tiles.length()];//to mark the visited characters.

        solve(tiles, sb, res,used);

        return res.size()-1;//to remove the count of Empty Substring that will initially get pushed into the Set.
    }
}

```
