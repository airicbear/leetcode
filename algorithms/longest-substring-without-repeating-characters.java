class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int length = 0;
        
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                while (set.contains(c)) {
                    set.remove(set.iterator().next());
                }
            }
            
            set.add(c);
            
            if (set.size() > length) {
                length = set.size();
            }
        }
        
        return length;
    }
}
