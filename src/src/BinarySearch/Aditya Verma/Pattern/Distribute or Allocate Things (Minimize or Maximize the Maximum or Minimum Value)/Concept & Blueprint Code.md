# How to Identify?
1. There is a Sense of Either Maximizing the minimum value or Minimizing the Maximum Value.
2. There is a constraint i.e. can eat in k hours,to be place k cows etc & an Array or Data Structure Denoting the structure on which work is to be done i.e piles of banana,Stalls of Distance

# How to Determine is this Minimize the Maximum or Maximize the Minimum?
1. In some Que there is Given Maximize the minimum Output or vice-versa
2. In some Que there is a Sense of Dependency on some thing to be maximize or minimize the output of the current Value

# What we have to Determine?
1. Low & High Pointers ? : Read the Question and see what it wants you to find and from there determine the Range?

   i. In Koko Eating Banana it wants you to Determine the Speed at which koko should eat food hence Speed can be between 1 to Sum of all the Bananas but Koko will eat only the bananas that are in that particular pile so speed can be between 1 to Maximum Banana in any pile. [Question](https://leetcode.com/problems/koko-eating-bananas/description/)
   low=1;
   high=maxElement(arr);
   
   ii. In Aggressive Cows it wants you to determine the Distance at maximum distance cows can be fit so distance can be between 1 to Maximum Distance of the Given Stalls Array it will work correct we can also short this range by taking the starting distance to  be from minimum distance of the stalls and Maximum distance of the stalls.[Question](https://www.geeksforgeeks.org/problems/aggressive-cows/1)
   low=minElement(arr);
   high=maxElement(arr);

   iii. In Allocate All pages it wants you to determine the Minimumize the maximum pages a student will get for that there is a constraint that every student will get pages and the books are instact so we can't go greedy hence the book with the maximum page will always go to some student hence that will be the maximum page given to a student now book is intact so we can't small it down but we can have a bound that this is the Minimumlly maximum page a student will get and this is our low bound now the upper bound will be that current student gets all the pages to read so sum of all the pages.[Question](https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1)
   low=maxElement(arr);
   high=sum(arr);

2. isValid/isPossible Method?: This method will always take 3 parameters i.e. array,k/h constraint,mid/possibleAnswer.
   i. This method will start allocating the values/objects from the array(arr) to k/h persons/places etc
   ii. This allocation will have a Maximum limit of mid/possibleAnswer.
   iii. This Allocation will tell us that if it is possible to fit values of array to k/h constraint people/places
   iv. Kya Array ki chize k logo ke bich distribute hoskti h woh bhi ek bande ko maximum mid jitni chize hi milskti h.


# General Format

```java
class Solution {
    public boolean isValid/isPossible(int[] arr,int k,int mid){
        int student=1;
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
            if(sum>mid){
                student++;
                sum=Books[i];
            }
            
            if(student>k){
                return false;
            }
        }
        return true;
    }
    public int funcionName(int[] arr, int h) {
        int max=<to be Determine>;
        int min=<to be Determine>;
        
        for(int num:arr){
           
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int low=min;
        int high=max;
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid/isPossible(arr,mid,h)){
                res=mid;//store the current answer and go for the best possible answer according to what asked in Que

                if(minimize the maximum){
                    high=mid-1;
                  }
                if(maximize the minimum){
                    low=mid+1
                  }                
            }else{
                if(minimize the maximum){
                    low=mid+1;
                  }
                if(maximize the minimum){
                    high=mid-1;
                  }   
            }
        }
        return res;
    }
}
```
   
