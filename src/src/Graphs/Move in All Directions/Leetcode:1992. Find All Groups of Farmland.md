```java
class Solution {

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public void GroupTheLand(int[][] land, int i, int j, int[] coOrdinates, int[][] directions) {
        //if this land is visited or it is a Forested Land(0)
        if (!isValid(land, i, j) || land[i][j] == -1 || land[i][j] == 0) return;

        land[i][j] = -1;//Mark the current land visited...

        coOrdinates[2] = Math.max(coOrdinates[2], i);//Find the maximum X-coordinate that will be Ending 
        coOrdinates[3] = Math.max(coOrdinates[3], j);//Find the maximum Y-coordinate that will be Ending 

        for (int[] dir : directions) {//Move in All Directions...
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (isValid(land, newI, newJ) && land[newI][newJ] == 1) {
                GroupTheLand(land, newI, newJ, coOrdinates, directions);
            }
        }
    }

    public int[][] findFarmland(int[][] land) {
        //We have to Return the starting and ending Co-Ordinates of the Group of FarmLand(1)
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        List<int[]> groups = new ArrayList<>(); // To Store the Co-Ordinates of the FarmLand(1) starting and ending.

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) { //When found FarmLand(1)  then we will start traversing from this point.
                    int[] coOrdinates = { i, j, i, j }; //Store the current Co-ordinate as both Starting & Ending Co-Ordinates.

                    GroupTheLand(land, i, j, coOrdinates, directions); //Traverse to Find the farmland

                    groups.add(coOrdinates); //add the start and end co-ordinate
                }
            }
        }
        return groups.toArray(new int[groups.size()][]);
    }
}

```
