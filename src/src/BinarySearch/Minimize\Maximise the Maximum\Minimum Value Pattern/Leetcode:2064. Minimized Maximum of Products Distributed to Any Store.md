```java
class Solution {
    public boolean isPossible(int[] quantities,int mid,int n){
        int curr=0;
        for(int quantity:quantities){
            //agar mid num ko pura divide nhi krrha h but kch quantity bachjaegi toh ussko bhi wahi distributor ko dedenge isiliye 1 plus krenge ki yeh saman pura khtm hogya h 
            //jaise 11 saman ko ham 3 distributor me 3,3,5 krke batenge kyuki 11/3=3 aur jo bcha 2 saman h usko bhi hm isi distributor ko dedenge... 
            if(quantity%mid!=0){
                int div=quantity/mid;
                curr+=div+1;
            }else if(quantity%mid==0){
                int div=quantity/mid;
                curr+=div;
            }
        }
        return curr<=n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int maxx=0;
        for(int quantity:quantities){
            maxx=Math.max(maxx,quantity);
        }

        int low=1;
        int high=maxx;
        int res=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(quantities,mid,n)){
                res=mid;//We will store the current mid and then shorten the value of the mid by moving high towars low to Get MINIMIZED Maximum Value 
                high=mid-1;
            }else{
                low=mid+1; //Increase the Mid to get the maximum possible value...
            }
        }
        return res;
    }
}
```
