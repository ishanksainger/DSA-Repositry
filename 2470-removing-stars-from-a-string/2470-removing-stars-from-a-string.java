class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*' && !stack.isEmpty()){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        s="";
        for (char c : stack) {
            s+=c;
        }
        return s;
    }
}