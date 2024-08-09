package Stacks;

public class iyhs {

        public static int timeRequiredToBuy(int[] tickets, int k) {
            int r=0;
            if(k==0){
                r=1;
            }else{
                r=k;
            }
            int time=0;
            for(int i=0;i<r;i++){
                for(int j=0;j<tickets.length;j++){
                    tickets[j]=tickets[j]-1;
                    time++;
                }
            }
            if(tickets[k]!=0){
                time=time+tickets[k];

            }
            return time;
        }

    public static void main(String[]args){
            int []num={5,1,1,1};
            int k=0;
        System.out.println(timeRequiredToBuy(num,k));

    }
}
