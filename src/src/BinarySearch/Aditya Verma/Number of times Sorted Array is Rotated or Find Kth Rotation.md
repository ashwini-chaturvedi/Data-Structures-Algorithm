# Number of times array is Rotated==Index of the Minimum Element
```java
class Solution {
    public int findKRotation(List<Integer> arr) {
        int n=arr.size();
        int low=0;
        int high=n-1;
        
      
        
        while(low<=high){
            if(arr.get(low)<=arr.get(high)) //if Array is Already Sorted return the Low Index
            return low;
            
            int mid=low+(high-low)/2;
            
            int prevIdx=(mid-1+n)%n;//to avoid overflow/out of bound
            int nextIdx=(mid+1)%n;//to avoid overflow/out of bound
            
            //if the mid element is less than both of its neighbor
            if(arr.get(prevIdx)>=arr.get(mid) && arr.get(mid)<=arr.get(nextIdx)){
                return mid;
            }else if(arr.get(low)<=arr.get(mid)){//left side is sorted,Now move to right side
                low=mid+1;
            }else if(arr.get(mid)<=arr.get(high)){//right side is sorted,Now move to left side
                high=mid-1;
            }
        }
        
        return 0;
    }
}
```
