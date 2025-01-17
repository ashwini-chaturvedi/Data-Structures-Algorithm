```java
class Solution {
    public int findTarget(int arr[], int target) {
        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            
            //element can be on mid,mid-1 or mid+1.
            
            int mid=low+(high-low)/2;
            
            int prevIdx=(mid-1+arr.length)%arr.length;
            int nextIdx=(mid+1)%arr.length;
            
            if(arr[mid]==target || arr[prevIdx]==target ||arr[nextIdx]==target ){//arr[i] may be present at arr[i-1] or arr[i+1]. 
                if(arr[prevIdx]==target) return prevIdx;
                if(arr[mid]==target) return mid;
                if(arr[nextIdx]==target) return nextIdx;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
```
