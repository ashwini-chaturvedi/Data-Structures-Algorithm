```java

class Solution {
    public int BinarySearch(int[] arr,int target,boolean isFirst){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        
        while(low<=high){
           int mid=low+(high-low)/2;
           
           if(arr[mid]==target){
               ans= mid;
               if(isFirst){
                   high=mid-1;
               }else{
                   low=mid+1;
               }
           }else if(arr[mid]<target){
               low=mid+1;
           }else{
               high=mid-1;
           }
       }
       return ans;
    }
    int countFreq(int[] arr, int target) {
        int first=BinarySearch(arr,target,true);
        if(first==-1) return 0;
        int last=BinarySearch(arr,target,false);
        
       return last-first+1;//size of the window in b/w the first Occurence and Last Occurence is equal to count of the Element 
       //count of Element=first Occurence-last Occurence+1;
    }
}

```
