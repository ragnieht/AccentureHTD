import java.util.Arrays;

public class LaunchTotalSums {
    public static void main(String[] args) {
        int nums[] = { 6,3,4,2 };
        int output[] = totalMulti(nums);
        System.out.println(Arrays.toString(output));
    }

    static int[] totalMulti(int[] nums) {
        int product = 1;
        int output[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = product/nums[i];
        }
        return output;
    }
}
