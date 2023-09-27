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
// Intution behind this logic is 
// 1. We are increasing freq of the t string in our array because there could be duplicates
// 2. Then in second loop we are increasing the count so that we can know when it reaches the length of t string
// 3. Also we are decreasing the freq of every char so that everyone reaches -1 except those who are in t
// 4. Now we will run while loop once count reaches t length, so that we can check min length of i and j and move our window of i.
// 5. For that we will have to keep on increasing i and keep on increasing freq array and if any char reaches more than 0 then that means we have reached the char that is in t. so we decrease count now
// 6. Use of this is that we can increase i to a point where we can get the min left and starting point is char of t.
// 7. Because those who are not in the t or if they are repeating in s will go below 0 so even if we increase their freq  then also it will not reduce our count, only those char which are repeated once and are at freq 0 we will increase their freq and decrease count so that we can move our i window, other our i will keep on moving, which will obv help us to get the min window