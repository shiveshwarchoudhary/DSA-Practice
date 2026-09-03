import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        // loop chalao pura array traversse karne ke liye
        for(int i = 0; i<n-2;i++){
            // edge case 
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left  = i+1;
            int right = n-1;
            int target = -nums[i];

            while(left<right){
                int sum = nums[left]+nums[right];

                if(sum == target){
                    result.add(Arrays.asList(nums[i], nums[left],nums[right] ));

                    left++;
                    right--;

                    // skip dublicate left value
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    // skip dublicate right value
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
                else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}
