//Approach 1 - Brute Force
    //Put all the possible prefixes of each element in arr1 into a HashSet.
    //For all the possible prefixes of each element in arr2, check if it exists in the HashSet.
//T.C : O(m⋅log10​M + n⋅log10​N)
//S.C : O(m⋅log10​M)
class Solution {
    

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr1) {
            while(!set.contains(num) && num>0){
                set.add(num);
                num=num/10;
            }
        }
        int len = 0;
 
        for (int num:arr2) {
            while(!set.contains(num) && num>0){
                num=num/10;
            }
            if(num>0){
                len=Math.max(len,(int)(Math.log10(num)+1));
                //When you want to get length of a integer number just take its log with base 10 and add 1 to it
                //no. of digits=log10(num)+1;
            }
        }
        return len;
    }
}
