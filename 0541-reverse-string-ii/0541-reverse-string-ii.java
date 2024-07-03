class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < s.length() - 1; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            // All three conditions match
            //1 . we move by 2k and get the end and then do while and reverse the k
            //2. if n less than k then minimum will be length so it will reverse string characters
            //3. if less than 2k then it will reverse first and when it will increment 2k then it will exit
            
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        
        return new String(chars);
    }
}

// TC: O(n), SC: O(n)