package Trees;

public class hfd {

    public static boolean solve(int[]arr,int start,int[]t){
        if(t[0]==arr.length){
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        if (start + arr[start] >= arr.length) {
            start = Math.abs(start - arr[start]);
            t[0]++;
        } else if(start + arr[start] < arr.length) {
            start = start + arr[start];
            t[0]++;
        }
        return solve(arr, start,t);
    }

    public static void main(String[] args) {
        int[]arr={3,0,2,1,2};
        int strt=2;
        int[]t={0};
        System.out.println(solve(arr,strt,t));
    }
}
