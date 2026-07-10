You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.

You are also given an integer array nums of length n sorted in non-decreasing order, and an integer maxDiff.

An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).

You are also given a 2D integer array queries. For each queries[i] = [ui, vi], determine whether there exists a path between nodes ui and vi.

Return a boolean array answer, where answer[i] is true if there exists a path between ui and vi in the ith query and false otherwise.


Example :

Input: n = 4, nums = [2,5,6,8], maxDiff = 2, queries = [[0,1],[0,2],[1,3],[2,3]]

Output: [false,false,true,true]

Explanation:

The resulting graph is:

![img](https://assets.leetcode.com/uploads/2025/03/25/screenshot-2025-03-26-at-122249.png)

Query [0,1]: There is no edge between Node 0 and Node 1 because |nums[0] - nums[1]| = |2 - 5| = 3, which is greater than maxDiff.

Query [0,2]: There is no edge between Node 0 and Node 2 because |nums[0] - nums[2]| = |2 - 6| = 4, which is greater than maxDiff.

Query [1,3]: There is a path between Node 1 and Node 3 through Node 2 since |nums[1] - nums[2]| = |5 - 6| = 1 and |nums[2] - nums[3]| = |6 - 8| = 2, both of which are within maxDiff.

Query [2,3]: There is an edge between Node 2 and Node 3 because |nums[2] - nums[3]| = |6 - 8| = 2, which is equal to maxDiff.

Thus, the final answer after processing all the queries is [false, false, true, true].

```java
//Saw the Topics tag to know about UNION FIND approach.
class DSU{
    int[] Parents;
    int[] Rank;

    DSU(int n){
        Parents=new int[n];
        for(int i=0;i<n;i++){
            Parents[i]=i;
        }

        Rank=new int[n];
        Arrays.fill(Rank,1);
    }

    public int find(int x){
        if(x==Parents[x]){
            return x;
        }

        return Parents[x]=find(Parents[x]);
    }

    public void union(int x,int y){
        int ParentX=find(x);
        int ParentY=find(y);

        if(Rank[ParentX]>Rank[ParentY]){
            Parents[ParentY]=ParentX;
        }else if(Rank[ParentX]<Rank[ParentY]){
            Parents[ParentX]=ParentY;
        }else{
            Parents[ParentY]=ParentX;
            Rank[ParentX]+=1;
        }
    }

}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu=new DSU(n);
        for(int i=0;i<nums.length-1;i++){
            int abs=Math.abs(nums[i]-nums[i+1]);

            if(abs<=maxDiff){
                dsu.union(i,i+1);
            }
        }

        boolean[] res=new boolean[queries.length];
        int i=0;

        for(int[] query:queries){
            int u=query[0];
            int v=query[1];

            int parentU=dsu.find(u);
            int parentV=dsu.find(v);

            if(parentU==parentV){
                res[i++]=true;
            }else{
                res[i++]=false;
            }
        }

        return res;
    }
}
```
