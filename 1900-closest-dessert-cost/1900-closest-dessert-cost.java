class Solution {
    int min = Integer.MAX_VALUE;
    int result = 0;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int num : baseCosts) {
            dfs(num, 0, toppingCosts, target);
        }
        return result;
    }

    private void dfs(int cost, int topIndex, int[] toppingCosts, int target) {
        if (Math.abs(target - cost) < min || (Math.abs(target - cost) == min && cost < result)) {
            min = Math.abs(target - cost);
            result = cost;
        }

        if (topIndex == toppingCosts.length || cost >= target) {
            return;
        }
        dfs(cost, topIndex + 1, toppingCosts, target);
        dfs(cost + toppingCosts[topIndex], topIndex + 1, toppingCosts, target);
        dfs(cost + toppingCosts[topIndex] * 2, topIndex + 1, toppingCosts, target);
    }
}