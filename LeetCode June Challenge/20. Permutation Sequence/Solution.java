class Solution {
    
    public void calculateFactorial(int n, int[] fact){
        fact[0] = 1;
        
        for(int i = 1; i <= n;i++)
            fact[i] = i*fact[i-1];
    }
    
    public String getPermutation(int n, int k) {
        
        int[] fact = new int[n+1];
        calculateFactorial(n, fact);
        
        List<Integer> digits = IntStream.range(1, n+1).mapToObj(x -> x).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder("");
        
        k--;
        
        for(int i = 1; i <= n; i++){
            int index = k / fact[n-i];
            sb.append(digits.get(index));
            digits.remove(index);
            k -= index * fact[n-i];
        }
        
            
        return sb.toString();
        
    }
}