package com.bijin.epidemic.beans;

/**
 * 省份实体类
 */
public class ProvinceInfo {
    private Integer provinceId; //省份编号
    private String provinceName;//省份名称
    private String provincePinYin;//省份拼音标识

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvincePinYin() {
        return provincePinYin;
    }

    public void setProvincePinYin(String provincePinYin) {
        this.provincePinYin = provincePinYin;
    }
}
