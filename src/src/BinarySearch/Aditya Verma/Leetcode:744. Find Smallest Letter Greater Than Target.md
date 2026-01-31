```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int sizeOfArray=letters.length;
        int low=0;
        int high=sizeOfArray-1;
        //if the target letter is not present in the array and any letters greater than
        //target element is also not present in the array.
        //then we will return letter of the 0th Index.
        if(letters[high]<=target||letters[low]>target){
            return letters[low];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(letters[mid]<=target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return letters[high+1];
    }
}
```
