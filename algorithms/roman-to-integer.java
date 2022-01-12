class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        Deque<Character> queue = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (!queue.isEmpty()) {
                if (map.get(c) < map.get(queue.peek())) {
                    while (!queue.isEmpty()) {
                        result += map.get(queue.pop());
                    }
                } else if (map.get(c) > map.get(queue.peek())) {
                    int buf = map.get(c);
                    while (!queue.isEmpty()) {
                        buf -= map.get(queue.pop());
                    }
                    result += buf;
                    continue;
                }
            }
            
            queue.add(c);
        }
        
        while (!queue.isEmpty()) {
            if (map.get(queue.peekLast()) < map.get(queue.peek())) {
                while (!queue.isEmpty()) {
                    result += map.get(queue.pop());
                }
            } else if (map.get(queue.peekLast()) > map.get(queue.peek())) {
                int buf = map.get(queue.peekLast());
                while (!queue.isEmpty()) {
                    buf -= map.get(queue.pop());
                }
                result += buf;
                continue;
            } else {
                result += map.get(queue.pop());
            }
        }
        
        return result;
    }
}
