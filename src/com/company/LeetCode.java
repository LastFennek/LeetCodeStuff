package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
    }

    public static int[] nums;
    public static List<List<Integer>> fourSum(int[] A, int target){
        ret = new ArrayList<>();
        int anzahlNummern = 4;

        if (A.length <  4) return ret;

        nums = A;
        Arrays.sort(nums);

        int minsum = 0, sum = 0;
        for(int j = 0; j < nums.length; j++){
            if(j <= anzahlNummern-1){
                minsum += nums[j];
            }
            sum += nums[j];
        }
        solveForNumber(anzahlNummern,nums.length-1, target, minsum, new ArrayList<>());
        return ret;
    }

    static List<List<Integer>> ret = new ArrayList<>();
    public static void solveForNumber(int n, int end, int sum, int minsum, List<Integer> list){

        if(n == 1){
            if(Arrays.binarySearch(nums,n-1,end+1,sum) >= 0){
                ret.add(new ArrayList<>(list));
                ret.get(ret.size()-1).add(sum);
            }
            return;
        }
        if(minsum == sum){
            ret.add(new ArrayList<>(list));
            for(int j = 0; j < n; j++){
                ret.get(ret.size()-1).add(nums[j]);
            }
            return;
        }

        end = binarySearch0(nums, n-1, end, sum-(minsum-nums[n-1]))+1;

        int maxsum = 0;
        for(int x = end; x > end - n; x--) maxsum += nums[x];

        for(int i = end; i >= n; i--){
            if(maxsum < sum- (nums[i] > 0 ? nums[i] : -nums[i]))
                return;
            if(i == end || nums[i] != nums[i+1]){
                list.add(nums[i]);
                solveForNumber(n-1,  i-1, sum-nums[i], minsum-nums[n-1], list);
                list.remove(list.indexOf(nums[i]));
            }
            maxsum = maxsum-nums[i]+nums[i-n];
        }

        return;
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while(low <= high) {
            int mid = low + high >>> 1;
            int midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else {
                if (midVal <= key) {
                    return mid;
                }

                high = mid - 1;
            }
        }
        return low - 1;
    }
}
