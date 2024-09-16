//Time Complexity:O(NLogN)
class Solution {

    public int findMinDifference(List<String> timePoints) {
        int[] mins = new int[timePoints.size()]; // array to store the minute representation of the time given.

        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            //Getting Hours
            int hour = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            //Getting Minutes
            int minute = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
            // Converting all in minutes
            mins[i] = hour * 60 + minute;
        }
        //sorting them
        Arrays.sort(mins);

        //1440 is the total minutes in a day
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < mins.length; i++) {
            minDiff = Math.min(minDiff, mins[i] - mins[i - 1]);
        }
        // Handle the circular difference between the last and the first time point
        minDiff = Math.min(minDiff, 1440 + mins[0] - mins[mins.length - 1]); // 1440 minutes in a day
        /**1440 represents the total number of minutes in a day (24 hours * 60 minutes = 1440 minutes).

mins[0] is the first (smallest) time point, and mins[n-1] is the last (largest) time point after sorting.

The difference (1440 + mins[0] - mins[n-1]) calculates how far the first time is from the last time if the day wraps around.
 */
        return minDiff;
    }
}
