```java
class Pair {// Pair to Store the String and the level at which it is found upon
    String s;
    int level;

    Pair(String str, int lvl) {
        s = str;
        level = lvl;
    }
}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);//add all the words of word List into a set for easier access...
        
        if (!set.contains(endWord)) return 0;//edge case if the endWord is not in the wordlist so we cannot find it and hence return 0...

        //We want to find the shortest path so we will use BFS
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(beginWord, 1));//start from begin word

        while (!que.isEmpty()) {
            Pair curr = que.poll();
            String word = curr.s;
            int level = curr.level;

            if (word.equals(endWord)) return level;//if we have found the endWord return the level associated with it...

            for (int i = 0; i < word.length(); i++) {//Pick every character
                for (char ch = 'a'; ch <= 'z'; ch++) {//change every character form a to z to check any possible String is Present there in the set

                    char[] characters = word.toCharArray();

                    characters[i] = ch;//change the ith character with a character between a to z

                    String newWord = new String(characters);

                    if (set.contains(newWord)) {//if the new word is present in the set that means it can be used for change... 
                        set.remove(newWord);//when we found a word we will remove it from the set because for that particular number we have already found the shortest path possible there so there is no need to keep it in...
                        que.add(new Pair(newWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}

```
