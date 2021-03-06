class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Set<List<Integer>> ans = new HashSet<>();
        List<Integer> res=new ArrayList<>();                                                               
        Arrays.sort(nums);                                           
        
        for(int i=0;i<nums.length;i++)
        {
            int target=-(nums[i]);
            HashSet<Integer> temp=new HashSet<Integer>();
            for(int j=i+1;j<nums.length;j++)
            {
                if(temp.contains(target-nums[j]))
                {
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(target-nums[j]);
                    ans.add(new ArrayList(res));
                    res.clear();
                }
                temp.add(nums[j]);
                
            }
        }
        return new ArrayList(ans);
    }
}
