package 蓝山作业.第二周作业.计算器;

import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("请输入表达式(暂不支持负数输入)");
        Scanner sc = new Scanner(System.in);
        String oprands = sc.next();
        List<String> list = InfixToPostExpression.switchList(oprands);//将String类型的表达式转换成List<String>类型的后缀表达式
        float result = InfixToPostExpression.caculate(list);//计算后缀表达式
        System.out.println("计算的结果为：" + result);
    }
}