// Approach:
        /*Hint 1
        Subtract the sum of chalk from k until k is less than the sum of chalk.
        Hint 2
        Now iterate over the array. If chalk[i] is less than k, this is the answer. Otherwise,                            subtract chalk[i] from k and continue.*/
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
