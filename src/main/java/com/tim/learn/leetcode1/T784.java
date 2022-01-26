package com.tim.learn.leetcode1;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/1/26/026 9:20
 * @Version: 1.0
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345"
 * 输出：["12345"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T784 {

    public static void main(String[] args) {
        List<String> r = letterCasePermutation("RmR");
        System.out.println(JSON.toJSONString(r));
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] charArray = S.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }

    private static void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            System.out.println("before:"+new String(charArray));
            charArray[index] ^= 1 << 5;
            System.out.println("end:"+new String(charArray));
            dfs(charArray, index + 1, res);
        }
    }
//    public static List<String> letterCasePermutation(String s) {
//        Set<String> result = new HashSet<>();
//        char[] chars = s.toString().toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char c = chars[i];
//            chars[i] = Character.toUpperCase(c);
//            String str = new String(chars);
//            result.add(str);
//            char[] cha = str.toString().toCharArray();
//            for (int j = 0; j < cha.length; j++) {
//                char ch = cha[j];
//                cha[j] = Character.toLowerCase(ch);
//                String strnew = new String(cha);
//                System.out.println(strnew);
//                result.add(strnew);
//                char[] cha2 = strnew.toString().toCharArray();
//                for (int t = 0; t < cha2.length; t++) {
//                    char ch2 = cha2[t];
//                    cha2[t] = Character.toUpperCase(ch2);
//                    String strnew2 = new String(cha2);
//                    result.add(strnew2);
//                    char[] cha3 = strnew2.toString().toCharArray();
//                    for (int k = 0; k < cha3.length; k++) {
//                        char ch3 = cha3[k];
//                        cha3[k] = Character.toLowerCase(ch3);
//                        String strnew3 = new String(cha3);
//                        result.add(strnew3);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(result);
//    }
}
