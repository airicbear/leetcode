class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        Map<Integer, StringBuilder> map = new HashMap<>();
        int gapSize = numRows - 2;
        int cycleSize = numRows + gapSize;
        int numCycles = s.length() / cycleSize;
        int numTrailing = s.length() % cycleSize;
        
        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }
        
        // Map letters to row number for each cycle
        for (int i = 0; i < numCycles; i++) {
            
            int rowTop = cycleSize*i;
            
            // Map letter to first row
            map.get(0).append(s.charAt(rowTop));
            
            // Map letters with gaps to each row
            for (int j = 1; j < numRows - 1; j++) {
                int rowLo = j + rowTop;
                int rowHi = j + rowTop + 2*(numRows-2) - 2*(j-1);
                
                map.get(j).append(s.charAt(rowLo));
                map.get(j).append(s.charAt(rowHi));
            }
            
            // Map letter to last row
            int rowBottom = (numRows - 1) + rowTop;
            map.get(numRows - 1).append(s.charAt(rowBottom));
        }
        
        // Map any remaining letters to a row number
        if (numTrailing > 0) {
            
            int rowTop = cycleSize*numCycles;
            
            // Map letter to first row
            map.get(0).append(s.charAt(rowTop));
            
            // Map letters with gaps to each row
            for (int j = 1; j < numRows - 1; j++) {
                int rowLo = j + rowTop;
                int rowHi = j + rowTop + 2*(numRows-2) - 2*(j-1);

                if (rowLo < s.length()) {
                    map.get(j).append(s.charAt(rowLo));
                }
                if (rowHi < s.length()) {
                    map.get(j).append(s.charAt(rowHi));
                }
            }
            
            // Map letter to last row if the letter exists
            int rowBottom = (numRows - 1) + rowTop;
            if (rowBottom < s.length()) {
                map.get(numRows - 1).append(s.charAt(rowBottom));
            }
        }
        
        // Concatenate each row into a String
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            out.append(map.get(i).toString());
        }
        
        return out.toString();
    }
}
