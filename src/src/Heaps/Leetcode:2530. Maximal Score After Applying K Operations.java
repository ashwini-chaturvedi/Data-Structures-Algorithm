class Solution {

    public double MyCeilMethod(double num) {
        int intPart = (int) num; //Get the integer part of the Number

        if (intPart == num) { //if the number is equal to its integer part means num is already a stable integer
            return intPart;
        }
        //Else round up to the next Integer and return it.
        return intPart + 1;
    }

    public double MyFloorMethod(double num) {
        int intPart = (int) num; //Get the integer part of the Number

        if (intPart == num) { //if the number is equal to its int part means num is already an stable integer
            return intPart;
        }
        //Else round up to the previous Integer and return it.
        return intPart - 1;
    }

    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i = 0; i < k; i++) {
            double num = (double) maxHeap.poll();
            score += num;

            // int ceilNum = (int) Math.ceil(num / 3); //ceil method takes argument of type double.
            int ceilNum = (int) MyCeilMethod(num / 3);
            maxHeap.add(ceilNum);
        }
        return score;
    }
}
