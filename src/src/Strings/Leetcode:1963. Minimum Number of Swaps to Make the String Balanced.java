class Solution {
    /*We Only Have to Determine Wheather a Swap is Needed or not so just Traverse the String.
        1.Keep the count of Open and Close brackets if at any point count of Closed Brackets Exceeds the count of Open means Now we have to Swap the Brackets.
        2.when we have swapped now the count of Close brackets is decreased and the count of Open bracket will Increase.*/

    public int minSwaps(String s) {
        int close = 0;
        int open = 0;
        int swap = 0;

        for (int i = 0; i < s.length(); i++) {
            //Store the Count of Open and Close Brackets.
            if (s.charAt(i)=='[') {
                open++;
            } else {
                close++;
            }

            //if the count of closed brackets exceeds the open just swap them . 
            if (open < close) {
                swap++;
                //After Swapping count of Closed Brackets will decrease and count of Open Brackets will Increase
                open++;
                close--;
            }
        }
        return swap;//Return count of Swaps done.
    }
}
