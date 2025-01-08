package Session9;

public class TwoNumArraySolution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums1, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
