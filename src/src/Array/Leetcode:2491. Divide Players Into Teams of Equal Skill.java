class Solution {
    public long dividePlayers(int[] skill) {
// 1.Sorting the Array
        //We want to make the Pair of weakest available player with the Strongest available player for that we have to sort the whole array
      
        Arrays.sort(skill);

// 2.Making Pairs and Storing them.
        List<int[]> listOfPairs = new ArrayList<>();

        //Two Pointers Approach for determining Strong and Weak Player.
        int i = 0;
        int j = skill.length - 1;

        int totalSkill = skill[0] + skill[skill.length - 1]; //possible total skill that should be same in all the pairs.

        while (i < j) {
            if (skill[i] + skill[j] == totalSkill) { //if the total Possible skill is matched make a pair of it.
                listOfPairs.add(new int[] { skill[i], skill[j] });
                i++;
                j--;
            } else {
                return -1;// if there is any pair whose total possible skill is not equal to previous ones that means we cannot divide the array in equal parts and hence return -1.
            }
        }
//3.Determining the Chemistry.
        long chemistry = 0;
        for (int[] num : listOfPairs) {
            int multi = num[0] * num[1];//Product of the numbers in pair.
            chemistry += multi;
        }
        return chemistry;
    }
}
