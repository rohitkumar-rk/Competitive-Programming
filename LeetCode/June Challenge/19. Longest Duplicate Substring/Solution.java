class Solution {

    public static final long q = (1 << 31) - 1;
    public static final long R = 256;
    
    public long hash(String s, int len) { 
        long h = 0;
        for (int j = 0; j < len; j++) h = (R * h + s.charAt(j)) % q;
        return h;
    }
    
    public boolean compare(String s, int i, int j, int len) {
        for (int count = 0; count < len; count++) {
            if (s.charAt(i++) != s.charAt(j++)) return false ; 
        }
        return true ; 
    }
        
    public String longestDupSubstring(String s) {      
        int l = 2;
        int r = s.length() - 1;
        int start = 0;
        int maxLen = 0;
        
        while (l <= r) {
            int len = l + (r - l) / 2;
            boolean found = false;
            
            Map<Long, List<Integer>> map = new HashMap<>();
            long hash = hash(s, len);

            map.put(hash, new ArrayList<>());
            map.get(hash).add(0);

            long RM = 1l;

            for (int i = 1; i < len; i++)
             RM = (R * RM) % q;
            
            loop:
            for (int i = 1; i + len <= s.length(); i++) {

                hash = (hash + q - RM * s.charAt(i - 1) % q) % q;
                hash = (hash * R + s.charAt(i + len - 1)) % q;

                if (!map.containsKey(hash)) {
                    map.put(hash, new ArrayList<>());
                } 
                else {
                    for (int j : map.get(hash)) {
                        if (compare(s, i, j, len)) {
                            found = true;
                            start = i;
                            maxLen = len;
                            break loop;
                        }
                    }
                }

                map.get(hash).add(i);
            }
            if (found) l = len + 1;
            else r = len - 1;
        }
        
        return s.substring(start, start + maxLen);
    }
    
    
}