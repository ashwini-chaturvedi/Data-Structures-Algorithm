```java
class GFG {
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
    ArrayList<Integer> find(int[] arr, int x) {
        int first=BinarySearch(arr,x,true);//Find the First Occurence
        int last=BinarySearch(arr,x,false);//Find the Last Occurence
        
       return new ArrayList<>(Arrays.asList(first, last));

    }
}
```
