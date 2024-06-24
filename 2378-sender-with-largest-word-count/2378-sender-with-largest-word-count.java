class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
               HashMap<String, Integer> wordCountMap = new HashMap<>();
        int n = messages.length;
        
        for (int i = 0; i < n; i++) {
            String sender = senders[i];
            int wordCount = messages[i].split(" ").length;
            
            wordCountMap.put(sender, wordCountMap.getOrDefault(sender, 0) + wordCount);
        }
        
        String result = "";
        int maxWordCount = 0;
        
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String sender = entry.getKey();
            int wordCount = entry.getValue();
            
            if (wordCount > maxWordCount) {
                result = sender;
                maxWordCount = wordCount;
            } else if (wordCount == maxWordCount) {
                if (sender.compareTo(result) > 0) {
                    result = sender;
                }
            }
        }
        return result;
    }
}