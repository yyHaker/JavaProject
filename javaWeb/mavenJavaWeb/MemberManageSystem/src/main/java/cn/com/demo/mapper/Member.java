package cn.com.demo.mapper;

import java.util.Date;

public class Member {
    private String id;

    private String password;

    private String sex;

    private Date birthday;

    private String telephone;

    private String storeid;

    private String level;

    private Integer points;

    private Integer flightcount;

    private Date lastvisitedtime;

    private Integer flighttime;

    private Float consumptionsum;

    private Float balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid == null ? null : storeid.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getFlightcount() {
        return flightcount;
    }

    public void setFlightcount(Integer flightcount) {
        this.flightcount = flightcount;
    }

    public Date getLastvisitedtime() {
        return lastvisitedtime;
    }

    public void setLastvisitedtime(Date lastvisitedtime) {
        this.lastvisitedtime = lastvisitedtime;
    }

    public Integer getFlighttime() {
        return flighttime;
    }

    public void setFlighttime(Integer flighttime) {
        this.flighttime = flighttime;
    }

    public Float getConsumptionsum() {
        return consumptionsum;
    }

    public void setConsumptionsum(Float consumptionsum) {
        this.consumptionsum = consumptionsum;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}