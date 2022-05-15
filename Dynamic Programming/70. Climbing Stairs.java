class Solution {
    public int climbStairs(int n) {
        if (n < 3) 
            return n;
    
        Stack<Integer> stairs = new Stack<>();
        
        stairs.push(1);
    
        int current = 2;
    
        while (n > 2){
            current = stairs.peek() + stairs.push(current);
            n--;
        }

        return current;
    }
}
