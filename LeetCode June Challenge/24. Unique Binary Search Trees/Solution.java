class Solution {
    
    public int numTrees(int n) {
        
        int t[] = new int[n+1];
        t[0] = 1; //no. of tress with 0 nodes
        t[1] = 1; // no. of trees with 1 nodes
        
        //Here we try to find no. of trees with nodes = i
        for(int i = 2; i  <= n; i++){
            
            /*Now to get no of trees with i nodes, we check all the possibles
            i.e if 1 is root, if 2 is root upto i  */
            for(int j = 1; j <= i; j++){
                
                /*If j is the root of tree, we have to find no of trees
                in lst and rst
                
                We can have numbers from 1 to j-1 in lst bcoz it is bst
                and numbers from j+1 to i in rst.
                
                So for left sub tree, we for lst we find no. of trees possible with
                (j-1) nodes
                And for RST, we find  bst possible with (i-j) nodes
                
                and we do croos product of these bst to get treese possible with i nodes
                and j as root
                Now to get get all trees, we sum bst possible with diff bases*/
                
                t[i] += t[j-1] * t[i-j];
                
            }
        }
        
        return t[n];
    }
}