class Solution {

    public int numBetween(int curr, int next, int n) {
        long currPrefix = curr;
        long nextPrefix = next;

        int totalNum = 0;
        while (currPrefix <= n) {
            //at Current Level total numbers present in between currPrefix and nextPrefix
            // At each level, add the numbers between currPrefix and nextPrefix, constrained by n
        totalNum += Math.min(n + 1, nextPrefix) - currPrefix;

            //Moving to the next Level
            currPrefix *= 10;
            nextPrefix *= 10;
        }
        return totalNum;
    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;

        while (k > 0) {
            int next = curr + 1;
            int count = numBetween(curr, next, n); //counts the total numbers between currPrefix and next prefix.

            if (count <= k) { //if total numbers present in between the currPrefix and nextPrefix is less than 'k' just skip this number and go to the next number.
                //SKIP THE TREE

                curr += 1; //Moving to the next Prefix.
                k -= count; //Skiping the current number by just knowing how much number is there in between and then just subtracting it with 'k'.
            } else {
                //Don't Skip
                curr *= 10; //check into the curr prefixed number and it's Derivatives for the answer because the TotalCount of numbers between currPrefix and nextPrefix is greater than 'k' so our answer will be in between.
                k -= 1; //we have count the curr number.
            }
        }
        return curr;
    }
}
