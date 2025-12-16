import java.util.HashMap;

public class ContainsDuplicate2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int j = map.get(nums[i]);
                    if((i-j)<= k)
                        return true;
                }
                map.put(nums[i],i);
            }
            return false;
        }

    public static void main(String[] args) {
        ContainsDuplicate2 sol = new ContainsDuplicate2();

        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println("Example 1 Output: " + sol.containsNearbyDuplicate(nums1, k1));
        // Expected: true

        // Example 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("Example 2 Output: " + sol.containsNearbyDuplicate(nums2, k2));
        // Expected: true

        // Example 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("Example 3 Output: " + sol.containsNearbyDuplicate(nums3, k3));
        // Expected: false
    }
    }

