/*Approach:
1.Actually it is to find one sentence as a concatenation of a prefix and suffix from the other sentence.
2.Get the longest common prefix between them and the longest common suffix.
    a)To find the longest common Prefix and Suffix split the Strings at space
    b)Then find the common Prefix and Suffix.
    c)Keep in mind that Actually we have to find a String which is the concatenation of longest common Prefix and Suffix between two given Strings.*/

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1=sentence1.split(" ");
        String[] words2=sentence2.split(" ");

        //Ensure that words1 should be of Higher Length if not then Swap the Strings array
        if(words1.length<words2.length){
            String[] temp=words2;
            words2=words1;
            words1=temp;
        }
//Now words1 will always be String of Greater Length and word2 will be string of smaller length.

        //Now Check for Common Prefix Between those to Strings but make the loop run for the minimum length because the common element can be found at most for shorter length String(i.e. words2).
        int commonPrefix=0;
        int i=0;
        while(i<words2.length && words1[i].equals(words2[i])){
            commonPrefix++;
            i++;
        }

        //Similarly for Common Suffix
        int commonSuffix=0;
        int j=0;
        while(j<words2.length && words1[words1.length-1-j].equals(words2[words2.length-1-j])){
            j++;
            commonSuffix++;
        }

        return commonPrefix+commonSuffix>=words2.length;//This means that sum of the common prefix and common suffix must be greater then the length of smaller string array(words2) because while calculating common prefix and suffix it is possible that some elements may have be counted twice in the smaller string array but there should be atleast minimum words2.length element so that both the senteces should be similar. 
    }
}
