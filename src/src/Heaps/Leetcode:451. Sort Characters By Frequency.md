```java
class pair {
    char ch;
    int count;

    pair(char c, int counts) {
        ch = c;
        count = counts;
    }
}

class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();//Store the Frequency of the character
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        //Use maxHeap to sort the characters based on the frequency...
        PriorityQueue<pair> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (char key : map.keySet()) {//Add the Character into the maxHeap
            maxHeap.add(new pair(key, map.get(key)));
        }

        //make String from the characters and there frequency available in the Heap.
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int time = maxHeap.peek().count;
            for (int i = 0; i < time; i++) {//add character frequency number of time.
                sb.append(maxHeap.peek().ch);
            }
            maxHeap.remove();
        }
        return sb.toString();
    }
}

```
