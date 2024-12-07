# Make Objects of the class UnionFind pass the size as paremeter in Constructor and Use it
```java
class UnionFind {
    private int[] Parents;
    private int[] Rank;

    UnionFind(int size) {
        Parents = new int[size];
        for (int i = 0; i < size; i++) {
            Parents[i] = i;
        }
        Rank = new int[size];
        Arrays.fill(Rank, 1);

    }

    public int find(int x) {
        if (x == Parents[x])
            return x;

        return Parents[x] = find(Parents[x]);// Path Compression Technique Basically Memoization
    }

    public void Union(int x, int y) {
        int ParentX = find(x);
        int ParentY = find(y);

        if (ParentX == ParentY)
            return;

        if (Rank[ParentX] > Rank[ParentY]) {
            Parents[ParentY] = ParentX;
        } else if (Rank[ParentX] < Rank[ParentY]) {
            Parents[ParentX] = ParentY;
        } else {
            Parents[ParentY] = ParentX;
            Rank[ParentX]++;
        }
    }
}
```
