package Stacks;

import java.util.Stack;

public class ex {
    public static int minOperations(String[] logs) {
        Stack<String> stack=new Stack<>();
        int count=0;
        for(String str:logs){
            if(str.equals("../")){
                if(stack.isEmpty()){
                    count++;
                    continue;
                }
                stack.pop();

            }else if(str.equals("./")){
                continue;
            }else{
                stack.push(str);
            }

        }
        return stack.isEmpty()?0:stack.size();
    }
    public static void main(String[] args) {
        String[]a={"./","../","./"};
        System.out.println(minOperations(a));
        StringBuilder sb=new StringBuilder();
        sb.append('8');
        sb.append('9');
        sb.insert(0,3);
        sb.insert(0,4);
        sb.insert(sb.length(),6);
        sb.insert(sb.length(),7);
        System.out.println(sb);
        String h="ab";
        StringBuilder sv=new StringBuilder(h);
        System.out.println(sv.deleteCharAt(1));


    }
}
