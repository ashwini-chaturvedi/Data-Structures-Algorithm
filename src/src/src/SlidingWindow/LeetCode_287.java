package SlidingWindow;

public class LeetCode_287 {

        public static int findDuplicate(int[] nums) {
            //intitializing two pointers fast and slow...and pointing them to the first element.
            int fast = nums[0];
            int slow = nums[0];
            //moving both the pointers like slow moves 1 step and fast moves 2 step at a time.
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            //as soon as the meet we again initialize fast pointer allPathFromStoT to the 1st element
            // and then start traversing it until we meet again to slow and at last
            //both the pointers will point to duplicate number
            fast = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }
        public static void main(String[]args){
            int [] nums={1,3,4,2,2};
            System.out.println(findDuplicate(nums));
        }
}



