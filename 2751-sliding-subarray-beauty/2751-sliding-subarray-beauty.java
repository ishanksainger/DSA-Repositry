class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = getMin(map, x);
        for (int i = k; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[i - k], map.getOrDefault(nums[i - k], 0) - 1);
            if (map.get(nums[i - k]) <= 0) {
                map.remove(nums[i - k]);
            }
            result[i - k + 1] = getMin(map, x);
        }
        return result;
    }

    public int getMin(TreeMap<Integer, Integer> map, int x) {
        int num = 0;
        for (Integer val : map.keySet()) {
            if (val < 0) {
                num += map.get(val);
            } else {
                return 0;
            }
            if (num >= x) {
                return val;
            }
        }
        return 0;
    }
}