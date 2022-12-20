package edu.upi.cs.yudiwbs.uas_template;

//untuk di recylerview
public class Accel {
    private String time;
    private String notif;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }

    public Accel(String time, String notif) {
        this.time = time;
        this.notif = notif;
    }
}
