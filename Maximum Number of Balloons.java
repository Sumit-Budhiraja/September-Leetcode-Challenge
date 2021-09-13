class Solution {
    
    static final char[] CHARS_WITH_FREQ_1 = new char[]{'b','a','n'};
    static final char[] CHARS_WITH_FREQ_2 = new char[]{'l','o'};
    
    public int maxNumberOfBalloons(String text) {
        int[] occurrenceCount = new int[26];
        
        for(char ch: text.toCharArray()) {
            occurrenceCount[ch-'a']++;
        }
        
        int ans = Integer.MAX_VALUE;
        for(char ch: CHARS_WITH_FREQ_1)
            ans = Math.min(ans,occurrenceCount[ch-'a']);
        
        for(char ch: CHARS_WITH_FREQ_2) 
            ans = Math.min(ans, occurrenceCount[ch-'a']/2);
        
        return ans;
    }
}