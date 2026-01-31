```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>>list=new ArrayList<>();
        int i=0;
        int j=0;
        int minVal=Integer.MAX_VALUE;

        while(j<arr.length){
            if(j-i+1==2){
                minVal=Math.min(minVal,Math.abs(arr[i]-arr[j]));
                i++;
            }
            j++;
        }
        i=0;
        j=0;

        while(j<arr.length){
            if(j-i+1==2){
                if(Math.abs(arr[i]-arr[j])==minVal){
                    list.add(List.of(arr[i],arr[j]));
                }
                i++;
            }
            j++;
        }

        return list;


    }
}
```
