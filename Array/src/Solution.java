public class Solution {
    public int search(int [] nums,int target){
        double[] num = new double[0];
        if (target < num[0] ||target>nums[nums.length-1]) {
          return -1;
        }
        int left=0,right=num.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]<target) {
                left=mid-1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
