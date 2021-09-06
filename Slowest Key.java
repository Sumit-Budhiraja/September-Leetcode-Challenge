class Solution {

public char slowestKey(int[] rT, String kP) {
    int prev = 0;
    int max = 0;
    char ch = 'a';
    for(int i=0; i<rT.length; i++){
        if(rT[i] - prev > max){
            max = rT[i] - prev;
            ch = kP.charAt(i);
        }
        else if(rT[i] - prev == max){
            max = rT[i] - prev;
            
            if((int)ch < kP.charAt(i)){
                ch = kP.charAt(i);
            }
        }
        prev = rT[i];
    }
    
    return ch;
}
}