package com.tim.learn.leetcode1;

import java.util.LinkedHashMap;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/1/27/027 14:38
 * @Version: 1.0
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 */
public class T12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(2349));
    }
    public static String intToRoman(int num) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1000,"M");
        linkedHashMap.put(900,"CM");
        linkedHashMap.put(500,"D");
        linkedHashMap.put(400,"CD");
        linkedHashMap.put(100,"C");
        linkedHashMap.put(90,"XC");
        linkedHashMap.put(50,"L");
        linkedHashMap.put(40,"XL");
        linkedHashMap.put(10,"X");
        linkedHashMap.put(9,"IX");
        linkedHashMap.put(5,"V");
        linkedHashMap.put(4,"IV");
        linkedHashMap.put(1,"I");
        if(num < 1 && num > 3999){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(int key : linkedHashMap.keySet()){
            if(num / key >0){
                for(int i = 0; i < num /key;i++){
                    sb.append(linkedHashMap.get(key));
                }
                num = num%key;
            }
        }
        return sb.toString();
    }
}
