package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phoneLetter {


        public static void solve(String digits, List<String> list, List<String> ans, Map<Integer, String> map, int idx) {
            if (idx == digits.length()) {
                if (ans.size() == digits.length()) {
                    String str="";
                    for(int i=0;i<ans.size();i++){
                        str+=ans.get(i);
                    }
                    list.add(str);
                }
                return;
            }
            int currIdx = digits.charAt(idx) - '0';
            String str = map.get(currIdx);
            for (int i = idx; i <digits.length(); i++) {
                for (int j = 0; j <str.length(); j++) {
                    ans.add(str.charAt(j) + "");
                    solve(digits, list, ans, map, i + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }

        public static  List<String> letterCombinations(String digits) {
            Map<Integer, String> map = new HashMap<>();
            map.put(0, "");
            map.put(1, "");
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            List<String> ans = new ArrayList<>();

            List<String> list = new ArrayList<>();
            if (digits.isEmpty()) {

                return list;
            }
            solve(digits, list, ans, map, 0);


            return list;
        }


    public static void main(String[] args) {
            String d="";
        System.out.println(letterCombinations(d));
    }
}
