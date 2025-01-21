We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

 

Example 1:

Input: n = 4, k = 4
Output: 0
Explanation:  row 1: 0
              row 2: 0 1
              row 3: 0 1 1 0
              row 4: 0 1 1 0 1 0 0 1
```java
class Solution {
//We will Use IBH Method to make the Input Small Upto the Base Case

    public int kthGrammar(int n, int k) {
        if(n==1 && k==1) return 0;

        int mid=(int)(Math.pow(2,n-1))/2;//every time the elements in the Row are Increasing by 2^n-1.
        //e.g at n=1 2^0=1 so only One Element i.e 0.

        if(k<=mid){
            return kthGrammar(n-1,k);//The First half is Exactly equals to the Previous Arrangement.
        }else{
            return 1-kthGrammar(n-1,k-mid);//The Second Half is complement of the previous so that is why -1.
        }
    }
}
```
