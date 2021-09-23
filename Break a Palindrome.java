class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1){
            return "";
        }
        
        var chars = palindrome.toCharArray();
        // replace the first non 'a' to 'a' to get the lexicographically smallest non-palindrome string.
        for (var i=0; i<chars.length / 2; i++){
            if (chars[i] != 'a'){
                chars[i] = 'a';
                return new String(chars);
            }
        }
        // all chars (except the middle one) are 'a', then change the last char to 'b';
        chars[chars.length - 1] = 'b';
        return new String(chars);
    }
}