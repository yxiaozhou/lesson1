package com.tim.learn.lesson1.lambda1;

import java.util.function.Supplier;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2020/11/18 20:25
 * @Version: 1.0
 */
public class Test3 {


    public static void main(String[] args) {
//        Test3 t = Test3::new;
        int num = 4;

        Converter<Integer,String> s = p-> System.out.println(String.valueOf(p + num));
        s.convert(100);
//        num = 8;

        Test.INSTANCE.dosomething();
    }

    interface Converter<T1,T2> {
        void convert(int i);
    }

}
