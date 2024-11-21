```java
class Solution {
    public boolean isValid(int[][] image,int sr,int sc){
        return sr>=0 && sr<image.length && sc>=0 && sc<image[0].length;
    }
    public void Flood(int[][] image,int sr,int sc,int color,int initialColor,int[][]directions){
        if(!isValid(image,sr,sc) || image[sr][sc]==color) return;

        image[sr][sc]=color;

        for(int[] dir:directions){//Move in all adjacent Directions
            int newSr=sr+dir[0];
            int newSc=sc+dir[1];

            if(isValid(image,newSr,newSc) && image[newSr][newSc]==initialColor){
                Flood(image,newSr,newSc,color,initialColor,directions);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][]directions={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };
        int prev=image[sr][sc];

        Flood(image,sr,sc,color,prev,directions);

        return image;
    }
}
```
