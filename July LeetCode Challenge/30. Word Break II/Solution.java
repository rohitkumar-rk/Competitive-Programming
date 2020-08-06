/**

@lc id : 140
@problem : Word Break II
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/word-break-ii/
@difficulty : hard
*/

class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        int length = s.length();
        List<String>[] result = new ArrayList[length];
        wordBreakHelper(0, length, result, s, wordDict);
        return result[0];
    }
    
    public List<String> wordBreakHelper(int position, int length, List<String>[] result,
                                       String s, List<String> wordDict){
        
        if(result[position] != null)
            return result[position];
        
        List<String> currString  = new ArrayList();
        
        for(String word : wordDict){
            if(s.startsWith(word, position)){
                if(position + word.length() == length){
                    currString.add(word);
                    continue;
                }
                
                List<String> strings = wordBreakHelper(position + word.length(), length,
                                                      result, s, wordDict);
                
                for(String str : strings){
                    currString.add(word + " " + str);
                }
                
            }
        }
        
        result[position] = currString;
        return currString;
    }
    
    
}