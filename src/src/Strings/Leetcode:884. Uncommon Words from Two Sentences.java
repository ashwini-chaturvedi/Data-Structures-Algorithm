Time Complexity:O(M+N)
  
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        //Split the String at space beacuse it will give different words present in a Sentence
        String[] string1 = s1.split(" ");
        String[] string2 = s2.split(" ");

        //Store the count of words in a Map
        Map<String, Integer> map = new HashMap<>();

        for (String word : string1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : string2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {//if the count of any word is 1 that means it has only occured once in both string and it is Uncommon Word
                list.add(e.getKey());
            }
        }
        return list.toArray(new String[0]);//return an Array of String...
    }
}
