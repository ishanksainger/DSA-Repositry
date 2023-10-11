class Solution {
    public int calculate(String s) {
        s=s.replaceAll("\\s","");
        Stack<Integer> stack=new Stack<>();
         int sum=0,sign=1;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
               int num=0;
               while(s.length() > i && s.charAt(i)>='0' && s.charAt(i)<='9'){
                   num=num*10+(s.charAt(i)-'0');
                   i++;
                }
                sum+=num*sign;
                i--;
            }
            else if(s.charAt(i)=='+'){
                sign=1;
            }
            else if(s.charAt(i)=='-'){
                sign=-1;
            }
            else if(s.charAt(i)=='('){
                stack.push(sum);
                stack.push(sign);
                sign=1;
                sum=0;
            }
            else if(s.charAt(i)==')'){
               sum=sum*stack.pop();
               sum+=stack.pop();
            }
        }
        return sum;        
    }
}