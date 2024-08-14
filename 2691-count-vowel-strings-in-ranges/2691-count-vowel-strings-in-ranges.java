class Solution {
    public boolean isVowel(char ch)
    {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int prefsum[]=new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1)))
                prefsum[i]=1;
            else
                prefsum[i]=0;
        }
        for(int i=1;i<prefsum.length;i++)
            prefsum[i]=prefsum[i]+prefsum[i-1];
        
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            if(queries[i][0]==0)
                ans[i]=prefsum[queries[i][1]];
            else
                ans[i]=prefsum[queries[i][1]]-prefsum[queries[i][0]-1];
        }
        return ans;
    }
}

