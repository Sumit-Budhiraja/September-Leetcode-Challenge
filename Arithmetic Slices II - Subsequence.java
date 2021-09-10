class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3){
            return 0;
        }
       
        //dp.i number of arithmetic subsequences ending with i 
        List<Map<Long, Integer>> dp = new ArrayList<>();
        
        dp.add(new HashMap<>());
        int sum = 0;
        for (var i=1; i<nums.length; i++){
            Map<Long, Integer> curMap = new HashMap<>();
            dp.add(curMap);
            for (var j=0; j<i; j++){
                long diff = (long) nums[i] - nums[j];
                var v = 1;
                var preMap = dp.get(j);
                var preN = preMap.get(diff);
                if (preN != null){
                    sum+= preN;
                    v += preN;
                }
                
                var curN = curMap.get(diff);
                curMap.put(diff, curN == null ? v : (v + curN));
            }

        }
        
        return sum;
    }
}