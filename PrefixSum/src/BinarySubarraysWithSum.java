import java.util.Arrays;
import java.util.HashMap;

class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        int sum = 0, count = 0, prefixSum = 0;

        frequency.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            sum = prefixSum - goal;
            count += frequency.getOrDefault(sum, 0);
            frequency.put(prefixSum, frequency.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum sol = new BinarySubarraysWithSum();

        // Define testcases: {nums array, goal, expected result}
        Object[][] testcases = {
                {new int[]{0,0,0,0,0}, 0, 15},
                {new int[]{1,0,1,0,1}, 2, 4},
                {new int[]{1,1,1}, 2, 2},
                {new int[]{0,1,0}, 1, 4},
                {new int[]{1}, 1, 1},
                {new int[]{0}, 0, 1},
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

