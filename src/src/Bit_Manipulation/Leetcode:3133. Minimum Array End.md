# TLE Approach:
  ## Result of AND of all the Elements of array to be equal to x  depends on the setBits that are in x.
  ## Means if we want to have result==x all the Elements of the Array should have all the bits set that are set in x so that at last they will give the result equal to x.

```java
class Solution {
//TLE Solution

//eg: x==4 [4,5,6] => (4:0100,5:0101 ,6:0110) we can see that 2nd most Significant Bit is Set in all three of them and hence they give result equal to x
    public long minEnd(int n, int x) {
        if (n == 1) return x;

        long ans = 0;

        for (long num = x; n > 0; num++) {//Start From x because we will include x in the array as first Element Because any element to have set bit at the position x has is to be greater then x 
        //we will try to find numbers whose all the bits are set that are set in x  Rest of the bits may or maynot be set because when we will take there AND with x there answer will be x 
        //if the answer is x then that number is correct and can be Included into the Array because atlast when we want to have the AND of all the Elements of the Array equal to x these Elements which already have there all the bits set that are in x they will give the Result x.
            if ((x & num) == x) {//if all bits are set same as that of x there AND with x gives the number x.
                n--;
                ans = num;
            }
        }
        return ans;
    }
}

```
# Bit-wise OR Approach:
```java

class Solution {

    public long minEnd(int n, int x) {
        long ans = x;

        for (int i = 1; i < n; i++) {//Because 0th Element is x already
//Q.Why use OR?
    //It can give a number which has all the Bit set as they are in 'x' and the remaining bits to be set or Not is not sure.
//eg: 7(0111) | 8(1000)=_111 ; which means all the Bits that are set in x(7) are to be set here also to get the right result and to do this we take OR.
            ans = x | (ans + 1);
        }
        return ans;
    }
}

```
