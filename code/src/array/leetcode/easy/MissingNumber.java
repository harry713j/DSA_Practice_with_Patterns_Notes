package array.leetcode.easy;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int[] hash = new int[nums.length + 1];

        for (int num : nums){
            hash[num]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0){
                return i;
            }
        }

        return hash.length;
        // Time: O(n)
        // Space: O(n)
    }
    
    private void swap(int[] nums, int s, int e){
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }

    public int missingNumberTwo(int[] nums) {
        // we will put the elements to their correct index
        int i = 0;
        while (i < nums.length){
            int correctIndex = nums[i];
            if (correctIndex < nums.length && nums[correctIndex] != correctIndex){
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j]){
                return j;
            }
        }

        return nums.length;
        // Time: O(n)
        // Space: O(1)
    }

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        System.out.println(m.missingNumberTwo(new int[]{9,6,4,2,3,5,7,0,1}));
    }
    
}
