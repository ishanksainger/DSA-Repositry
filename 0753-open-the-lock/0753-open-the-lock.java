import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        // Initialize a set of deadends for quick lookup
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        // Initialize a set for visited combinations
        Set<String> visited = new HashSet<>();
        // Initialize a queue for BFS
        Queue<String> queue = new LinkedList<>();
        
        // Starting point
        String start = "0000";
        
        // Check if the starting point or target is a deadend
        if (deadSet.contains(start)) return -1;
        if (start.equals(target)) return 0;
        
        // Add the starting point to the queue and mark as visited
        queue.offer(start);
        visited.add(start);
        
        // Initialize the number of turns
        int turns = 0;
        
        // BFS loop
        while (!queue.isEmpty()) {
            turns++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                // Generate all possible next states
                for (String nextState : getNextStates(current)) {
                    // If the next state is the target, return the number of turns
                    if (nextState.equals(target)) {
                        return turns;
                    }
                    // If the next state is not a deadend and not visited, add to queue
                    if (!deadSet.contains(nextState) && !visited.contains(nextState)) {
                        queue.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
        }
        
        // If target cannot be reached
        return -1;
    }
    
    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        char[] currentArray = current.toCharArray();
        
        for (int i = 0; i < 4; i++) {
            char originalChar = currentArray[i];
            
            // Turn the wheel up by 1
            currentArray[i] = originalChar == '9' ? '0' : (char) (originalChar + 1);
            nextStates.add(new String(currentArray));
            
            // Turn the wheel down by 1
            currentArray[i] = originalChar == '0' ? '9' : (char) (originalChar - 1);
            nextStates.add(new String(currentArray));
            
            // Reset the wheel to original state
            currentArray[i] = originalChar;
        }
        
        return nextStates;
    }

}
