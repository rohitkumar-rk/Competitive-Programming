class Solution {
    
    public boolean isSubsequence(String s, String t) {
        
        int sPointer = 0, tPointer = 0;
        
        while(sPointer < s.length() && tPointer < t.length()){
            if(s.charAt(sPointer) == t.charAt(tPointer++))
                sPointer++;
            
        }
        
        if(sPointer == s.length())
            return true;
        else return false;
    }
}