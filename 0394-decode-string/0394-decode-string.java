class Solution {
    public String decodeString(String s) {
        int n=s.length();
        int index=0;
        Stack<String> stack=new Stack<>();
        Stack<Integer> intStack=new Stack<>();
        String string="";
        while(index<n){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                intStack.push(count);
            }
            else if(s.charAt(index)==']'){
                StringBuilder str=new StringBuilder(stack.pop());
                int num=intStack.pop();
                for(int i=0;i<num;i++){
                    str.append(string);
                }
                string=str.toString();
                index++;
            }
            else if(s.charAt(index)=='['){
                stack.push(string);
                string="";
                index++;
            }
            else{
                string+=s.charAt(index);
                index++;
            }
        }
        return string;
    }
}