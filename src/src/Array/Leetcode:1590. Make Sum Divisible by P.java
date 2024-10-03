/* with the help of CUMMULATIVE SUM SUBARRAY we can find the sum of any subarray
  1.sum[i...j]=sum[0...j] - sum[0...i]
    we have to handle the negative value for that  you can use %p
    now,
    curr=sum[0...j]
    prev=sum[0...i]
    
    int target=curr-prev
   >rearranging it 
    prev=curr-target
    if this 'prev' has ever been seen then just calculate length between the current index(j) to the previously seen value's Index(i).

    so, finally our formula is :
    (prev)%p=(curr-target+p)%p
    this %p for handling negative Value
    
*/
class Solution {

    public int minSubarray(int[] nums, int p) {
        //Taking the Prefix sum.
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum = (prefixSum + num) % p;
        }

        int target = prefixSum % p;//Finding the target or the remaining number which we have to remove from the array either a single number of sum of multiple number 
        if(target==0) return 0;//if target is zero means prefixSum is whollaly divisible by p and hence we get answer 0 

        Map<Integer, Integer> map = new HashMap<>();//map to store the Index of the number we have last seen.
        map.put(0, -1); //Remainder at index -1 is 0

        int minLen = nums.length;//Important...

        int curr = 0;//currSum is zero means the sum from 0 to j is currently zero at starting time
        for (int j = 0; j < nums.length; j++) {

            curr = (curr + nums[j]) % p;//current is the sum between 0 to j so here it is calculating prefix sum upto this point 

            int prev = ((curr - target) + p) % p;//prev is the sum between 0 to i.
        // 'i' is that point where the this value (((curr - target) + p) % p) wal last seen so .

            if (map.containsKey(prev)) {//if the map contains the prev value which means we have had Encountered this value previously so now we only have to find the length between the two points.
                int i = map.get(prev);
                minLen = Math.min(minLen, (j - i ));
            }
            map.put(curr, j);//later put curr with the index in future this will becoem the history or curr value prev value bnjaegi.
        }
        return minLen==nums.length?-1:minLen;//if there is not such value return -1 or else return the length.
    }
}
