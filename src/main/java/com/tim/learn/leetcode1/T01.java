package com.tim.learn.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2022/2/14/014 16:38
 * @Version: 1.0
 */
public class T01 {

//    public int[] twoSum(int[] nums, int target) {
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[i]+nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[]{};
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> rem = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(rem.containsKey(target-nums[i])){
                return new int[]{rem.get(target-nums[i]),i};
            }
            rem.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] it = new T01().twoSum(new int[]{3,2,4},6);
        for (int i : it) {
            System.out.println(i);
        }
    }
}
