Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

 

Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
Example 2:

Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.

```java
class Solution {

    public boolean[] isPrime(int n){
        //Use a boolean Array
        boolean[] sieve=new boolean[n+1];

        //Now Applying Algorithm
        Arrays.fill(sieve,true);//First Mark all the Indexes as True
        sieve[0] = sieve[1] = false; // 0 and 1 are not prime

        for(int i=2;i<=Math.sqrt(n);i++){//Start Traversing From index 2 to the Square Root of 'n' because after that the value will go beyond 'n'
            if(sieve[i]){//if the Index is true that means it is a Prime Number.
                //Start Marking from Square of the Number 'i' because Prior to that every number multiple is already marked from previous numbers
                for(int idx=i*i;idx<=n;idx+=i){//Then Mark it's all Multiples as false because
                    // later on this Number can factorize them and hence they will not be Prime Numbers
                    //this Idx+=i will make the loop run as Table of 'i'
                    sieve[idx]=false;
                }
            }
        }
        return sieve;
    }

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = isPrime(right);//Find out all the Prime Numbers Using Sieve of Eratosthenes

        List<Integer> Primes = new ArrayList<>();//Store all the Numbers which are Prime

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                Primes.add(i);
            }
        }

        //if the size is less then 2 then pairing is Impossible so return {-1,-1}
        if (Primes.size() < 2) return new int[] { -1, -1 };

        int[] res = { -1, -1 };
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < Primes.size(); i++) {
            int diff = Primes.get(i) - Primes.get(i - 1);//num2-num1

            if (diff < minDiff) {//num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
                minDiff = diff;
                res[0] = Primes.get(i - 1);
                res[1] = Primes.get(i);
            }
        }
        return res;
    }
}

```
