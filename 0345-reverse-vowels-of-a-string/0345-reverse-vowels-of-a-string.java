class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        int i=0,j=n-1;
        char[] ch=s.toCharArray();
        String lower="aeiou";
        String upper="AEIOU";
        while(i<j){
            if((lower.contains(Character.toString(ch[i])) || upper.contains(Character.toString(ch[i]))) && (lower.contains(Character.toString(ch[j]))  || upper.contains(Character.toString(ch[j])))){
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
            }
            else if(lower.contains(Character.toString(ch[i])) || upper.contains(Character.toString(ch[i])) ){
                j--;
                continue;
            }
            else if(lower.contains(Character.toString(ch[j]))  || upper.contains(Character.toString(ch[j])) ){
                i++;
                continue;
            }
            i++;
            j--;
        }
        return new String(ch);
    }
}