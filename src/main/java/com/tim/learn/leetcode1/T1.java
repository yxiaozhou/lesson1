package com.tim.learn.leetcode1;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/3/5/005 16:41
 * @Version: 1.0
 */
public class T1 {

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.setAge("1");
        t1.setName("12");
        t1.setSex("123");

        Test1 t2 = new Test1();
        t2.setAge("100");
        BeanUtils.copyProperties(t2,t1);
        System.out.println(JSON.toJSONString(t1));
    }
}

class Test1{

    private String name;
    private String age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
