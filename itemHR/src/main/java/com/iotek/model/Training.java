package com.iotek.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//培训表
public class Training implements Serializable {
    private Integer t_id;//ID
    private String t_title;//主题
    private String t_context;//具体内容
    private Integer e_id;//员工ID
    @DateTimeFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date t_start_time;//开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date t_end_time;//结束时间
    private String t_address;//地点
    private Integer t_is_publish;//是否为发布

    public Training() {
    }

    public Training(String t_title, String t_context, Integer e_id, Date t_start_time, Date t_end_time, String t_address, Integer t_is_publish) {
        this.t_title = t_title;
        this.t_context = t_context;
        this.e_id = e_id;
        this.t_start_time = t_start_time;
        this.t_end_time = t_end_time;
        this.t_address = t_address;
        this.t_is_publish = t_is_publish;
    }

    public Training(Integer t_id, String t_title, String t_context, Integer e_id, Date t_start_time, Date t_end_time, String t_address, Integer t_is_publish) {
        this.t_id = t_id;
        this.t_title = t_title;
        this.t_context = t_context;
        this.e_id = e_id;
        this.t_start_time = t_start_time;
        this.t_end_time = t_end_time;
        this.t_address = t_address;
        this.t_is_publish = t_is_publish;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_context() {
        return t_context;
    }

    public void setT_context(String t_context) {
        this.t_context = t_context;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public Date getT_start_time() {
        return t_start_time;
    }

    public void setT_start_time(Date t_start_time) {
        this.t_start_time = t_start_time;
    }

    public Date getT_end_time() {
        return t_end_time;
    }

    public void setT_end_time(Date t_end_time) {
        this.t_end_time = t_end_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public Integer getT_is_publish() {
        return t_is_publish;
    }

    public void setT_is_publish(Integer t_is_publish) {
        this.t_is_publish = t_is_publish;
    }

    @Override
    public String toString() {
        return "HRM_training{" +
                "t_id=" + t_id +
                ", t_title='" + t_title + '\'' +
                ", t_context='" + t_context + '\'' +
                ", e_id=" + e_id +
                ", t_start_time=" + t_start_time +
                ", t_end_time=" + t_end_time +
                ", t_address='" + t_address + '\'' +
                ", t_is_publish=" + t_is_publish +
                '}';
    }
}
