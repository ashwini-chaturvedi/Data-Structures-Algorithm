//Approach:
//1.Every 1 in the string s should be swapped with every 0 on its right side.
//2.Iterate right to left and count the number of 0 that have already occurred
//3.then whenever you iterate on 1 add that counter to the answer.number of times you found 1 add the counter
//to the swap means if there are 2 ones present add counter into the swaps 2 times.
class Solution {

    public long minimumSteps(String s) {
        long swaps = 0;
        int whiteBalls = 0;
        for (int i = s.length() - 1; i >= 0; i--) { //iterating from right to left
            if (s.charAt(i) == '0') { //if we found a whiteBall
                whiteBalls++;
            } else { //when we found blackBall add the whiteBalls counter into the answer
                swaps += whiteBalls;
            }
        }
        return swaps;
    }
}
