class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,m=0,n=nums.length;
        while(m<n){
            if(nums[m]!=0){
                int d=nums[i];
                nums[i]=nums[m];
                nums[m]=d;
                i++;
            }
            m++;
        }
    }
}
