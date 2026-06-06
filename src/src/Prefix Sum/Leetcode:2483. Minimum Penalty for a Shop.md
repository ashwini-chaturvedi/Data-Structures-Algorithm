 #-----------------------------------------!BEST QUESTION FOR PREFIX SUM--------------------------------------------
## PREFIX SUM PATTERN:Isko Identify krne ka way 
### For every index
- calculate something on left side
- calculate something on right side

### Think:

- Can I precompute left information and right information?

- That's a Prefix Sum mindset.
```java
class Solution {
   
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] prefix=new int[n+1];//to store ki agr yaha pe off nhi kiya toh future me kitna loss hoga
        int[] suffix=new int[n+1];//to store ki agr yaha pe off krdiya toh future me kitna loss hoga

        for(int i=1;i<=n;i++){//left se jb aarhe h toh agar N mila toh mtlb penality lgegi isiliye prefix me N ka use krenge
            prefix[i]=prefix[i-1]+(customers.charAt(i-1)=='N'?1:0);
        }
        for(int i=n-1;i>=0;i--){//right se aana mtlb yeh check krna h ki agar shop bnd hogyi h aur customer hr index tkk toh kitna penality lgg skta h mtlb agar example:1 me 0th point pe agar shop off krdenge toh 3 ki penality lgegi
        //isiliye yaha pe Y ka use krnege kyuki dekhna h ki agar ith time pe off krdiye toh infuture kitne customers aarhe h aur kitna penality lggrha h.
            suffix[i]=suffix[i+1]+(customers.charAt(i)=='Y'?1:0);
        }

        int resIdx=0;
        int minPenality=Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            int currPenality=prefix[i]+suffix[i];//sum the penality in both perspective

            if(currPenality<minPenality){
                resIdx=i;
                minPenality=currPenality;
            }
        }

        return resIdx;
    }
}

```
