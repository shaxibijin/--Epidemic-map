package com.bijin.epidemic.beans;

import org.springframework.asm.SpringAsmInfo;

import javax.sql.DataSource;
import java.util.Date;

/**
 * 疫情信息实体类
 */
public class EpidemicInfo {
    private Integer serialId;//编号
    private Integer provinceId;//省份编号
    private Short dataYear;//年份
    private Short dataMonth;//月份
    private Short dataDay;//日
    //确诊人数、疑似人数、治愈人数、隔离人数、死亡人数（每一天的新增数据）
    private Integer affirmed,suspected,cured,isolated,dead;
    private Integer userId;
    private Date inputDate;

    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Short getDataYear() {
        return dataYear;
    }

    public void setDataYear(Short dataYear) {
        this.dataYear = dataYear;
    }

    public Short getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(Short dataMonth) {
        this.dataMonth = dataMonth;
    }

    public Short getDataDay() {
        return dataDay;
    }

    public void setDataDay(Short dataDay) {
        this.dataDay = dataDay;
    }

    public Integer getAffirmed() {
        return affirmed;
    }

    public void setAffirmed(Integer affirmed) {
        this.affirmed = affirmed;
    }

    public Integer getSuspected() {
        return suspected;
    }

    public void setSuspected(Integer suspected) {
        this.suspected = suspected;
    }

    public Integer getCured() {
        return cured;
    }

    public void setCured(Integer cured) {
        this.cured = cured;
    }

    public Integer getIsolated() {
        return isolated;
    }

    public void setIsolated(Integer isolated) {
        this.isolated = isolated;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
}
