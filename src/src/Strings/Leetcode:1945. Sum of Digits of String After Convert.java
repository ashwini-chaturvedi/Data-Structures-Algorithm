----------------------------------------------->Approach:1<-----------------------------------------------------
  class Solution {

    public int getLucky(String s, int k) {
        List<Integer> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            list.add(ch - 'a'+1);
            
        }
        int ans=0;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (Integer num : list) {                
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
            }
            if(i<k-1){
                list.clear();
                list.add(sum);
            }else{
                ans=sum;
                break;
            }
        }
        return ans;
    }
}
----------------------------------------------->Approach:2<-----------------------------------------------------
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numericalRepresentation = new StringBuilder();    // initial numerical string representation
      
        // Convert each character in the string to its corresponding numerical value ('a' -> 1, 'b' -> 2, etc.)
        for (char c : s.toCharArray()) {
            numericalRepresentation.append(c - 'a' + 1);    // Append the numerical string equivalent of character to the StringBuilder
        }
      
        s = numericalRepresentation.toString();     // Store the numerical string representation to s for further manipulation
      
        // Perform transformation k times
        while (k > 0) {
            int sum = 0;            // Initialize sum to accumulate the digits
          
            // Sum the digits of the string
            for (char c : s.toCharArray()) {
                sum += c - '0';     // Convert char digit to integer and add to sum
            }
          
            // Convert the calculated sum back to string for the next iteration
            s = String.valueOf(sum);

            k--;
        }
      
        return Integer.parseInt(s);     // Convert the final string back to an integer and return it as the "lucky" number

    }
}
