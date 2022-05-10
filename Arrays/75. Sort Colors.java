class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int middle = 0;
        int hign = nums.length - 1;
        
    while(middle <= hign){
        if(nums[middle] < 1){
            swap(nums, low, middle);
            low++;
            middle++;
        } else if(nums[middle] > 1){
            swap(nums, middle, hign);
            hign--;
        } else {
            middle++;
        }
    }
}

private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
