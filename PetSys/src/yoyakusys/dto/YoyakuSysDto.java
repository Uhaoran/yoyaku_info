/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoyakusys.dto;

/**
 *
 * @author WU HAORAN
 */
public class YoyakuSysDto {

    private String userid;
    private String pettype;
    private String course;
    private String checkin;
    private String times;

    public String getUserid() {
        return userid;
    }

    public String getPettype() {
        return pettype;
    }

    public String getCourse() {
        return course;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getTimes() {
        return times;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPettype(String pettype) {
        this.pettype = pettype;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
