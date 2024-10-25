# Approach:1
  ## Time-Complexity:O(N * L^2)
```java

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders lexicographically.
        Arrays.sort(folder);//sort the folder array of string in Lexicographical format

        List<String>list=new ArrayList<>();

        String lastAdded="";//store the last added string as Parent String

        for(String currFolder:folder){
            if(list.isEmpty() || !currFolder.startsWith(lastAdded+"/")){//if the currFolder starts with a path of lastAdded and a slash which means it is a subfolder and if it is not then it is not a subfolder if it is not add it to the list and make it the last added folder 
                list.add(currFolder);//Not a Subfolder so add it 
                lastAdded=currFolder;//Make it last added folder
            }
        }
        return list;
    }
}

```
# Approach:2 
  ## Time-Complexity:O(NlogN)
```java
class Solution {

    public List<String> removeSubfolders(String[] folder) {
        //Put All the folders into a Set
        Set<String> set = new HashSet<>();

        for (String s : folder) {
            set.add(s);
        }

        List<String> list = new ArrayList<>();
        //Traverse the Array
        for (String currFolder : folder) {

            boolean isSubFolder = false;
            String tempFolder=currFolder;//Strings are Immutable in Java so saving the actual String for future purpose

            while (!currFolder.isEmpty()) {
                //find the last occurence of slash(/) because after that the folder will be a subfolder and before that would be a Parent Folder
                int lastPosition = currFolder.lastIndexOf('/');

                if(lastPosition==-1) break;// Exit if there are no more '/' characters

                //Parent Path using Substring
                currFolder = currFolder.substring(0, lastPosition); //Substring upto the last occurence of slash.
                if (set.contains(currFolder)) {
                    //if the Parent Folder is present in String which means the current folder is a sub folder of the Parent Folder
                    isSubFolder = true;
                    break;
                }
            }
            if (!isSubFolder) { //if the current Folder is not a subfolder then only add it to the list
                list.add(tempFolder);
            }
        }
        return list;
    }
}

```
