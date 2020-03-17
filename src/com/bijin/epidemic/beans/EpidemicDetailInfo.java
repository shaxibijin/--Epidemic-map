package com.bijin.epidemic.beans;

/**
 * 根据需求，对疫情显示进行扩充（供显示用）
 */
public class EpidemicDetailInfo extends EpidemicInfo{
    private String provinceName;//省份名称
    //确诊，疑似，治愈，隔离，死亡（累计数据）DDL,DCL,DQL,DML,多表查询，位连接，交叉链接
    private Integer affirmedTotal,suspectedTotal,curedTotal,isolatedTotal,deadTotal;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getAffirmedTotal() {
        return affirmedTotal;
    }

    public void setAffirmedTotal(Integer affirmedTotal) {
        this.affirmedTotal = affirmedTotal;
    }

    public Integer getSuspectedTotal() {
        return suspectedTotal;
    }

    public void setSuspectedTotal(Integer suspectedTotal) {
        this.suspectedTotal = suspectedTotal;
    }

    public Integer getCuredTotal() {
        return curedTotal;
    }

    public void setCuredTotal(Integer curedTotal) {
        this.curedTotal = curedTotal;
    }

    public Integer getIsolatedTotal() {
        return isolatedTotal;
    }

    public void setIsolatedTotal(Integer isolatedTotal) {
        this.isolatedTotal = isolatedTotal;
    }

    public Integer getDeadTotal() {
        return deadTotal;
    }

    public void setDeadTotal(Integer deadTotal) {
        this.deadTotal = deadTotal;
    }
}
