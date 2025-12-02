import java.util.*;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] prefixSum = new int[nums.length];
        HashMap<Integer, Integer> frequency = new HashMap<>();

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int sum = 0, count = 0;
        frequency.put(0, 1);  // critical

        for (int i = 0; i < prefixSum.length; i++) {
            // COUNT first
            sum = prefixSum[i] - goal;
            count += frequency.getOrDefault(sum, 0);

            // THEN PUT current prefix
            frequency.put(prefixSum[i],
                    frequency.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }

    // MAIN METHOD WITH STRUCTURED TESTCASES
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Define testcases: {nums array, goal, expected result}
        Object[][] testcases = {
                {new int[]{0,0,0,0,0}, 0, 15},
                {new int[]{1,0,1,0,1}, 2, 4},
                {new int[]{1,1,1}, 2, 2},
                {new int[]{0,1,0}, 1, 4},
                {new int[]{1}, 1, 1},
                {new int[]{0}, 0, 1}
        };

        // Run testcases
        for (int i = 0; i < testcases.length; i++) {
            int[] nums = (int[]) testcases[i][0];
            int goal = (int) testcases[i][1];
            int expected = (int) testcases[i][2];

            int actual = sol.numSubarraysWithSum(nums, goal);

            System.out.println("Testcase " + (i + 1));
            System.out.println("Input: nums = " + Arrays.toString(nums) + ", goal = " + goal);
            System.out.println("Expected: " + expected + ", Actual: " + actual);
            System.out.println(actual == expected ? "✅ Passed" : "❌ Failed");
            System.out.println("-----------------------------------");
        }
    }
}
