import java.util.ArrayList;
import java.util.Arrays;

public class q3 {

    static ArrayList<int[]> threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(new int[]{
                        nums[i],
                        nums[left],
                        nums[right]
                    });

                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        ArrayList<int[]> result = threeSum(nums);

        for (int[] arr : result) {

            System.out.print("[");

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);

                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }
    }
}