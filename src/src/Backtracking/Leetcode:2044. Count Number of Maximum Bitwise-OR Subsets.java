class Solution {

    public int FindOR(List<Integer> list) {
        int or = 0;
        for (int i = 0; i < list.size(); i++) {
            or |= list.get(i);
        }
        return or;
    }

    public void solve(int[] nums, int idx, List<Integer> list, int[] ans,int maxOr) {
        if (!list.isEmpty()) {
            int currOr=FindOR(list);
            if(currOr==maxOr){//if the current or is equal to maximum possible or which is the or of whole array then increase the count.
                ans[0]++;
            }
        }

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);//Including the element
            solve(nums, i+1, list, ans,maxOr);//i+1 because we don't want to Include Duplicate Element.
            list.remove(list.size() - 1);//Backtrack
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        if (nums.length == 1) return 1;

        int maxOr=0;
        for(int num:nums){//The maximum bitwise-OR is the bitwise-OR of the whole array.
            maxOr|=num;
        }

        int[] ans = {0};
        List<Integer> list = new ArrayList<>();
        solve(nums, 0, list, ans,maxOr);
        return ans[0];
    }
}
