package All_Singly_LinkedList;

import java.util.Scanner;

class ode{
    int data;
    ode next;


    ode(int val){
        this.data=val;
        this.next=null;
    }
    public ode setList(ode Head,int val){
        ode newHead=new ode(val);
        newHead.next=Head;
        Head=newHead;
        return Head;

    }
    public void displayList(ode Head){
        int count=0;
        ode temp=Head;
        System.out.print("Head->");
        while(temp!=null){
            System.out.print(temp.data+"->");
            count++;
            temp=temp.next;
        }
        System.out.print("Tail");
        System.out.print("\n"+count);

    }
    public  void displayRecursively(ode Head){
        if(Head==null){
            return;
        }

        System.out.print(Head.data+"->");

        displayRecursively(Head.next);
    }
    public  void reverseRecursively(ode Head){
        if(Head==null){
            return;
        }
        reverseRecursively(Head.next);
        System.out.print(Head.data+"->");
    }

}

public class Basics {
    public static void main(String[]args){
        ode Head=null;
        Scanner Input=new Scanner(System.in);
        int val;
        for(int i=0;i<5;i++){

            System.out.print("Enter the key");
            System.out.println();
            val=Input.nextInt();
            if(Head==null){
                Head=new ode(val);
            }else{
                Head=Head.setList(Head,val);
            }
            Head.setList(Head,val);



        }
        Head.displayList(Head);
        System.out.println("\nDisplaying Recursively");
        Head.displayRecursively(Head);
        System.out.println("\nDisplaying Recursively Reverse");
        Head.reverseRecursively(Head);



    }
}
