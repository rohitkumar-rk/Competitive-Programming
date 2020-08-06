/**

@lc id : 151
@problem : Reverse Words in a String
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/reverse-words-in-a-string/
@difficulty : medium
*/

class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.trim().split("\\s+");
        
        String reverseWord = "";
        int len = words.length;
        
        for(int i = len-1; i >= 0; i-- ){
            
            reverseWord += words[i];
            
            if(i != 0)
                reverseWord += " ";
        }
        
        return reverseWord;
    }
}