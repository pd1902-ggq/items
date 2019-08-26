package com.iotek.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
//简历
public class Cv implements Serializable {
    private Integer cv_id;//ID
    private Integer c_id;//游客ID
    private String cv_name;//姓名
    private String cv_gender;//性别
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cv_birth;//出生年月
    private String cv_address;//住址
    private String cv_school;//学校名称
    private String cv_education;//学历
    private String cv_major;//所学专业
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cv_enroll_date;//入学时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cv_graduation_date;//毕业时间
    private double cv_salary;//期望薪资
    private String cv_exprience;//经历
    private String cv_title;//简历标题
    private String cv_phone;//联系方式

    public Cv() {
    }

    public Cv(Integer c_id, String cv_name, String cv_gender, Date cv_birth, String cv_address, String cv_school, String cv_education, String cv_major, Date cv_enroll_date, Date cv_graduation_date, double cv_salary, String cv_exprience, String cv_title, String cv_phone) {
        this.c_id = c_id;
        this.cv_name = cv_name;
        this.cv_gender = cv_gender;
        this.cv_birth = cv_birth;
        this.cv_address = cv_address;
        this.cv_school = cv_school;
        this.cv_education = cv_education;
        this.cv_major = cv_major;
        this.cv_enroll_date = cv_enroll_date;
        this.cv_graduation_date = cv_graduation_date;
        this.cv_salary = cv_salary;
        this.cv_exprience = cv_exprience;
        this.cv_title = cv_title;
        this.cv_phone = cv_phone;
    }

    public Cv(Integer cv_id, Integer c_id, String cv_name, String cv_gender, Date cv_birth, String cv_address, String cv_school, String cv_education, String cv_major, Date cv_enroll_date, Date cv_graduation_date, double cv_salary, String cv_exprience, String cv_title, String cv_phone) {
        this.cv_id = cv_id;
        this.c_id = c_id;
        this.cv_name = cv_name;
        this.cv_gender = cv_gender;
        this.cv_birth = cv_birth;
        this.cv_address = cv_address;
        this.cv_school = cv_school;
        this.cv_education = cv_education;
        this.cv_major = cv_major;
        this.cv_enroll_date = cv_enroll_date;
        this.cv_graduation_date = cv_graduation_date;
        this.cv_salary = cv_salary;
        this.cv_exprience = cv_exprience;
        this.cv_title = cv_title;
        this.cv_phone = cv_phone;
    }

    public String getCv_title() {
        return cv_title;
    }

    public void setCv_title(String cv_title) {
        this.cv_title = cv_title;
    }

    public String getCv_phone() {
        return cv_phone;
    }

    public void setCv_phone(String cv_phone) {
        this.cv_phone = cv_phone;
    }

    public Integer getCv_id() {
        return cv_id;
    }

    public void setCv_id(Integer cv_id) {
        this.cv_id = cv_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getCv_name() {
        return cv_name;
    }

    public void setCv_name(String cv_name) {
        this.cv_name = cv_name;
    }

    public String getCv_gender() {
        return cv_gender;
    }

    public void setCv_gender(String cv_gender) {
        this.cv_gender = cv_gender;
    }

    public Date getCv_birth() {
        return cv_birth;
    }

    public void setCv_birth(Date cv_birth) {
        this.cv_birth = cv_birth;
    }

    public String getCv_address() {
        return cv_address;
    }

    public void setCv_address(String cv_address) {
        this.cv_address = cv_address;
    }

    public String getCv_school() {
        return cv_school;
    }

    public void setCv_school(String cv_school) {
        this.cv_school = cv_school;
    }

    public String getCv_education() {
        return cv_education;
    }

    public void setCv_education(String cv_education) {
        this.cv_education = cv_education;
    }

    public String getCv_major() {
        return cv_major;
    }

    public void setCv_major(String cv_major) {
        this.cv_major = cv_major;
    }

    public Date getCv_enroll_date() {
        return cv_enroll_date;
    }

    public void setCv_enroll_date(Date cv_enroll_date) {
        this.cv_enroll_date = cv_enroll_date;
    }

    public Date getCv_graduation_date() {
        return cv_graduation_date;
    }

    public void setCv_graduation_date(Date cv_graduation_date) {
        this.cv_graduation_date = cv_graduation_date;
    }

    public double getCv_salary() {
        return cv_salary;
    }

    public void setCv_salary(double cv_salary) {
        this.cv_salary = cv_salary;
    }

    public String getCv_exprience() {
        return cv_exprience;
    }

    public void setCv_exprience(String cv_exprience) {
        this.cv_exprience = cv_exprience;
    }

    @Override
    public String toString() {
        return "Cv{" + "cv_id=" + cv_id + ", c_id=" + c_id + ", cv_name='" + cv_name + '\'' + ", cv_gender='" + cv_gender + '\'' + ", cv_birth=" + cv_birth + ", cv_address='" + cv_address + '\'' + ", cv_school='" + cv_school + '\'' + ", cv_education='" + cv_education + '\'' + ", cv_major='" + cv_major + '\'' + ", cv_enroll_date=" + cv_enroll_date + ", cv_graduation_date=" + cv_graduation_date + ", cv_salary=" + cv_salary + ", cv_exprience='" + cv_exprience + '\'' + ", cv_title='" + cv_title + '\'' + ", cv_phone='" + cv_phone + '\'' + '}';
    }
}
