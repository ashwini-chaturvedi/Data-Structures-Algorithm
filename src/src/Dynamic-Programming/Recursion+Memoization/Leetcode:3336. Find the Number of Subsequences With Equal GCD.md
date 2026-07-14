You are given an integer array nums.

Your task is to find the number of pairs of non-empty subsequences (seq1, seq2) of nums that satisfy the following conditions:

The subsequences seq1 and seq2 are disjoint, meaning no index of nums is common between them.
The GCD of the elements of seq1 is equal to the GCD of the elements of seq2.
Return the total number of such pairs.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [1,2,3,4]

Output: 10

Explanation:

The subsequence pairs which have the GCD of their elements equal to 1 are:

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

([1, 2, 3, 4], [1, 2, 3, 4])

```java
class Solution {
    public int GCD(int a,int b){
        if(b>a){
            int temp=a;
            a=b;
            b=temp;

        }

        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }

        return a;
    }
    public long solve(int[] nums,int seq1,int seq2,int idx,long[][][] memoiz){
        if(idx==nums.length){
            if(seq1==seq2) return 1;
            return 0;
        }

        if(memoiz[seq1][seq2][idx]!=-1){
            return memoiz[seq1][seq2][idx];
        }

        //We have 3 Options 1.add in Sequence1 2.add in Sequence2 3.skip it totally.
        long takeSeq1=solve(nums,GCD(seq1,nums[idx]),seq2,idx+1,memoiz);
        long takeSeq2=solve(nums,seq1,GCD(seq2,nums[idx]),idx+1,memoiz);
        long skip=solve(nums,seq1,seq2,idx+1,memoiz);

        return memoiz[seq1][seq2][idx]=(int)((takeSeq1+takeSeq2+skip)%1000000007);
    }
    public int subsequencePairCount(int[] nums) {
        long[][][] memoiz=new long[201][201][nums.length+1];

        for(long[][] memo:memoiz){
            for(long[] m:memo){
                Arrays.fill(m,-1);
            }
        }
        return (int)((solve(nums,0,0,0,memoiz)-1)%1000000007);
    }
}
```
