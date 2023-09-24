class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> myList = new HashSet<>();
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = -nums[i];
            int k = i + 1;
            int j = nums.length - 1;
            while (k < j) {
                if (nums[k] + nums[j] < sum) {
                    k++;
                } else if (nums[k] + nums[j] > sum) {
                    j--;
                } else {
                    subList = new ArrayList<>();
                    subList.add(nums[k]);
                    subList.add(nums[j]);
                    subList.add(-sum);
                    k++;
                    myList.add(subList);
                }
            }
        }
            return myList.stream().toList();
    }
}