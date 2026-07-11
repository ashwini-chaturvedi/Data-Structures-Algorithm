There is a long and thin painting that can be represented by a number line. The painting was painted with multiple overlapping segments where each segment was painted with a unique color. You are given a 2D integer array segments, where segments[i] = [starti, endi, colori] represents the half-closed segment [starti, endi) with colori as the color.

The colors in the overlapping segments of the painting were mixed when it was painted. When two or more colors mix, they form a new color that can be represented as a set of mixed colors.

For example, if colors 2, 4, and 6 are mixed, then the resulting mixed color is {2,4,6}.
For the sake of simplicity, you should only output the sum of the elements in the set rather than the full set.

You want to describe the painting with the minimum number of non-overlapping half-closed segments of these mixed colors. These segments can be represented by the 2D array painting where painting[j] = [leftj, rightj, mixj] describes a half-closed segment [leftj, rightj) with the mixed color sum of mixj.

For example, the painting created with segments = [[1,4,5],[1,7,7]] can be described by painting = [[1,4,12],[4,7,7]] because:
[1,4) is colored {5,7} (with a sum of 12) from both the first and second segments.
[4,7) is colored {7} from only the second segment.
Return the 2D array painting describing the finished painting (excluding any parts that are not painted). You may return the segments in any order.

A half-closed segment [a, b) is the section of the number line between points a and b including point a and not including point b.

 

Example 1:


Input: segments = [[1,4,5],[4,7,7],[1,7,9]]

![](https://assets.leetcode.com/uploads/2021/06/18/1.png)

Output: [[1,4,14],[4,7,16]]

Explanation: The painting can be described as follows:
- [1,4) is colored {5,9} (with a sum of 14) from the first and third segments.
- [4,7) is colored {7,9} (with a sum of 16) from the second and third segments.

```java
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int[][] lineSweep=new int[segments.length*2][3];
        int k=0;
        for(int[] segment:segments){
            int left=segment[0];
            int right=segment[1];
            int color=segment[2];

            lineSweep[k++]=new int[]{left,color,1};
            lineSweep[k++]=new int[]{right,color,-1};
        }

        Arrays.sort(lineSweep,(a,b)->{
            if(a[0]==b[0]){
                if(a[2]==b[2]){
                    return Integer.compare(b[1],a[1]);
                }else{
                    return Integer.compare(a[2],b[2]);
                }
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });

        int last=lineSweep[0][0];
        long sum=lineSweep[0][1];

        List<List<Long>>list=new ArrayList<>();

        for(int i=1;i<lineSweep.length;i++){
            int[] line=lineSweep[i];

            int event=line[0];
            int color=line[1];
            int delta=line[2];

            if(last==event){
                sum+=(delta*color);
            }else{
                List<Long>ans=new ArrayList<>();
                
                    ans.add((long)last);                                     
                    ans.add((long)event);                                     
                    ans.add(sum);

                    if(sum!=0){
                        list.add(ans);  
                    }                                   
                    

                    sum+=(delta*color);   
                    last=event;
                
            }
        }

        return list;

    }
}
```
