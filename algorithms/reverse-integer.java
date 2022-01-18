class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (x != 0) {
            int digit = x % 10;
            if (digit < 0) {
                stack.push(-digit);
            } else {
                stack.push(digit);   
            }
            x /= 10;
        }
        int result = 0;
        int pow = 1000000000;
        int ptr = 0;
        Iterator<Integer> stackIter = stack.descendingIterator();
        if (stack.size() == 10) {
            boolean valid = false;
            if (isNegative) {
                int next = stackIter.next();
                valid = next == -(Integer.MIN_VALUE / pow) % 10;
                while (stackIter.hasNext() && valid) {
                    pow /= 10;
                    next = stackIter.next();
                    valid = next == -(Integer.MIN_VALUE / pow) % 10;
                }
                if (pow == 1) {
                    valid = next < 8;
                } else {
                    valid = next < -(Integer.MIN_VALUE / pow) % 10;
                }
            } else {
                int next = stackIter.next();
                valid = next == (Integer.MAX_VALUE / pow) % 10;
                while (stackIter.hasNext() && valid) {
                    pow /= 10;
                    next = stackIter.next();
                    valid = next == (Integer.MAX_VALUE / pow) % 10;
                }
                valid = next < (Integer.MAX_VALUE / pow) % 10;
            }
            if (!valid) {
                return 0;
            }
        }
        
        pow = 1;
        while (!stack.isEmpty()) {
            result += stack.pop() * pow;
            pow *= 10;
        }
        
        if (isNegative) {
            return -result;
        }
        return result;
    }
}
