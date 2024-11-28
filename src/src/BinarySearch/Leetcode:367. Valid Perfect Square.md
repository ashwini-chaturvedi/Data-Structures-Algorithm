# Must do Dry Run
```java
class Solution {
    public boolean isPerfectSquare(int num) {
        //Applying Binary Search
        long low=0;
        long high=num;
        while(low<=high){
            long mid=(high+low)/2;
            if(mid*mid==num){
                return true;
            }else if(mid*mid<num){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}
```
