package 蓝山作业.第一周作业;

import java.util.Date;

public class Lost {
    private String lostPlace;
    private String claimPlace;
    private String sDate;

    public Lost(String lostPlace, String claimPlace, String sDate) {
        this.lostPlace = lostPlace;
        this.claimPlace = claimPlace;
        this.sDate = sDate;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }

    public String getClaimPlace() {
        return claimPlace;
    }

    public void setClaimPlace(String claimPlace) {
        this.claimPlace = claimPlace;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public void show(){};
}
