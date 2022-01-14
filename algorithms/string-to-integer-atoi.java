class Solution {
    public int myAtoi(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '+' || s.charAt(i) == '-') {
                if ((s.charAt(i) == '+' || s.charAt(i) == '-') && !stack.isEmpty()) {
                    break;
                } else {
                    stack.add(s.charAt(i));
                }
            } else if (s.charAt(i) == ' ') {
                if (!stack.isEmpty()) {
                    break;
                }
            } else if (stack.isEmpty()) {
                return 0;
            } else {
                break;
            }
        }
        
        int num = 0;
        int pow = 1;
        int sign = 1;
        if (!stack.isEmpty() && !Character.isDigit(stack.peekFirst())) {
            char signChar = stack.removeFirst();
            if (signChar == '-') {
                sign = -1;
            }
        }
        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.removeFirst();
        }
        if (stack.size() > 10) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (stack.size() == 10) {
            Iterator<Character> iter = stack.iterator();
            boolean clamp = false;
            int i = 9;
            if (sign == 1) {
                int nextDigit = Integer.parseInt(Character.toString(iter.next()));
                int nextMaxIntDigit = Integer.MAX_VALUE / (int) Math.pow(10, i) % 10;
                while (nextDigit == nextMaxIntDigit && iter.hasNext()) {
                    i--;
                    nextDigit = Integer.parseInt(Character.toString(iter.next()));
                    nextMaxIntDigit = Integer.MAX_VALUE / (int) Math.pow(10, i) % 10;
                }
                if (nextDigit > nextMaxIntDigit) {
                    return Integer.MAX_VALUE;
                }
            } else {
                int nextDigit = Integer.parseInt(Character.toString(iter.next()));
                int nextMinIntDigit = Math.abs(Integer.MIN_VALUE / (int) Math.pow(10, i) % 10);
                while (nextDigit == nextMinIntDigit && iter.hasNext()) {
                    i--;
                    nextDigit = Integer.parseInt(Character.toString(iter.next()));
                    nextMinIntDigit = Math.abs(Integer.MIN_VALUE / (int) Math.pow(10, i) % 10);
                }
                if (nextDigit > nextMinIntDigit) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        while (!stack.isEmpty()) {
            num += Integer.parseInt(Character.toString(stack.removeLast())) * pow;
            pow *= 10;
        }
        
        return num * sign;
    }
}
