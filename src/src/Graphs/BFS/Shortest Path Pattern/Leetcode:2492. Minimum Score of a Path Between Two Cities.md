You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.
 

Example 1:
![img](https://assets.leetcode.com/uploads/2022/10/12/graph11.png)

Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]

Output: 5

Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.

# BFS on Matrix
```java
class Solution {

    public int minScore(int n, int[][] roads) {
        Map<Integer,List<int[]>>adjList=new HashMap<>();

        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            int dist=road[2];

            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(new int[]{v,dist});

            adjList.putIfAbsent(v,new ArrayList<>());
            adjList.get(v).add(new int[]{u,dist});
        }

        int minVal=Integer.MAX_VALUE;

        Set<Integer>visited=new HashSet<>();

        Queue<int[]>que=new LinkedList<>();
        que.add(new int[]{1,0});

        while(!que.isEmpty()){
            int size=que.size();

            while(size-->0){
                int[] res=que.poll();

                int u=res[0];
                int dist=res[1];


                for(int[] adjNode:adjList.get(u)){
                    int v=adjNode[0];
                    int currDist=adjNode[1];

                    if(!visited.contains(v)){

                        minVal=Math.min(minVal,currDist);
                        que.add(new int[]{v,currDist});
                    }
                }

                visited.add(u);//add the parent to visited at last after all the adjacent nodes are traversed and addes to 
            }
        }

        return minVal;
    }
}
```
