//Approach:
//1.Using a Heap to Store a pair of depart time and chair number given to that friend.
//2.Using a Heap to Store the Least available seat that was vaccant by any departing friend.
//
class Pair {
    int depart;
    int chair;

    Pair(int arr, int i) {
        depart = arr;
        chair = i;
    }
}

class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        //1.Store the Arrival time of the targetFriend.
        int targetFriendArrival = times[targetFriend][0];
        //2.Sort the Friends on the Basis of there Arrival time.
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        //3.Take 2 PriorityQueues to Store the Occupied chair and recently filled chair.
        PriorityQueue<Pair> occupied = new PriorityQueue<>((a, b) -> a.depart - b.depart); //Pair of (depart time of Friend,there "chairNo.")
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>(); //Store the Recently Vaccant Chair as the friend depart.These are Stored in a minHeap so that the LeastVaccant chair is Available at the top and can be easily accessed.

        int nextVaccantChair = 0; //as name says the next possible vaccant chair if any chair is not vaccant.

        for (int i = 0; i < times.length; i++) {
            int arrival = times[i][0];
            int depart = times[i][1];

            while (!occupied.isEmpty() && occupied.peek().depart <= arrival) { //if any friend/friends have there depart time less than the arrival of the current friend which means there time to depart has come.
                freeChairs.add(occupied.peek().chair); //store the chair vaccant by the departing friend in a minHeap.
                occupied.poll(); //Depart the Friend or remove it from occupied seat list.
            }

            if (freeChairs.isEmpty()) { //if the friend arriving and no any friend is departing and the heap that stores the recently vaccant chair is empty that means no any friend has leaved the party which means now the currently arriving friend will have to have new chair to sit the new chair to sit is =nextVaccantChair.
                if (arrival == targetFriendArrival) { //if the arrival time of the current friend is equal to targetFriendArrival time which means this is our targetFriend so just return its seat number.
                    return nextVaccantChair;
                }

                occupied.add(new Pair(depart, nextVaccantChair));//currently arriving friend now sits on the next possible chair.

                nextVaccantChair++;//Now next vaccant chair would be plus one or next chair.
            } else {//if there is a chair in the Freechairs heap which means any friend has leaved the seat so it is vaccant and we want to have the least vaccant seat filled first so just pop from the heap and use that chair,
                int leastVaccantChair = freeChairs.peek();
                freeChairs.poll();

                if (arrival == targetFriendArrival) {//if the arrival time of the current friend is equal to targetFriendArrival time which means this is our targetFriend so just return its chair number.
                    return leastVaccantChair;
                }

                occupied.add(new Pair(depart, leastVaccantChair));//add the chair with the friends depart time in the occupied heap.
            }
        }
        return -1;
    }
}
