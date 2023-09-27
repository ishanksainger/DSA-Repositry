class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];
        int n=s.length();
        int m=t.length();
        for(char c:t.toCharArray()){
            freq[c]++;
        }
        int count=0,i=0, min=Integer.MAX_VALUE, minLeft=0;
        for(int j=0;j<n;j++){
            char ch=s.charAt(j);
            if(freq[ch]>0){
                count++;
            }
            freq[ch]--;
            while(count==m){
                
                if(j-i+1<min){
                    min=j-i+1;
                    minLeft=i;
                }
                char c=s.charAt(i);
                freq[c]++;
                if(freq[c]>0){
                    count--;
                }
                i++;
            }
        }
        return min==Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft+min);
    }
}