# Maximize the Minimum value Problem

```java
class Solution {
    public boolean possibleToPlace(int[]position,int minForce,int numOfBalls){
        int prevBall=position[0];
        int countBalls=1;
        for(int i=1;i<position.length;i++){
            int currBall=position[i];

            if(currBall-prevBall>=minForce){
                prevBall=currBall;
                countBalls++;
            }
            if(countBalls==numOfBalls){
                break;
            }
        }
        return countBalls==numOfBalls;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int high=position[position.length-1];
        int low=1;
        int minForce=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possibleToPlace(position,mid,m)){

                minForce=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
           
        }
        return minForce;
    }
}
```
