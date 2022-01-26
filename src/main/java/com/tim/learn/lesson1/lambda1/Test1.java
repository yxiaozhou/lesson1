package com.tim.learn.lesson1.lambda1;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2020/11/18 20:25
 * @Version: 1.0
 */
public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();

        MathOperation addtion = (int a, int b) -> a + b;

        MathOperation sub = (a, b) -> a - b;

        MathOperation multipe = (a, b) -> a * b;

        MathOperation divide = (a, b) -> a / b;

        System.out.println(test1.operate(10, 5, addtion));
        System.out.println(test1.operate(10, 5, sub));
        System.out.println(test1.operate(10, 5, multipe));
        System.out.println(test1.operate(10, 5, divide));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);
        greetService1.sayMessage("test1");
        // 不用括号
        GreetingService greetService2 = (message) ->System.out.println("Hello " + message);
        greetService2.sayMessage("test2");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
