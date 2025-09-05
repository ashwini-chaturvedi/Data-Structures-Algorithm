1.There is a Pattern when we want to digonally traverse the grid the sum of currRow and currCol is equal for all diagonal Elements.
2.hence we use a Map to store the elements according to the Sum or the row & col.
3.later to construct the answer just add the list of elements straight if the sum of the row and col is odd or reverse the list of element if the sum is Even.*/
        
```java
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int sum=i+j;

                if(!map.containsKey(sum)){
                    map.put(sum,new ArrayList<>());
                }
                map.get(sum).add(mat[i][j]);
            }
        }

        int[] arr=new int[mat.length*mat[0].length];
        int k=0;
        for(var e:map.entrySet()){

            List<Integer>list=new ArrayList<>();
            if(e.getKey()%2==0){
                list=e.getValue().reversed();
            }else{
                list=e.getValue();
            }

            for(int num:list){
                arr[k++]=num;
            }
        }

        return arr;
    }
}
```
