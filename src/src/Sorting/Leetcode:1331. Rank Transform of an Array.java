class Solution {

    public int[] arrayRankTransform(int[] arr) {
        //Use a temporary array to copy the array and sort it.
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        //Sorting
        Arrays.sort(nums);

// The rank of each element is the number of unique elements smaller than it in the sorted array plus one.
//Using a Map to store the Rank of Each Unique Element  
        Map<Integer, Integer> map = new HashMap<>();
        int count=1;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],count);
                count++;
            }
        }

        //Storing the Rank of each Unique Element.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
