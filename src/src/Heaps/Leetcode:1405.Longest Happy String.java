class Pair {
    int count;
    char ch;

    Pair(int cnt, char c) {
        this.count = cnt;
        this.ch = c;
    }
}

class Solution {

    public String longestDiverseString(int a, int b, int c) {
        //MaxHeap to get the highest count character on top this is being Greedy which means we want to include the maximum count character first.
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p, q) -> Integer.compare(q.count, p.count));
        if (a > 0) maxHeap.add(new Pair(a, 'a'));
        if (b > 0) maxHeap.add(new Pair(b, 'b'));
        if (c > 0) maxHeap.add(new Pair(c, 'c'));
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            int currCount = curr.count;
            char currChar = curr.ch;
            // Check if the last two characters are the same as the current character
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == currChar && sb.charAt(sb.length() - 2) == currChar) {
                //#Termination
                if (maxHeap.isEmpty()) break; //if no character is present break the loop

                //if the last two characters are same then take next character to add in the result
                Pair next = maxHeap.poll();
                int nextCount = next.count;
                char nextChar = next.ch;

                sb.append(nextChar);
                nextCount -= 1; //used one count so decrease its count
                if (nextCount > 0) { //if the count of the character is greater than 0 then only add it again to the heap
                    maxHeap.add(new Pair(nextCount, nextChar));
                }

                //not used the currChar so add it back to the Heap.
                maxHeap.add(curr);
            } else {
                sb.append(currChar);
                currCount -= 1; //used one count so decrease its count
                if (currCount > 0) { //if the count of the character is greater than 0 then only add it again to the heap
                    maxHeap.add(new Pair(currCount, currChar));
                }
            }
        }
        return sb.toString();
    }
}
