class Solution {
   public boolean canPartitionKSubsets(int[] nums, int k) {
	var sum = IntStream.of(nums).sum();
	if (sum % k != 0)
		return false;
	return canPartitionKSubsets(nums, k, 0, 0, sum / k, new boolean[nums.length]);
}

private boolean canPartitionKSubsets(int[] nums, int k, int start, int currentBucketSum, int targetBucketSum, boolean[] used) {
	if (k == 1)
		return true;
	if (currentBucketSum > targetBucketSum)
		return false;
	if (currentBucketSum == targetBucketSum)
		return canPartitionKSubsets(nums, k - 1, 0, 0, targetBucketSum, used);
	// for each choice
	for (var i = start; i < nums.length; i++) {
		if (used[i])
			continue;
		// choose
		used[i] = true;
		// explore
		if (canPartitionKSubsets(nums, k, i + 1, currentBucketSum + nums[i], targetBucketSum, used))
			return true;
		// un-choose
		used[i] = false;
	}
	return false;
}
}