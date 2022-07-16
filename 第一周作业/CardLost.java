package 蓝山作业.第一周作业;

import java.util.Date;

public class CardLost extends Lost{
    private String name;
    private int id;
    private String college;

    public CardLost(String lostPlace, String claimPlace, String sDate, String name, int id, String college) {
        super(lostPlace, claimPlace, sDate);
        this.name = name;
        this.id = id;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public void show(){
        System.out.println("失物地点：" + getLostPlace());
        System.out.println("领取地点：" + getClaimPlace());
        System.out.println("失物时间：" + getsDate());
        System.out.println("失物人姓名：" +  getName());
        System.out.println("失物人学号：" + getId());
        System.out.println("失物人学院：" + getCollege());
        System.out.println("");
    }
}
