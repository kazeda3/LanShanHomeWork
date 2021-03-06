package 蓝山作业.第一周作业;

/*We重邮失物招领模块分为一卡通类失物与其他失物(如书籍、水杯等)，其功能是展示校园失物并且可以根据关键字搜索失物，便于同学们快速找到自己丢失的物品。下面对两种功能的实现逻辑进行大致介绍：
展示失物功能的实现逻辑：从数据库中查询出失物数据lostArray，再将失物按丢失时间从大到小进行排序，然后将数据展示在We重邮上。
按关键字搜索功能的实现逻辑：遍历失物数据lostArray，将lostArray中与用户输入关键字keyword所匹配的数据放到一个数组中并返回给前端，前端将数据渲染在We重邮上。
现在请你：
分析失物类应具备什么属性，并设计一个父类失物类Lost和两个子类：一卡通失物类CardLost和书籍失物类BookLost
实现失物按丢失时间排序的功能sortLost()（要求自己实现排序算法
实现按关键字搜索失物的功能selectByKeyword()
编写测试方法证明上述功能实现正确
 */

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Lost[] lost = new Lost[4];
        CardLost cl1 = new CardLost("二教三楼", "二教失物招领处", "2022-07-01 14:00:00", "张三", 2021214232, "软件工程");
        CardLost cl2 = new CardLost("三教三楼", "三教失物招领处", "2022-07-02 15:30:00", "李四", 2021214232, "软件工程");
        lost[0] = cl1;
        lost[2] = cl2;
        BookLost bl1 = new BookLost("二教一楼", "二教失物招领", "2022-07-04 08:30:00", "高等数学");
        BookLost bl2 = new BookLost("二教二楼", "原位自取", "2022-07-03 15:30:00", "大学物理");
        lost[1] = bl1;
        lost[3] = bl2;
        sortLost(lost);
        System.out.println("是否进行关键字查找(是/否）");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (s.equals("是")) {
            System.out.println("请输入关键字");
            String key = sc.next();
            selectByKeyword(lost, key);
        }
    }

    public static void sortLost(Lost[] lost) {//失物按丢失时间排序
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < lost.length - 1; i++) {//冒泡排序
            for (int j = 0; j < lost.length - i - 1; j++) {
                try {
                    if (sdf.parse(lost[j].getsDate()).getTime() < sdf.parse(lost[j + 1].getsDate()).getTime()) {
                        Lost temp;
                        temp = lost[j];
                        lost[j] = lost[j + 1];
                        lost[j + 1] = temp;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            lost[i].show();
        }
    }

    public static void selectByKeyword(Lost[] lost, String key) {//按关键字搜索失物
        for (int i = 0; i < lost.length; i++) {
            if (lost[i].getsDate().contains(key) || lost[i].getClaimPlace().contains(key)
                    || lost[i].getLostPlace().contains(key)) {
                lost[i].show();
            } else if (lost[i] instanceof CardLost) {
                if (((CardLost) lost[i]).getName().contains(key) ||
                        ((CardLost) lost[i]).getCollege().contains(key)) {
                    lost[i].show();
                }
            } else if (lost[i] instanceof BookLost) {
                if (((BookLost) lost[i]).getBookName().contains(key)) {
                    lost[i].show();
                }
            }
        }
    }
}

