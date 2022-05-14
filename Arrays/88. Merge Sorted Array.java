class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i=m-1,j=n-1,ind = m+n-1;
        while(i>=0 && j>=0)
        {
            if(arr2[j] > arr1[i])
            {
                arr1[ind] = arr2[j];
                j--;
            }
            else{
                arr1[ind] = arr1[i];
                i--;
            }
            ind--; 
        }
        while(j>=0) 
        {
            arr1[ind] = arr2[j];
            ind--;
            j--;
        }
    }
}
