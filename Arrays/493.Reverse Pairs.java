class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    // Normal MergeSort recursive function
    public int mergeSort(int[] nums, int left, int right) {
        if(left == right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += modifiedMerge(nums, left, mid, right);
        return count;
    }
    public int modifiedMerge(int[] nums, int left, int mid, int right) {
        // Modified Step 0: Cleaverly increment the count based on the condition (do a dryrun to understand better)
        int count=0;
        int t = mid + 1; 
        for(int i = left; i <= mid; i++) {
            while(t <= right && nums[i] > (2 * (long) nums[t])) {
                t++;
            }
            count += (t - (mid + 1));
        }
        // Normal MergeSort Step 1: Create temp arrays to be merged
        int n1 = mid - left + 1, n2 = right - mid, i, j;
        int[] tempL = new int[n1];
        int[] tempR = new int[n2];
        for(i = 0; i < n1; i++) tempL[i] = nums[left + i];
        for(j = 0; j < n2; j++) tempR[j] = nums[mid + 1 + j];
        // Normal MergeSort Step 2: Merge temp arrays into the original array
        i = j = 0;
        int k = left;
        while(i < n1 && j < n2)   nums[k++] = (tempL[i] <= tempR[j]) ? (tempL[i++]) : (tempR[j++]);
        while(i < n1) nums[k++] = tempL[i++];
        while(j < n2) nums[k++] = tempR[j++];
        return count;
    }
}
