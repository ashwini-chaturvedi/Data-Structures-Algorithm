```java
class Solution {
    //Approach:
    //if there are Odd number of negative numbers then by doing operations any number of times we cannot make all the numbers positive.but we want to maximise the sum for that we would put the negative number on the smallest possible number in the matrix.
    //if there are even number of negative numbers than by doing some operations all the numbers may become positive so the sum will be the sum of all the numbers in there absolute form.
    public long maxMatrixSum(int[][] matrix) {
        int smallest = Integer.MAX_VALUE;
        int count = 0;
        long sum = 0;
        for (int[] mat : matrix) {
            for (int num : mat) {
                if (num < 0) count++;

                smallest = Math.min(smallest, Math.abs(num));
                sum += Math.abs(num);
            }
        }
        if (count % 2 == 0) {
            return sum;
        } else {
            sum -= (2*smallest);// multiply by 2 because at first it is contibuting its value as positive in the total sum and now we have to remove that positive sharing of value also we have to minus its negative form.
            //means if 1+2+3+4=10; 1 is negative to first it will decrease its share from the sum and then decrease the sum by -1.
            return sum;
        }
    }
}

```
