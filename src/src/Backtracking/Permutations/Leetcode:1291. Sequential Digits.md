An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300

Output: [123,234]

Example 2:

Input: low = 1000, high = 13000

Output: [1234,2345,3456,4567,5678,6789,12345]

```java
class Solution {
   public void solve(int lLen,int hLen,int[]nums,List<Integer>list,int num,int idx){
        if(lLen<=idx && idx<=hLen){
            list.add(num);
        }

        for(int i=0;i<9;i++){
            if((num%10)+1==nums[i] || num==0){
                num=(num)*10+nums[i];
                solve(lLen,hLen,nums,list,num,idx+1);
                num/=10;
            }
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int lLen=(int)(Math.log10(low)+1);
        int hLen=(int)(Math.log10(high)+1);

        List<Integer>list=new ArrayList<>();
        int[] nums=new int[]{1,2,3,4,5,6,7,8,9};


        solve(lLen,hLen,nums,list,0,0);//Generate all numbers with sequential digits and check if they are in the given range Fix the starting digit then do a recursion that tries to append all valid digits.

        List<Integer>ans=new ArrayList<>();
        for(int number:list){
            if(number>=low && number<=high){
                ans.add(number);
            }
        }
        Collections.sort(ans);

        return ans;
    }
}
```
