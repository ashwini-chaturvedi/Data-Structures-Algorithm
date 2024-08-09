package Stacks;

import java.util.Stack;

public class prifixExpression {
    public static int prefixEvaluation(String prefix){
        Stack<Integer> num=new Stack<>();
        for(int i=prefix.length()-1;i>=0;i--){
            int asciiVal=(int)prefix.charAt(i);
            if(asciiVal>=48&&asciiVal<=57){
                num.push(asciiVal-48);
            }else{
                //*=>Most Important!!!!!!!

                //as we are traversing in the reverse or from last index to first...
                // the v1 will pe top value and v2 will bw the second top value
                int v1=num.pop();
                int v2=num.pop();

                if(prefix.charAt(i)=='+')num.push(v1+v2);
                if(prefix.charAt(i)=='-')num.push(v1-v2);
                if(prefix.charAt(i)=='*')num.push(v1*v2);
                if(prefix.charAt(i)=='/')num.push(v1/v2);
            }
        }
        return num.pop();
    }
    public static String prefixExpression(String Infix){

        Stack<String>num=new Stack<>();
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

                    String ans=op+v1+v2;
                    num.push(ans);
                }
                operator.pop();
            }  else {
                if(Infix.charAt(i)=='+'||Infix.charAt(i)=='-') {

                    //Do the work these are the least prioritised
                    String v2=num.pop();
                    String v1=num.pop();
                    char op=operator.pop();

                    String ans=op+v1+v2;
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

                    String ans=op+v1+v2;
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

            String ans=op+v1+v2;
            num.push(ans);
        }
        return num.pop();
    }
    public static void main(String[]args){

        String Infix="9-(5+3)*4/6";

        String prefix=prefixExpression(Infix);
        System.out.println("PostFix Expression:"+prefix);

        System.out.println("Answer:"+prefixEvaluation(prefix));
    }
}



