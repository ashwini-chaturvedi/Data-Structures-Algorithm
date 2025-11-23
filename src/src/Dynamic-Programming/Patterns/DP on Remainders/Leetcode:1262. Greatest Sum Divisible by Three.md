# Greedy Approach
```java
class Solution {

    /*
    Greedy Algo
        1. num%3==1 =>store it
        2. num%3==2 =>store it
        3. Sort Them
        4. Sum%3=reminder
            1. reminder==1
                find min value to be subtracted in 2 scenarios
                a). find the 1 no. which gives 1 remainder
                b). find 2 no.s which are giving 2 remainder separetaly and together they will give 1 remainder.
            2. reminder==2
                find min value to be subtracted in 2 scenarios
                a). find the 1 no. which gives 2 remainder
                b). find 2 no.s which are giving 1 remainder separetaly and together they will give 2 remainder.
    */

    public int maxSumDivThree(int[] nums) {
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                ones.add(num);
            } else if (num % 3 == 2) {
                twos.add(num);
            }
        }
        Collections.sort(ones);
        Collections.sort(twos);

        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            int toBeSub = Integer.MAX_VALUE;
            if (twos.size() >= 2) {
                int num1 = twos.get(0);
                int num2 = twos.get(1);

                toBeSub = Math.min(toBeSub, (num1 + num2));
            }

            if (ones.size() >= 1) {
                int num = ones.get(0);
                toBeSub = Math.min(toBeSub, num);
            }

            sum -= toBeSub;
            return sum;
        } else {
            int toBeSub = Integer.MAX_VALUE;
            if (ones.size() >= 2) {
                int num1 = ones.get(0);
                int num2 = ones.get(1);

                toBeSub = Math.min(toBeSub, (num1 + num2));
            }
            if (twos.size() >= 1) {
                int num = twos.get(0);
                toBeSub = Math.min(toBeSub, num);
            }

            sum -= toBeSub;

            return sum;
        }
    }
}
```

# Recursion + Memoization
```java
class Solution {
    public int solve(int[] nums,int n,int rem,int[][] memo){
        if(n<=0){//if no elements present
            if(rem==0) return 0;//if the remainder is zero which means the sum to this step is divisible by 3
            
            return Integer.MIN_VALUE;//else we have gone through a path which isn't giving sum divisible by 3 so we will return value so small so that it doesn't effect our answer
        }

        if(memo[n][rem]!=-1) return memo[n][rem];

        int include=nums[n-1]+solve(nums,n-1,((nums[n-1]+rem)%3),memo);//either inlcude it and change the value of remainder
        int exclude=solve(nums,n-1,rem,memo);//exclude it and don't choose 

        return memo[n][rem]=Math.max(include,exclude);//return the maximum of the include or exclude because we have to give maximum value
    }
    public int maxSumDivThree(int[] nums) {
        int[][] memo=new int[nums.length+1][4];

        for(int[] mem:memo){
            Arrays.fill(mem,-1);
        }
        return solve(nums,nums.length,0,memo);
    }
}
```

# Top-Down
```java
class Solution {
    public int maxSumDivThree(int[] nums) {
        //two things were changing length & reminder
        int[][] dp=new int[nums.length+1][4];//so 2d array to store the change

        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=(i==0 && j==0)?0:Integer.MIN_VALUE;//if no element is present or rem is zero store answer 0 other wise the minimum value same as base case in recursive
            }
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<4;j++){
               
                int prev=(j-nums[i-1]%3 +3)%3;//to safe guard the array access calculate the prev index here.
                
               int include = (dp[i - 1][prev] == Integer.MIN_VALUE)//if the value of last to be included is small then be it else sum it with the including number.
                        ? Integer.MIN_VALUE
                        : nums[i-1] + dp[i - 1][prev];

               int exclude=dp[i-1][j];//excluding

               dp[i][j]=Math.max(include,exclude);//Max
            }
        }

        return dp[nums.length][3]==Integer.MIN_VALUE?0:dp[nums.length][3];
        
    }
}
```
