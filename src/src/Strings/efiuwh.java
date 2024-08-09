package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class efiuwh {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int i = 0;
        while (i < healths.length - 1) {
            boolean isCollided=false;
            if (directions.charAt(i) != directions.charAt(i + 1)) {

                if (healths[i] > healths[i + 1]) {
                    healths[i] = healths[i] - 1;
                    healths[i + 1] = -1;
                } else if (healths[i] < healths[i + 1]) {
                    healths[i] = -1;
                    healths[i + 1] = healths[i + 1] - 1;
                } else {
                    healths[i] = -1;
                    healths[i + 1] = -1;
                }
                isCollided=true;
            }
            i=isCollided ?i+2:i+1;
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < healths.length; j++) {
            if (healths[j] == -1) {
                continue;
            } else {
                list.add(healths[j]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions,healths,directions));


    }
}
