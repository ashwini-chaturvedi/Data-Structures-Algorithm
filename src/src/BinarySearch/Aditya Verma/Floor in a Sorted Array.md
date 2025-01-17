```java
class Solution {

    static int findFloor(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            //Handle less than and equal to mid case in one 'if'
            if(arr[mid]<=k){//if the number is less than equal to the target
                ans=mid;//then store it as potential Answer
                low=mid+1;//Move to Higher Value because we want to find the largest value which is near to target
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.findFloor(arr, k);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}
```
