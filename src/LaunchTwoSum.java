import java.util.Arrays;

public class LaunchTwoSum {
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        int output[] = twoSums(nums, target);
        System.out.println(Arrays.toString(output));
    }

    static int[] twoSums(int nums[], int target) {
        int output[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                    break;
                }
            }
        }
        return output;
    }
}
