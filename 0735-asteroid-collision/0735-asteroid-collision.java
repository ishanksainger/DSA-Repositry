class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty() || asteroids[i]>0){
                stack.push(asteroids[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek() < Math.abs(asteroids[i])){
                        stack.pop();
                    }
                if(stack.isEmpty() || stack.peek()<0){
                    stack.push(asteroids[i]);
                }
                else if(stack.peek() == Math.abs(asteroids[i])){
                     stack.pop();
                }   
            }
        }
        int[] res=new int[stack.size()];
        int index=stack.size()-1;
        while(!stack.isEmpty()){
            res[index]=stack.pop();
            index--;
        }
        return res;
    }
}