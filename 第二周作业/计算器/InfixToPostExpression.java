package 蓝山作业.第二周作业.计算器;

import java.util.*;

public class InfixToPostExpression {

    public static List<String> switchList(String infixExpression) {
        List<String> list = InfixToPostExpression.toList(infixExpression);
        System.out.println("中缀表达式为："+list);
        Stack<String> numStack = new Stack<>();
        Stack<String> operateStack = new Stack<>();

        for (int i = 0; i < list.size(); ) {
            // 逐个取出列表中的元素
            String element = list.get(i);
            if (element.charAt(0) >= '0' && element.charAt(0) <= '9') {// 如果是数字直接压到numStack
                numStack.push(element);
                i++;
//            } else if (operateStack.isEmpty() && (element.charAt(0) < '0' || element.charAt(0) > '9')) {// 如果栈空且不是数字直接将元素压入operateStack
//                operateStack.push(element);
//                i++;
            } else if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {// 如果为运算符 则比较优先级
                if (operateStack.isEmpty() || operateStack.peek().equals("(")) {// 如果栈为空或者栈顶元素为左括号 则直接该元素压入operateStack栈中
                    operateStack.push(element);
                    i++;
                }
                // 如果当前运算符高于栈顶运算符 则直接将当前运算符压入operateStack栈中
                else if ((element.equals("*") || element.equals("/")) && ((operateStack.peek().equals("+")) || (operateStack.peek().equals("-")))) {
                    operateStack.push(element);
                    i++;
                } else { // 否则 当前运算符优先级不大于栈顶运算符的优先级 则将栈顶运算符弹出压入到numStack栈中 再将当前运算符与下一个栈顶元素比较优先级 则i不递增
                    numStack.push(operateStack.pop());
                }
            } else if (element.equals("(")) {  // 如果当前元素为左括号 则直接压入operateStack栈中
                operateStack.push(element);
                i++;
            } else if (element.equals(")")) {  // 如果当前元素为右括号 依次将栈顶元素弹出压到numStack栈中 直到弹出元素为左括号 然后丢弃这一对括号
                while (!(operateStack.peek().equals("("))) {
                    numStack.push(operateStack.pop());
                }
                operateStack.pop();
                i++;
            }
        }

        // 当中缀表达式从左到右扫描完后 执行一下步骤
        // 把operateStack中剩余的元素弹出压到numStack栈中
        while (!operateStack.isEmpty()) {
            numStack.push(operateStack.pop());
        }
        // 再将numStack的元素顺序反转 即为后缀表达式
        while (!numStack.isEmpty()) {
            operateStack.push(numStack.pop());
        }
        //将反转后的后缀表达式转换成List<String>类型
        List<String> oprands = new ArrayList<>();
        while (!operateStack.isEmpty()) {
            oprands.add(operateStack.pop());
        }
        System.out.println("后缀表达式为："+oprands);
        return oprands;
    }

    public static List<String> toList(String str) {//将String类型的表达式转换成list类型
        List<String> list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) > '9' || str.charAt(i) < '0') && str.charAt(i) != ' ' && str.charAt(i) != '.') {//如果是运算符直接添加到集合中
                list.add(str.charAt(i) + "");
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {  // 如果该字符是数字 需要处理是不是多位数或者浮点数
                s += str.charAt(i);
                // 如果字符串没有到达边界 且下一个字符也是数字或者'.'就进行拼接
                if (i + 1 >= str.length() || ((str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9') && str.charAt(i + 1) != '.')) {
                    list.add(s);
                    s = "";
                }
            } else if (str.charAt(i) == '.') {//如果该字符是'.'，需要处理拼接问题
                s += str.charAt(i);
            }

        }

        return list;
    }

    public static float caculate(List<String> oprands) {
        Stack<Float> stack = new Stack<>();//创建新的栈来储存数字
        //从左往右遍历list集合，得到每一个元素
        Float i1;
        Float i2;
        Float result1 = null;
        for (int i = 0; i < oprands.size(); i++) {
            String str = oprands.get(i);
            //判断当前元素是操作符还是操作数
            try {
                switch (str) {
                    case "+"://如果是操作符，那么弹出栈中的两个数字运算并将结果重新压入栈内
                        i1 = stack.pop();
                        i2 = stack.pop();
                        result1 = i1 + i2;
                        stack.push(result1);
                        break;
                    case "-":
                        i1 = stack.pop();
                        i2 = stack.pop();
                        result1 = i2 - i1;
                        stack.push(result1);
                        break;
                    case "*":
                        i1 = stack.pop();
                        i2 = stack.pop();
                        result1 = i1 * i2;
                        stack.push(result1);
                        break;
                    case "/":
                        i1 = stack.pop();
                        i2 = stack.pop();
                        try {
                            result1 = i2 / i1;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        stack.push(result1);
                        break;
                    default://如果是数字 则直接压入栈内
                        stack.push(Float.parseFloat(str));
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("请输入正确的表达式");
            }
        }
        float result2 = stack.pop();
        //得到栈中最后一个元素，就是逆波兰表达式的结果
        return result2;
    }
}
