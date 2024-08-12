class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] original = new int[26];

        for (char ch : licensePlate.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                char newChar = Character.toLowerCase(ch);
                original[newChar - 'a']++;
            }
        }
        String ans = null;
        for (String s : words) {
            int[] stringMatch = new int[26];

            for (char ch : s.toCharArray()) {
                char newChar = Character.toLowerCase(ch);
                stringMatch[newChar - 'a']++;
            }

            boolean res = true;
            for (int i = 0; i < 26; i++) {
                if (stringMatch[i] < original[i]) {
                    res=false;
                    break;
                }
            }

            if(res && (ans==null || s.length()< ans.length())){
                ans=s;
            }
        }
        return ans;

    }
}