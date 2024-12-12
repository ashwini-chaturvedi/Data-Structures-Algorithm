```java
class Solution {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        while (k > 0) {
            int num = maxHeap.poll();
            maxHeap.add((int) Math.floor((double) (Math.sqrt(num))));// the floor of the square root of the number 
            k--;
        }

        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }
        return sum;
    }
}

```
