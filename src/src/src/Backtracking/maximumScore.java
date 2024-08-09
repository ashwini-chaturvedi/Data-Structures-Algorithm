package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maximumScore {
    public static boolean isValid(String s, Map<Character, Integer> map) {
        //we will create a new map and copy currmaps all elements into it because we want to check the availability of each
        //character after every iteration and is available decrease its count which tells us that only this much of character
        //is present
        Map<Character,Integer>tempMap=new HashMap<>(map);
        for (char ch : s.toCharArray()) {
            if (!tempMap.containsKey(ch)|| tempMap.get(ch)<=0) {
                return false;
            }
            tempMap.put(ch,tempMap.get(ch)-1);
        }
        return true;
    }

    public static int scores(String s, int[] score) {
        int totalScore = 0;
        for (char ch : s.toCharArray()) {
            totalScore += score[ch - 'a'];
        }
        return totalScore;
    }

    public static void solve(String[] words, int[] score, Map<Character, Integer> map, int[] maxScore, int idx,int currScore) {
        if (idx >= words.length) {
            if(currScore>maxScore[0]){
                maxScore[0]=currScore;
            }
            return;
        }
        solve(words,score,map,maxScore,idx+1,currScore);


            if (isValid(words[idx], map)) {
                // list.add(words[i]);
                for (char ch : words[idx].toCharArray()) {
                    map.put(ch, map.get(ch) - 1);
                }
                 currScore+=scores(words[idx],score);
                solve(words, score, map, maxScore, idx+ 1,currScore);

                for (char ch : words[idx].toCharArray()) {
                    map.put(ch, map.get(ch) + 1);
                }
            }


    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : letters) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        System.out.println(map);
        int[] maxScore = { Integer.MIN_VALUE };
        solve(words, score, map, maxScore, 0,0);
        return maxScore[0]==Integer.MIN_VALUE?0:maxScore[0];
    }
    public static void main(String[] args) {
        int[]score={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
//        System.out.println(scores("ax",score));
        String[]words={"dog","cat","dad","good"};
        char[]letters={'a','a','c','d','d','d','g','o','o'};
        System.out.println(maxScoreWords(words,letters,score));
    }
}
