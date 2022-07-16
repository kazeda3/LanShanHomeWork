package 蓝山作业.第一周作业;

import java.util.Date;

public class BookLost extends Lost{
    private String bookName;

    public BookLost(String lostPlace, String claimPlace, String sDate, String bookName) {
        super(lostPlace, claimPlace, sDate);
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void show(){
        System.out.println("失物地点："+ getLostPlace());
        System.out.println("领取地点："+ getClaimPlace());
        System.out.println("失物时间："+ getsDate());
        System.out.println("书籍名称："+ getBookName());
        System.out.println("");
    }
}
