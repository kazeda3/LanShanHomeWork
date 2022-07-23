package 蓝山作业.第二周作业.双向链表;

import 暑假学习计划.双向链表.TowWayLinkList;

import java.util.Iterator;

public class TwoWayLinkList <T>implements Iterable{
    Node head;//头结点
    Node last;//尾结点
    int N;//链表长度
    public class Node{
        T item;
        Node next;
        Node pre;

        public Node( Node pre,T item,Node next) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }
    public TwoWayLinkList(){
        //初始化头结点和尾结点
        this.head = new Node(null,null,null);
        this.last = new Node(null,null,null);
        //初始化链表长度
        this.N = 0;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }
    //遍历链表
    public void traverse(){
        Node n = head;
        for(int i = 0;n.next != null;i++){
            n = n.next;
            System.out.println(n.item);
        }
    }
    //插入到链表末尾
    public void insert(T t){
        //判断链表是否为空
        if(isEmpty()){//如果链表为空
            //创建新结点
            Node newNode = new Node(head, t, null);
            //将头结点指向新节点
            head.next = newNode;
            //将新结点变成尾结点
            last = newNode;
        }else {//如果链表不为空
            Node oldLast = last;
            //创建新的结点
            Node newNode = new Node(oldLast, t, null);
            //让当前的尾结点指向新节点
            oldLast.next = newNode;
            //让新节点称为尾结点
            last = newNode;
        }
        //元素个数+1
        N++;
    }
    //插入到i处
    public void insert(T t,int i){
            //找到i之前的结点
            Node pre = head;
            for(int index = 0;index<i-1;index++){
                pre = pre.next;
            }
            //找到i处的结点
            Node curr = pre.next;
            //创建新节点
            Node newNode = new Node(pre, t, curr);
           //将i前的结点指向新节点
           pre.next = newNode;
           //将i处的结点向前指向新结点
            curr.pre = newNode;
        //元素个数+1
        N++;
    }
    //删除
    public T remove(int i){
        //找到i前一个结点
        Node pre = head;
        for(int index = 0;index<i-1;index++){
            pre = pre.next;
        }
        //找到i处的结点
        Node curr = pre.next;
        //找到i后的结点
        Node behind = curr.next;
        //把i前的结点指向i后的结点
        pre.next = behind;
        //把i后的结点指向i前的结点
        behind.pre = pre;
        //元素个数-1
        N--;
        return curr.item;
    }
    //找到第一次出现t元素的位置，并返回下标
    public int indexOf(T t){
        Node n = head;
        for(int i = 0;n.next != null;i++){
            n = n.next;
            if(n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    //获取指定位置的元素
    public T get(int i){
        Node n = head.next;
        for(int index = 0;index<i;index++){
            n = n.next;
        }
        return n.item;
    }
    //翻转链表
//    public void flip(){
//        Node curr = head;
//        Node temp = null;
//        while(curr != null){
//            //用temp储存临时变量，将当前结点的前一个指向和后一个指向交换
//            temp = curr.pre;
//            curr.pre = curr.next;
//            curr.next = temp;
//            curr = curr.pre;
//        }
//        if(temp != null){//循环结束后 temp存储着第二个字节的信息
//            head = temp.pre;
//        }
//    }
    //翻转链表
    public void reversed() {
        Node temp = head.next;
        boolean b = true;
        while(b){
            temp.pre.next = temp.pre.pre;
            temp.pre.pre = temp;
            if(temp.next != null){
                temp = temp.next;
            }else{
                temp.next = temp.pre;
                temp.pre = head;
                head.next = temp;
                head.pre.next = null;
                b = false;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new TIterator();
    }
    public class TIterator implements Iterator{
        Node n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
