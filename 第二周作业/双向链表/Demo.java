package 蓝山作业.第二周作业.双向链表;


import 蓝山作业.第二周作业.双向链表.TwoWayLinkList;

public class Demo {
    public static void main(String[] args) {
        //创建双向链表对象
        TwoWayLinkList<String> twll = new TwoWayLinkList<>();
        //插入测试
        twll.insert("数据1");
        twll.insert("数据2");
        twll.insert("数据3");
        twll.insert("数据4");
        twll.insert("数据5");
        //遍历测试
        twll.traverse();
        //查找测试
        System.out.println("索引1下的数据是:"+twll.get(1));
        System.out.println("数据4所在位置是"+twll.indexOf("数据4"));
        //翻转测试
//        twll.flip();
        twll.reversed();
        twll.traverse();
        //删除测试
        System.out.println("删除的元素是:"+twll.remove(1));
        System.out.println("删除的元素是:"+twll.remove(1));
        twll.traverse();
    }
}
