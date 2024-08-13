class Solution {
    public int myAtoi(String s) {
        int res = 0, i = 0, sign = 1;
        
        // Skip whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        // Check for sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        
        // Convert number and avoid overflow
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i++) - '0';
            
            // Check for overflow
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res = res * 10 + digit;
        }
        
        return res * sign;
    }
}
