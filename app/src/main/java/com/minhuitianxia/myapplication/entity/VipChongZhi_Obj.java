package com.minhuitianxia.myapplication.entity;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/11/8 0008.
 */
public class VipChongZhi_Obj {


    /**
     * zsjfSl : 248
     * remark :
     * delDate : null
     * yczdId :
     * czCode : CZ20161101000024
     * zsczYxq : null
     * tcygId :
     * createBy : kyssd
     * id : bbee85b55816533601581f3a5b4e25cd
     * hykId : 6225350818094406
     * shState :
     * hyName : 孟亮亮
     * createDate : {"nanos":0,"time":1477992668000,"minutes":31,"seconds":8,"hours":17,"month":10,"timezoneOffset":-480,"year":116,"day":2,"date":1}
     * yhhdName : 重复充值送积分100-999
     * updateBy :
     * hyId : 571
     * yhhdId : bbee85b557f6c93b0157f6eb54bf0030
     * createName : 开元盛世店
     * updateDate : null
     * zsczJe : 0
     * czType : cf
     * updateName :
     * dpId : 18
     * dpName : 开元盛世店
     * zsjfYxq : null
     * yczCode :
     * delflag : 0
     * czJe : 124
     */

    private int zsjfSl;
    private String remark;
    private Object delDate;
    private String yczdId;
    private String czCode;
    private Object zsczYxq;
    private String tcygId;
    private String createBy;
    private String id;
    private String hykId;
    private String shState;
    private String hyName;
    /**
     * nanos : 0
     * time : 1477992668000
     * minutes : 31
     * seconds : 8
     * hours : 17
     * month : 10
     * timezoneOffset : -480
     * year : 116
     * day : 2
     * date : 1
     */

    private CreateDateBean createDate;
    private String yhhdName;
    private String updateBy;
    private String hyId;
    private String yhhdId;
    private String createName;
    private Object updateDate;
    private int zsczJe;
    private String czType;
    private String updateName;
    private String dpId;
    private String dpName;
    private Object zsjfYxq;
    private String yczCode;
    private int delflag;
    private int czJe;

    public static VipChongZhi_Obj objectFromData(String str) {

        return new Gson().fromJson(str, VipChongZhi_Obj.class);
    }

    public int getZsjfSl() {
        return zsjfSl;
    }

    public void setZsjfSl(int zsjfSl) {
        this.zsjfSl = zsjfSl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Object getDelDate() {
        return delDate;
    }

    public void setDelDate(Object delDate) {
        this.delDate = delDate;
    }

    public String getYczdId() {
        return yczdId;
    }

    public void setYczdId(String yczdId) {
        this.yczdId = yczdId;
    }

    public String getCzCode() {
        return czCode;
    }

    public void setCzCode(String czCode) {
        this.czCode = czCode;
    }

    public Object getZsczYxq() {
        return zsczYxq;
    }

    public void setZsczYxq(Object zsczYxq) {
        this.zsczYxq = zsczYxq;
    }

    public String getTcygId() {
        return tcygId;
    }

    public void setTcygId(String tcygId) {
        this.tcygId = tcygId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHykId() {
        return hykId;
    }

    public void setHykId(String hykId) {
        this.hykId = hykId;
    }

    public String getShState() {
        return shState;
    }

    public void setShState(String shState) {
        this.shState = shState;
    }

    public String getHyName() {
        return hyName;
    }

    public void setHyName(String hyName) {
        this.hyName = hyName;
    }

    public CreateDateBean getCreateDate() {
        return createDate;
    }

    public void setCreateDate(CreateDateBean createDate) {
        this.createDate = createDate;
    }

    public String getYhhdName() {
        return yhhdName;
    }

    public void setYhhdName(String yhhdName) {
        this.yhhdName = yhhdName;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getHyId() {
        return hyId;
    }

    public void setHyId(String hyId) {
        this.hyId = hyId;
    }

    public String getYhhdId() {
        return yhhdId;
    }

    public void setYhhdId(String yhhdId) {
        this.yhhdId = yhhdId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Object getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Object updateDate) {
        this.updateDate = updateDate;
    }

    public int getZsczJe() {
        return zsczJe;
    }

    public void setZsczJe(int zsczJe) {
        this.zsczJe = zsczJe;
    }

    public String getCzType() {
        return czType;
    }

    public void setCzType(String czType) {
        this.czType = czType;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getDpId() {
        return dpId;
    }

    public void setDpId(String dpId) {
        this.dpId = dpId;
    }

    public String getDpName() {
        return dpName;
    }

    public void setDpName(String dpName) {
        this.dpName = dpName;
    }

    public Object getZsjfYxq() {
        return zsjfYxq;
    }

    public void setZsjfYxq(Object zsjfYxq) {
        this.zsjfYxq = zsjfYxq;
    }

    public String getYczCode() {
        return yczCode;
    }

    public void setYczCode(String yczCode) {
        this.yczCode = yczCode;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public int getCzJe() {
        return czJe;
    }

    public void setCzJe(int czJe) {
        this.czJe = czJe;
    }

    public static class CreateDateBean {
        private int nanos;
        private long time;
        private int minutes;
        private int seconds;
        private int hours;
        private int month;
        private int timezoneOffset;
        private int year;
        private int day;
        private int date;

        public static CreateDateBean objectFromData(String str) {

            return new Gson().fromJson(str, CreateDateBean.class);
        }

        public int getNanos() {
            return nanos;
        }

        public void setNanos(int nanos) {
            this.nanos = nanos;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getTimezoneOffset() {
            return timezoneOffset;
        }

        public void setTimezoneOffset(int timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }
    }
}
