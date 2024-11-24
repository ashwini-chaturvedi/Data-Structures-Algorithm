```java
class Solution {
    //we have to find the shortest/minimum cost to convert the characters of string source so that it can become equal to string target
    //if we use Dijkstra we have to call it for every character which is not equal in source.that increases the time complexity 
    //we want a way to get the shortest distance in O(1) time 
    //for this we would use Floyd-Warshall technique and retrieve the shortest/minimum cost path in O(1) time...
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] costs) {
        
        int[][] grid=new int[26][26];//only Lower Case letters are there 

        for(int i=0;i<26;i++){
            Arrays.fill(grid[i],Integer.MAX_VALUE);//Store Every other path as Infinity
            grid[i][i]=0;//Source to Source 
        }

        for(int i=0;i<costs.length;i++){
            char org=original[i];
            char cha=changed[i];
            int cost=costs[i];

            grid[org-'a'][cha-'a']=Math.min(grid[org-'a'][cha-'a'],cost); //Store the Minimum possible cost because for bigger entries or duplicate entries this can be changed so minimum value;
        }

        //Floyd-Warshall Algorithm...
        int n=grid.length;
        for(int via=0;via<n;via++){
            for(int u=0;u<n;u++){
                for(int v=0;v<n;v++){
                    if(grid[u][via]!=Integer.MAX_VALUE && grid[via][v]!=Integer.MAX_VALUE){
                        grid[u][v]=Math.min(grid[u][v],(grid[u][via]+grid[via][v]));
                    }
                }
            }
        }
        
        //Now grid will have the shortest or least cost to make changes from a character in original string to the character in changed
         long minCost = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
               int u = source.charAt(i) - 'a';
                int v = target.charAt(i) - 'a';
                if (grid[u][v] == Integer.MAX_VALUE) return -1;
                minCost += grid[u][v];
            }
        }
        return minCost;
    }
}
```
