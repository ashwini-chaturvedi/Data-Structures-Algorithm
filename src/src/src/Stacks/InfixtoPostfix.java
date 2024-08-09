package Stacks;

import java.util.Stack;

public class InfixtoPostfix {
    public static void main(String[]args){
        String Infix="9-(5+3)*4/6";
        Stack<String> num=new Stack<>();
        Stack<Character>operator=new Stack<>();

        for(int i=0;i<Infix.length();i++){
            int asciiVal=(int)Infix.charAt(i);
            if(asciiVal>=48&&asciiVal<=57){
                num.push(""+Infix.charAt(i));//we will push the character as a string into the stack...
            }else if(operator.isEmpty()||Infix.charAt(i)=='('||operator.peek()=='('){
                operator.push(Infix.charAt(i));
            }else if(Infix.charAt(i)==')'){
                //means that character is operator type and stack is not Empty
                //Now we will do the calculations.
                // we will check priority and do calculations
                while(operator.peek()!='('){
                    //Do the work these are the least prioritised
                    String v2=num.pop();
                    String v1=num.pop();
                    char op=operator.pop();

                    String ans=v1+v2+op;
                    num.push(ans);
                }
                operator.pop();
            }  else {
                if(Infix.charAt(i)=='+'||Infix.charAt(i)=='-') {

                    //Do the work these are the least prioritised
                    String v2=num.pop();
                    String v1=num.pop();
                    char op=operator.pop();

                    String ans=v1+v2+op;
                    num.push(ans);
                    operator.push(Infix.charAt(i));
                }

            }
            if(Infix.charAt(i)=='*'||Infix.charAt(i)=='/'){
                if(operator.peek()=='*'||operator.peek()=='/'){
                    //Do the work these are the least prioritised
                    String v2=num.pop();
                    String v1=num.pop();
                    char op=operator.pop();

                    String ans=v1+v2+op;
                    num.push(ans);
                    operator.push(Infix.charAt(i));
                }else{
                    operator.push(Infix.charAt(i));
                }
            }

        }
        //Extracting the Answer
        while(num.size()>1){
            String v2=num.pop();
            String v1=num.pop();
            char op=operator.pop();

            String ans=v1+v2+op;
            num.push(ans);
        }
        System.out.println("Answer:"+num.peek());
    }
}
