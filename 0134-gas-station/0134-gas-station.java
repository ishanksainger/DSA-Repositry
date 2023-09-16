class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            totalGas += diff;
            currentGas += diff;

            // If we run out of gas, reset the starting point to the next station.
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        // If totalGas is negative, it means it's impossible to complete the circuit.
        // Otherwise, the starting point is valid.
        return totalGas < 0 ? -1 : start;
    }
}
