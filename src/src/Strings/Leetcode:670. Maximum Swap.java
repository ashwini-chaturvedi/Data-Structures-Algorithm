-----------------------------------------Approach:1.a:(My Comments)-------------------------------------------
  class Solution {

    public int maximumSwap(int num) {
        //change the number to a String
        String s = Integer.toString(num);

        int[] maxRight = new int[10]; //to store the last occurence of each digit
        Arrays.fill(maxRight, -1);
        //now store the Occurences of Each digit.
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0'; //Making the Index of the character
            maxRight[idx] = i; //store the index of the last occurence of the number at its point in the array.
        }

        //Now Find the First Place to Swap
        for (int i = 0; i < s.length(); i++) {
            int currDigit = s.charAt(i) - '0';
            //Now check for the value greater than the current digit and also it appears on the right side of the digit
            //we would start from the end of the maxRightArray and check if the present value that is greater than currDigit at any Index which is on the right side or greater than currDigit's Index then we would swap it.
            for (int digit = 9; digit > currDigit; digit--) {
                if (maxRight[digit] > i) {//index at that point is greater than current Index so swap it.
                    //Now Swap it
                    char[] charArray = s.toCharArray();
                    //Swap
                    char temp = charArray[i];
                    charArray[i] = charArray[maxRight[digit]];
                    charArray[maxRight[digit]] = temp;

                    //Only One Swap is Allowed So return the Modified Number if more number of Swaps are allowed swap them 
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;//if no swap is done return num.
    }
}
-----------------------------------------Approach:1.b:(Better Comments)--------------------------------------

class Solution {

    public int maximumSwap(int num) {
        // Convert the number to a string representation
        String s = Integer.toString(num);

        // Array to store the last occurrence of each digit (0-9)
        int[] maxRight = new int[10];
        Arrays.fill(maxRight, -1); // Initialize all elements to -1

        // Populate the maxRight array with the last occurrence index of each digit
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0'; // Convert the character to its corresponding digit
            maxRight[idx] = i; // Store the index of this digit's last occurrence
        }

        // Iterate over the digits to find the first potential swap
        for (int i = 0; i < s.length(); i++) {
            int currDigit = s.charAt(i) - '0'; // Get the current digit

            // Check if there is a larger digit appearing later in the string
            for (int digit = 9; digit > currDigit; digit--) {
                // If the larger digit appears at a position greater than the current index
                if (maxRight[digit] > i) {
                    // Convert the string to a character array for swapping
                    char[] charArray = s.toCharArray();

                    // Perform the swap between the current digit and the larger digit
                    char temp = charArray[i];
                    charArray[i] = charArray[maxRight[digit]];
                    charArray[maxRight[digit]] = temp;

                    // Convert the modified character array back to an integer and return
                    // Since only one swap is allowed, return the result immediately
                    return Integer.parseInt(new String(charArray));
                }
            }
        }

        // If no swap was made, return the original number
        return num;
    }
}
-----------------------------------------Approach:2:(Copy Paste)---------------------------------------------
  class Solution {
    public int maximumSwap(int num) {
        String s = Integer.toString(num); // Convert num to string
        int n = s.length();

        // Array to store the index of the maximum element to the right
        int[] maxRight = new int[n];

        // Initialize the last element of maxRight
        maxRight[n - 1] = n - 1;

        // Fill the maxRight array, starting from the second last element
        for (int i = n - 2; i >= 0; i--) {
            int rightMaxIdx = maxRight[i + 1];
            char rightMaxElement = s.charAt(rightMaxIdx);

            // Update maxRight with the index of the maximum element
            if (s.charAt(i) > rightMaxElement) {
                maxRight[i] = i;
            } else {
                maxRight[i] = rightMaxIdx;
            }
        }

        // Find the first position where swapping will maximize the number
        for (int i = 0; i < n; i++) {
            int maxRightIdx = maxRight[i];
            char maxRightElement = s.charAt(maxRightIdx);

            // If there is a bigger digit to the right, swap and return the result
            if (s.charAt(i) < maxRightElement) {
                char[] charArray = s.toCharArray();
                char temp = charArray[i];
                charArray[i] = charArray[maxRightIdx];
                charArray[maxRightIdx] = temp;

                // Convert back to integer and return
                return Integer.parseInt(new String(charArray));
            }
        }

        return num; // If no swap is possible, return the original number
    }
}
