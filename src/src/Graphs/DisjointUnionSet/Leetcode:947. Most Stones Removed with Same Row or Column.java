class Solution {
    public int Find(int num,int[]parents){
        if(num==parents[num]) return num;
        return parents[num]=Find(parents[num],parents);
    }
    public void Union(int x,int y,int[]parents){
        int[] rank=new int[parents.length];
        int parentX=Find(x,parents);
        int parentY=Find(y,parents);
        if(parentX==parentY) return;
        if(rank[parentX]>rank[parentY]){
            parents[parentY]=parentX;
        }else if(rank[parentX]<rank[parentY]){
            parents[parentX]=parentY;
        }else{
            parents[parentY]=parentX;
            rank[parentX]++;
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int[] Parents=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            Parents[i]=i;
            rank[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    Union(i,j,Parents);
                }
            }
        }
        int groups=0;
        for(int i=0;i<n;i++){
            if(Parents[i]==i) groups++;
        }
        return n-groups;
    }
}
