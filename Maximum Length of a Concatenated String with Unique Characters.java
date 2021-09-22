class Solution {
    public int maxLength(List<String> arr) {
        
        List<String> resultSet = new ArrayList<>();
        resultSet.add("");
        int len = 0;
        
        for(String str : arr){
            
            List<String> tempList = new ArrayList<>();
            
            for(String res : resultSet){
                String tempStr = res + str;
                
                if(isUnique(tempStr)){
                    tempList.add(tempStr);
                    len = Math.max(len, tempStr.length());
                }
            }
            
            resultSet.addAll(tempList); // adding tempList contents to resultSet
        }
        return len;
    }
    
    public boolean isUnique(String str){
        if(str.length()>26) return false;
        
        int[] freq = new int[26];
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
            
            if(freq[ch-'a']>1){
                return false;
            }
        }
        return true;
    }
}