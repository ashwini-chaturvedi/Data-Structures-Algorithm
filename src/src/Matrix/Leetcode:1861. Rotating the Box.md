# Rotate the box 90 degree using the relation rotatedBox[i][j] = box[m - 1 - j][i]
```java
class Solution {

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotate = new char[n][m];

// ** Rotate the box 90 degree using the relation rotatedBox[i][j] = box[m - 1 - j][i] **.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotate[i][j] = box[m - 1 - j][i]; //Storing the Rotated form of the box
            }
        }

    //    Start iterating from the bottom of the box and for each empty cell check if there is any stone above it with no obstacles between them.
    //When you find a STONE Swap the empty space with the STONE
    //When you find an Obstacle break the loop because any STONE will rest on above Obstacle so no need to find the stone below the Ostacle...

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (rotate[i][j] == '.') {
                    int k = i - 1;
                    while (k >= 0) {//Start Moving Upward
                        if (rotate[k][j] == '#') {
                            rotate[k][j] = '.';
                            rotate[i][j] = '#';
                            break;
                        } else if (rotate[k][j] == '*') {//if Found an Obstacle break the loop
                            break;
                        }
                        k--;
                    }
                }
            }
        }
        return rotate;
    }
}

```
