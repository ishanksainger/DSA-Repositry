class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0; res < m && i < n; i++) {
            if (s[i] >= g[res]) {
                res++;
            }
        }
        return res;
    }
}