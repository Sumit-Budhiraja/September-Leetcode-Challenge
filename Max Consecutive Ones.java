class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
	int max = 0;
	int count = 0;
	for (int n: nums) {
		count = (count + 1) * n;
		// Update max if needed
		if (count > max) {
			max = count;
		}
	}
	return max;
}
}