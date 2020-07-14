class Solution {
    
    public boolean validIpv4(String ip){
        String[] ipv4 = ip.split("\\.");
        
        if(ipv4.length != 4)
            return false;
        
        //Check for any alphabetic character
        for(int i = 0; i < ip.length(); i++){
            char ch = ip.charAt(i);
            if( (ch < '0' || ch > '9') && ch != '.')
                return false;
        }
        
        for(String curr : ipv4){
            if(curr.length() == 0 || curr.length() > 3)
                return false;
            
            int num = Integer.parseInt(curr);
            
            //Check for leading zero
            if(curr.charAt(0) == '0' && curr.length() != 1)
                return false;
            
            //Check for range 0 to 255
            if(num < 0 || num > 255)
                return false;
        }
        
     
        return true;
    }
    
    public boolean validIpv6(String ip){
        String[] ipv6 = ip.split("\\:");
        String hexa = "0123456789abcdefABCDEF";
        
        if(ipv6.length != 8)
            return false;
        
        for(String curr : ipv6){
            System.out.println("curr : " + curr);
            //1 group contains atleast 1 character
            //and atmost 4 characters
            if(curr.length() < 1 || curr.length() > 4)
                return false;
            
            //now check for each ch for hexa range
            for(Character ch : curr.toCharArray()){
                if(hexa.indexOf(ch) == -1)
                    return false;
            }
            
        }
        
        return true;
        
    }
    
    public String validIPAddress(String ip) {
        
        if(ip.chars().filter(ch -> ch == '.').count() == 3) {
            if(validIpv4(ip))
                return "IPv4";
        }
        
        else if(ip.chars().filter(ch -> ch == ':').count() == 7) {
            if(validIpv6(ip))
                return "IPv6";
        }
        
        return "Neither";
    }
}