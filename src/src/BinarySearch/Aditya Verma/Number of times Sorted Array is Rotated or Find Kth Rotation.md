# Number of times array is Rotated==Index of the Minimum Element
```java


class Solution {
    public int findKRotation(int[] arr) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            if(arr[low]<=arr[high]) return low;
            int mid=low+(high-low)/2;

//for checking left and right value of the current index but it can be circular so using the cicular formulas
            int leftIdxToMid=(mid-1+n)%n;//to avoid overflow/out of bound
            int rightIdxToMid=(mid+1)%n;//to avoid overflow/out of bound
            
            //if the mid element is less than both of its neighbor
            if(arr[leftIdxToMid]>=arr[mid] && arr[mid]<=arr[rightIdxToMid]){
                return mid;
            }else if(arr[low]<=arr[mid]){//left side is sorted,Now move to right side
                low=mid+1;
            }else if(arr[mid]<=arr[high]){//right side is sorted,Now move to left side
                high=mid-1;
            }
        }
        
        return 0;
    }
}
```
