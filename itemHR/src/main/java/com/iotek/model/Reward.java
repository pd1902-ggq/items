package com.iotek.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

//奖惩表
public class Reward implements Serializable {
    private Integer r_id;//ID
    private Integer e_id;//员工ID
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date r_date;//时间
    private String r_reason;//原因
    private Integer r_money;//金额

    public Reward() {
    }

    public Reward(Integer e_id, Date r_date, String r_reason, Integer r_money) {
        this.e_id = e_id;
        this.r_date = r_date;
        this.r_reason = r_reason;
        this.r_money = r_money;
    }

    public Reward(Integer r_id, Integer e_id, Date r_date, String r_reason, Integer r_money) {
        this.r_id = r_id;
        this.e_id = e_id;
        this.r_date = r_date;
        this.r_reason = r_reason;
        this.r_money = r_money;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public String getR_reason() {
        return r_reason;
    }

    public void setR_reason(String r_reason) {
        this.r_reason = r_reason;
    }

    public Integer getR_money() {
        return r_money;
    }

    public void setR_money(Integer r_money) {
        this.r_money = r_money;
    }

    @Override
    public String toString() {
        return "HRM_reward{" +
                "r_id=" + r_id +
                ", e_id=" + e_id +
                ", r_date=" + r_date +
                ", r_reason='" + r_reason + '\'' +
                ", r_money=" + r_money +
                '}';
    }
}
