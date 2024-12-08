# Recursion + Modified Binary Search
```java

class Solution {

    //Modified Binary Search to found the Upper Bound 
    public int binarySearch(int[][] events, int target) {//target is the End Time of the taken Event
        int low = 0;
        int high = events.length - 1;
        int res = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (events[mid][0] > target) {//if any event that has start time greater then end time of the current event than take it or store its index as a valid event that can be considered to take 
            //move the high to low so that the event which is more near can be found...
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    //Recursion
    public int takeOrSkip(int[][] events, int idx, int count,int[][] memoiz) {

        if (count == 0 || idx >= events.length) {//Only 2 count of Event is Allowed
            return 0;
        }

        if(memoiz[idx][count]!=-1) return memoiz[idx][count];

        int nextNonOverlappingEvent=binarySearch(events, events[idx][1]);//Find the next non Overlapping event using Binary Search

        int take = events[idx][2] + takeOrSkip(events, nextNonOverlappingEvent, count-1,memoiz);//Decrease the Count by one
        //Take the Current Event and then found next non-overlaping event to it.
        //By taking current event means we add its value 

        int skip = takeOrSkip(events, idx + 1, count,memoiz);//if skipp the current event then go to next event that might be overlapping or not 
        //we have skipped so don't dec count...

        return memoiz[idx][count]=Math.max(take,skip);
    }

    public int maxTwoEvents(int[][] events) {

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));//Sort on the Basis of start which will help us to find the next not overlaping event easily

        int[][] memoiz=new int[100001][3];//10^5 and only 2 possible Events
        for(int[] memo:memoiz){
            Arrays.fill(memo,-1);
        }

        return takeOrSkip(events, 0, 2,memoiz);
    }
}

```
