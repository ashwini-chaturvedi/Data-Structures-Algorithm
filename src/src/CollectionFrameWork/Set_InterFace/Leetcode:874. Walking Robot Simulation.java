// Time Complexity:O(N)
class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        //Using Set to Store the Co-ordinates of the Obstacle as a String
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            String key = obs[0] + "_" + obs[1]; // Making String
            set.add(key);
        }

        int[] dir = { 0, 1 }; //direction array to properly manipulate the co-ordinates while moving

        // Co-ordinates
        int x = 0;
        int y = 0;

        int maxD = Integer.MIN_VALUE;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) { //Turn Right
                dir = new int[] { dir[1], -dir[0] }; //We are Doing this because as we know when we turn right we will change co=ordinates from {0,1} to {1,0}
            } else if (commands[i] == -2) { // Turn Left
                dir = new int[] { -dir[1], dir[0] }; //We are Doing this because as we know when we turn left we will change co=ordinates from {0,1} to {-1,0}
            } else { //Move Forward Steps Number of times we have to move steps number of times as we we move in the current direction
                for (int step = 0; step < commands[i]; step++) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    String newKey = newX + "_" + newY;
                    if (set.contains(newKey)) { // if we found any obstacle in the path then we will not move it that direction and hence leave the movement in that direction.
                        break;
                    }

                    //if we can move so now the x-y co-ordinates of the Robot will now be equal to newX-newY this shows that without any issue robot has reached this very point
                    x = newX;
                    y = newY;
                }
            }
            maxD = Math.max(maxD, x * x + y * y); // Calculating Maximum Distance
        }
        return maxD;
    }
}
