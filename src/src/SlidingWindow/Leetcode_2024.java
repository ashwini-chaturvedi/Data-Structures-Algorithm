package SlidingWindow;

public class Leetcode_2024 {


        public int maxConsecutiveAnswers(String answerKey, int k) {
            char[] answer = answerKey.toCharArray();
            int result = 0;
            int i = 0;
            int j = 0;
            int countF = 0;
            while (j < answer.length) {
                if (answer[j] == 'F') {
                    countF++;
                }
                while (countF > k) {
                    if (answer[i] == 'F') {
                        countF--;
                    }
                    i++;
                }
                result = Math.max(result, (j - i + 1));
                j++;
            }

            int a = 0;
            int l = 0;
            int countT = 0;
            int result2 = 0;
            while (l < answer.length) {
                if (answer[l] == 'T') {
                    countT++;
                }
                while (countT > k) {
                    if (answer[a] == 'T') {
                        countT--;
                    }
                    a++;
                }
                result2 = Math.max(result2, (l - a + 1));
                l++;
            }
            return result > result2 ? result : result2;
        }


}
