```java
class Pair {
    int val;
    int idx;

    Pair(int a, int b) {
        val = a;
        idx = b;
    }
}

class Solution {

    public long findScore(int[] nums) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.val != b.val) return a.val - b.val; 
                else return a.idx - b.idx;
            }
        );
        for(int i=0;i<nums.length;i++){
            minHeap.add(new Pair(nums[i],i));
        }

        Set<Integer> set = new HashSet<>();
        long score = 0;
        while(!minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            int i=curr.idx;

            if (!set.contains(i)) {
                score += curr.val;
                set.add(i);
                set.add(i - 1);
                set.add(i + 1);
            }
        }
        return score;
    }
}

```
