// Approach: We will make a Union of the nodes or stones having common row or column after the union process
             there should be distinct groups means that those groups will remain that
             dont have any thing common neither row nor column so these stones cannot be removed and 
             hence they will remain in the plain later to find the no. of stones removes we minus the 
             remaining stones with total stones 
    
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
        int totalStones=stones.length;
        int[] Parents=new int[totalStones];
        int[] rank=new int[totalStones];

        for(int i=0;i<totalStones;i++){
            Parents[i]=i;
            rank[i]=1;
        }

        for(int i=0;i<totalStones;i++){
            for(int j=i+1;j<totalStones;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){//if any row or column is common
                    Union(i,j,Parents);
                }
            }
        }
        int groups=0; //no. of groups are equal to the remaining stones 
        for(int i=0;i<totalStones;i++){
            if(Parents[i]==i) groups++;
        }
        return totalStones-groups;
    }
}
