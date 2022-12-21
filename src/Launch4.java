public class Launch4 {
    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int[] output = new int[2];
        int target = 13;
        boolean answered = false;

        for (int i = 0; i < nums.length; i++) {
            if (!answered) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        output[0] = i;
                        output[1] = j;
                        answered = true;
                    }
                }
            } else break;
        }
        for (int each : output) {
            System.out.println(each);
        }
    }
}
