class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;// Calculate the sum of the known occurences
        }
        int misNum = mean * (len + n) - sum; // Formula for finding average of numbers
        //n*misNum=mean*(len+n)-sum

        if (misNum < n || misNum > 6 * n) return new int[0]; // if the mis num is valid to be an answer.

        int minBaseValue = misNum / n; //Min base value a number can be
        int rem = misNum % n;// remainder 
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = minBaseValue + (i < rem ? 1 : 0); 
        }
        return res;
    }
}
