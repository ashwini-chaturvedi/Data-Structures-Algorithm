
```java
class Solution {
    public int binarySearch(int[] arr,int target,boolean isFirst){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(arr[mid]==target){
                ans=mid;
                if(isFirst){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
        
    }
    int countFreq(int[] arr, int target) {
        int first=binarySearch(arr,target,true);
        if(first==-1) return 0;//if first occurence is not found it means element is not present in the array.
        int last=binarySearch(arr,target,false);
        
        return last-first+1;//just like in sliding window j-i+1;
    }
}

```
