class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            char peek = 0;
            if (!stack.isEmpty()) {
                peek = stack.peek();
            }
            stack.push(c);
            if (!stack.isEmpty()) {
                switch (c) {
                    case '}':
                        if (peek == '{') {
                            stack.pop();
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (peek == '[') {
                            stack.pop();
                            stack.pop();
                        }
                        break;
                    case ')':
                        if (peek == '(') {
                            stack.pop();
                            stack.pop();
                        }
                        break;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
