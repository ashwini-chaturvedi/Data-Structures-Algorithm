package CollectionFrameWork.Map_Interface;

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


     public class TreeMaps {

         public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
             Map<Double, int[]> map = new TreeMap<>();

             for (int i = 0; i < arr.length; i++) {
                 for (int j = i + 1; j < arr.length; j++) {
                     double frac = arr[i] / arr[j];
                     map.put(frac, new int[]{arr[i], arr[j]});
                 }
             }
             int[] res = null;
             int currIdx = 1;
             for (Map.Entry<Double, int[]> entry : map.entrySet()) {
                 if (currIdx == k) {
                     res = entry.getValue();
                     break;
                 }
                 currIdx++;
             }
             return res;
         }

         public static void main(String[] args) {
             int[] arr = {1, 2, 3, 5};
             int k = 3;
             kthSmallestPrimeFraction(arr, k);

         }

     }

