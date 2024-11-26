```java
public class DSUBasics {
    public int find(int x, int[] Parents) {
        if (x == Parents[x]) return x;

        return Parents[x] = find(Parents[x], Parents);//Path Compression Technique Basically Memoization
    }

    public void Union(int x, int y, int[] Parents, int[] Rank) {
        int ParentX = find(x, Parents);
        int ParentY = find(y, Parents);

        if (ParentX == ParentY) return;

        if (Rank[ParentX] > Rank[ParentY]) {
            Parents[ParentY] = ParentX;
        } else if (Rank[ParentX] < Rank[ParentY]) {
            Parents[ParentX] = ParentY;
        } else {
            Parents[ParentY] = ParentX;
            Rank[ParentX]++;
        }
    }
    public static void main(String[] args) {
      int n=${};//Add the Size
      int[] Parents = new int[accounts.size()];
      int[] Rank = new int[accounts.size()]; // Initially all have Rank Zero

 // Initialize the Union-Find data structure
      for (int i = 0; i < accounts.size(); i++) {
          Parents[i] = i; // Parent of itself
      }
 
    }
}
```
