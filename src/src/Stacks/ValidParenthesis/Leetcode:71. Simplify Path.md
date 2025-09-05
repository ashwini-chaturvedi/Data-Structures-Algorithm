 # Why we use stack?
  when there is a equation,arrangement in which there is a sense of removing the latest element or going out of the current state always try to use stack 
    e.g here when we get '..' we have to move out of the currDir so we will use Stack...
    
```java
class Solution {
    public String simplifyPath(String path) {
        String[] pathArr=path.split("/");
        Stack<String>st=new Stack<>();

        for(String s:pathArr){
            if(s.equals("") || s.equals(".")) continue;
            else if(s.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(s);
            }
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
            sb.insert(0,"/");
        }

        return sb.isEmpty()?"/":sb.toString();
    }
}
```
