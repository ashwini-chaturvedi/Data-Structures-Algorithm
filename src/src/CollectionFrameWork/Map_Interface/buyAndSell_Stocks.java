package CollectionFrameWork.Map_Interface;

public class buyAndSell_Stocks {
    public static int maxProfit(int[] prices) {
        int buy=prices[0];
        boolean isBuyed=false;
        int sell=0;
        for(int num:prices){
            if(num<buy){
                buy=num;
                isBuyed=true;
            }else if(isBuyed &&num>buy){
                sell+=num-buy;
                buy=num;
            }
        }
        return sell;
    }
    public static void main(String[] args) {
        int []prices ={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}
