class Solution {

    public String largestNumber(int[] nums) {
        //Make the Array of Wrapper class so as to use the Object Class methods.
        Integer[] numsAsInteger = Arrays.stream(nums).boxed().toArray(size -> new Integer[size]);

        // Sorting using Comparators (Custom Sorting) if the combination of s2+s1 is compared to combination of s1+s2 the outcome will be taken and the array will be sorted.
        
        Arrays.sort(
            numsAsInteger,
            (a, b) -> {
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                return (s2 + s1).compareTo(s1 + s2);
            }
        );

        if (numsAsInteger[0] == 0) { // if the first number is 0 or number is starting with 0 then the Largest number Possible will be 0.
            return "0";
        }
        String s = "";
        for (Integer num : numsAsInteger) { // Making the Largest Number for returning as String.
            s += num;
        }
        return s;
    }
}
