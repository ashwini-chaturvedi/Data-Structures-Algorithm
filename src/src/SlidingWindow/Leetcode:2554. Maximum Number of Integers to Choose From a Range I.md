```java
class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {
        //Set to Store the banned numbers
        Set<Integer> ban = new HashSet<>();
        for (int b : banned) {
            ban.add(b);
        }
        //Make a List of non Banned Numbers
        List<Integer>list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!ban.contains(i)) list.add(i);
        }
        if(list.isEmpty()) return 0;//Return zero if all the Numbers in range is banned


        //Perform SLiding Window
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxLen = 0;

        while(j<list.size()){
            sum+=list.get(j);

            while(i<=j && sum>maxSum){
                sum-=list.get(i);
                i++;
            }
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}
```
```java
class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {
        //Set to Store the banned numbers
        Set<Integer> ban = new HashSet<>();
        for (int b : banned) {
            ban.add(b);
        }

        int len=0;
        int sum=0;
        for(int i=1;i<=n;i++){
            if(sum+i>maxSum) return len;

            if(!ban.contains(i)){
                sum+=i;
                len++;
            }
        }
        return len;
    }
}

```
