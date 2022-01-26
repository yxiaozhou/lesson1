package com.tim.learn.lesson1.lambda1;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2020/11/18 20:25
 * @Version: 1.0
 */
public class Test2 {


    public final static String slu = "tim";

    public static void main(String[] args) {

        GreetingService greetService2 = (message) ->System.out.println(slu + "--" + message);
        greetService2.sayMessage("test2");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
