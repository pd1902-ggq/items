package com.iotek.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//面试系统表
public class Ftfs implements Serializable {
    private Integer f_id;//ID
    private Integer cv_id;//简历ID
    private Integer rct_id;//招聘ID
    @DateTimeFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date f_date;//面试时间
    private Integer f_is_read;//0--> 未答复，1-->已安排面试，2-->游客同意面试,3-->面试通过，4-->面试信息清除
    private Integer c_id;
    public Ftfs() {
    }

    public Ftfs(Integer f_id) {
        this.f_id = f_id;
    }

    public Ftfs(Integer cv_id, Integer rct_id, Date f_date, Integer f_is_read, Integer c_id) {
        this.cv_id = cv_id;
        this.rct_id = rct_id;
        this.f_date = f_date;
        this.f_is_read = f_is_read;
        this.c_id = c_id;
    }

    public Ftfs(Integer f_id, Integer cv_id, Integer rct_id, Date f_date, Integer f_is_read, Integer c_id) {
        this.f_id = f_id;
        this.cv_id = cv_id;
        this.rct_id = rct_id;
        this.f_date = f_date;
        this.f_is_read = f_is_read;
        this.c_id = c_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public Integer getCv_id() {
        return cv_id;
    }

    public void setCv_id(Integer cv_id) {
        this.cv_id = cv_id;
    }

    public Integer getRct_id() {
        return rct_id;
    }

    public void setRct_id(Integer rct_id) {
        this.rct_id = rct_id;
    }

    public Date getF_date() {
        return f_date;
    }

    public void setF_date(Date f_date) {
        this.f_date = f_date;
    }

    public Integer getF_is_read() {
        return f_is_read;
    }

    public void setF_is_read(Integer f_is_read) {
        this.f_is_read = f_is_read;
    }

    @Override
    public String toString() {
        return "Ftfs{" + "f_id=" + f_id + ", cv_id=" + cv_id + ", rct_id=" + rct_id + ", f_date=" + f_date + ", f_is_read=" + f_is_read + ", c_id=" + c_id + '}';
    }
}
