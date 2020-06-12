class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //HashSet to store all words in bag, for easy checking
        HashSet<String> bag = new HashSet<String>(wordList);
        HashSet<String> visited = new HashSet<String>();
        Queue<String> pendingVertices = new LinkedList<String>();
        int steps = 0;

        //If endWord is not present in bag, return 0
        if(!bag.contains(endWord))
          return 0;

        //Add begin word to queue
        pendingVertices.add(beginWord);

        while(!pendingVertices.isEmpty()){
            
            steps++;
            int qSize = pendingVertices.size();
            
            for(int q = 0; q < qSize; q++){
                
                String currWord = pendingVertices.remove();
                visited.add(currWord);
                
                /* Now for each character on currWord, replace ith character
                with all alphabets i.e. a - z  */
                for(int i = 0; i < currWord.length(); i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        String newWord;
                        char[] word = currWord.toCharArray();
                        
                        word[i] = ch;
                        newWord = String.valueOf(word);
                    
                        //If newWord is endWord, return steps
                        if(newWord.equals(endWord))
                            return steps+1;

                        //If bag contains new word and it is not visited yet,
                        //Add it to queue
                        if(bag.contains(newWord) &&  !visited.contains(newWord))
                            pendingVertices.add(newWord);

                    }
                }

                
            }
             
        } //while loop ends here
        return 0;
        
    }
}