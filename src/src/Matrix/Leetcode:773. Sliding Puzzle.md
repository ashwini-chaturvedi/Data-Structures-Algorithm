# Approach:

1.States are changing

2.You have given Starting State(Source):board

3.You have Ending State (target):[[1,2,3],[4,5,0]]

4.State changes per level/move

5.We are Dealing with levels for changing state

6.We have to find the nearest level/Minimum moves=Shortest path

7.Since Edges don't have weights so Disregard Dijkstra Algorithm

8.Simple BFS will give the shortest path.

9.But How to perform BFS on whole Matrix?

    To Perform BFS we would not add Whole Matrix into the Queue but we will cleverly change the Matrix to a String in that way it would be efficient to do BFS on String
    
10.How to Find the Adjacent Elements and Index to which zero is to be swapped?

    For that we will manually find the swapping positions of zero when zero is at different-different Indexes.we will make a Map of it when zero is at which index and can be swapped with which Indexes elements.

  ## Index of Zero  ->  Indexes it can Perform Swap.
        0          ->    { 1, 3 }
        1          ->    { 0, 2, 4 }
        2          ->    { 1, 5 }
        3          ->    { 0, 4 }
        4          ->    { 1, 3, 5 }
        5          ->    { 4, 2 } 
```java
class Solution {

    public int slidingPuzzle(int[][] board) {
        Map<Integer, int[]> swapZero = new HashMap<>();
        //These All Mappings are done for the Possible Indexes(value) where zero can swap its location when it is on the particular indexes (key) in the String Representation
        //Key-Value Pair for Map=Indexes of Zero(key)--Indexes it can perform swap(value)
        swapZero.put(0, new int[] { 1, 3 });
        swapZero.put(1, new int[] { 0, 2, 4 });
        swapZero.put(2, new int[] { 1, 5 });
        swapZero.put(3, new int[] { 0, 4 });
        swapZero.put(4, new int[] { 1, 3, 5 });
        swapZero.put(5, new int[] { 4, 2 });

        //Convert the board to String which is "source"
        StringBuilder source = new StringBuilder();
        for (int[] row : board) {
            for (int col : row) {
                source.append(col);
            }
        }
        String target = "123450";//Given the Final State which is target

        if (source.toString().equals(target)) {
            return 0;//if source is equal to target already return 0 moves
        }

        int moves = 0;

        //BFS
        Set<String>visited=new HashSet<>();
        Queue<String> que = new LinkedList<>();

        que.add(source.toString());
        visited.add(source.toString());


        while (!que.isEmpty()) {
            int size = que.size();
            moves++;

            for (int i = 0; i < size; i++) {
                String currState = que.poll();
                int zeroIndex = currState.indexOf('0');//Index of the character zero

                for (int swapIdx : swapZero.get(zeroIndex)) {
                    
                    String nextState=swap(currState,zeroIndex,swapIdx);//new State of the String after Swap

                    if(nextState.equals(target)) return moves;//Found the target

                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        que.add(nextState);
                    }
                }
            }
        }
        return -1;
    }
    public String swap(String s,int i,int j){
        char[] charArray=s.toCharArray();

        char temp=charArray[i];
        charArray[i]=charArray[j];
        charArray[j]=temp;

        return new String(charArray);
    }
}
```
