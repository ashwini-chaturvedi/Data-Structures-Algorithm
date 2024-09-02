// Approach:
        /*Hint 1
        Subtract the sum of chalk from k until k is less than the sum of chalk.
        Hint 2
        Now iterate over the array. If chalk[i] is less than k, this is the answer. Otherwise,
        subtract chalk[i] from k and continue.*/
----------------------------------------------->My Solution<--------------------------------------------------
class Solution {

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefix = new long[n];
        prefix[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + chalk[i];
        }

        k %= prefix[n - 1];

        int ans = -1;

        for (int j = 0; j < n; j++) {
            if (k < chalk[j]) {
                return j;
            }
            k -= chalk[j];
        }
        return ans;
    }
}
------------------------------------------------>ChatGPT<------------------------------------------------------
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n=chalk.length;
        
        long totalChalk=0;//calculating total number of chalks 
        for(int num:chalk){
            totalChalk+=num;
        }

        k%=totalChalk;// Remaining chalks after uses 

        for(int i=0;i<n;i++){//checking at which point now chalk will become zero...
            if(k<chalk[i]){
            
                return i;
            }
            k-=chalk[i];
        }
        return -1;
    }
}
