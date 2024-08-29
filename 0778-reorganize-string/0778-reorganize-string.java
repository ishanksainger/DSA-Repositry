class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        StringBuilder str = new StringBuilder();
        while (pq.size() >= 2) {
            char a = pq.poll();
            char b = pq.poll();

            str.append(a);
            str.append(b);

            map.put(a, map.getOrDefault(a, 0) - 1);
            map.put(b, map.getOrDefault(b, 0) - 1);

            if(map.get(a)>0) pq.add(a);
            if(map.get(b)>0) pq.add(b);
        }
        if(!pq.isEmpty()){
            char ch=pq.poll();
            if(map.get(ch) > 1) return "";  
            str.append(ch);
        }
        return str.toString();
    }
}