package com.minhuitianxia.myapplication.entity;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/11/9 0009.
 */
public class VipXiaoFei_Obj {

    /**
     * nanos : 0
     * time : 1480132123000
     * minutes : 48
     * seconds : 43
     * hours : 11
     * month : 10
     * timezoneOffset : -480
     * year : 116
     * day : 6
     * date : 26
     */

    private DelDateBean delDate;
    /**
     * delDate : {"nanos":0,"time":1480132123000,"minutes":48,"seconds":43,"hours":11,"month":10,"timezoneOffset":-480,"year":116,"day":6,"date":26}
     * syMan : bbee85b557f6133c0157f685f07800b5
     * ddCode : XF20161104000069
     * hdName :
     * createBy : kyssd
     * syNum :
     * id : bbee85b55825414a01582d73f1ab1a66
     * isPtfx : N
     * isFanli : N
     * ckName : 开元盛世店仓库
     * isTuihuo : N
     * createDate : {"nanos":0,"time":1478231323000,"minutes":48,"seconds":43,"hours":11,"month":10,"timezoneOffset":-480,"year":116,"day":5,"date":4}
     * hyName : 孟亮亮
     * spRemark :
     * updateBy :
     * isDzfx : N
     * ddMoney : 683
     * hyId : 571
     * isJiangli : N
     * ddJf : 0
     * createName : 开元盛世店
     * updateDate : null
     * ckId : 018
     * userCard : 6225350818094406
     * hdId :
     * updateName :
     * dpId : 18
     * dpName : 开元盛世店
     * payType :
     * spNum : 10
     * delflag : 0
     */

    private String syMan;
    private String ddCode;
    private String hdName;
    private String createBy;
    private String syNum;
    private String id;
    private String isPtfx;
    private String isFanli;
    private String ckName;
    private String isTuihuo;
    /**
     * nanos : 0
     * time : 1478231323000
     * minutes : 48
     * seconds : 43
     * hours : 11
     * month : 10
     * timezoneOffset : -480
     * year : 116
     * day : 5
     * date : 4
     */

    private CreateDateBean createDate;
    private String hyName;
    private String spRemark;
    private String updateBy;
    private String isDzfx;
    private int ddMoney;
    private String hyId;
    private String isJiangli;
    private int ddJf;
    private String createName;
    private Object updateDate;
    private String ckId;
    private String userCard;
    private String hdId;
    private String updateName;
    private String dpId;
    private String dpName;
    private String payType;
    private int spNum;
    private int delflag;

    public static VipXiaoFei_Obj objectFromData(String str) {

        return new Gson().fromJson(str, VipXiaoFei_Obj.class);
    }

    public DelDateBean getDelDate() {
        return delDate;
    }

    public void setDelDate(DelDateBean delDate) {
        this.delDate = delDate;
    }

    public String getSyMan() {
        return syMan;
    }

    public void setSyMan(String syMan) {
        this.syMan = syMan;
    }

    public String getDdCode() {
        return ddCode;
    }

    public void setDdCode(String ddCode) {
        this.ddCode = ddCode;
    }

    public String getHdName() {
        return hdName;
    }

    public void setHdName(String hdName) {
        this.hdName = hdName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getSyNum() {
        return syNum;
    }

    public void setSyNum(String syNum) {
        this.syNum = syNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsPtfx() {
        return isPtfx;
    }

    public void setIsPtfx(String isPtfx) {
        this.isPtfx = isPtfx;
    }

    public String getIsFanli() {
        return isFanli;
    }

    public void setIsFanli(String isFanli) {
        this.isFanli = isFanli;
    }

    public String getCkName() {
        return ckName;
    }

    public void setCkName(String ckName) {
        this.ckName = ckName;
    }

    public String getIsTuihuo() {
        return isTuihuo;
    }

    public void setIsTuihuo(String isTuihuo) {
        this.isTuihuo = isTuihuo;
    }

    public CreateDateBean getCreateDate() {
        return createDate;
    }

    public void setCreateDate(CreateDateBean createDate) {
        this.createDate = createDate;
    }

    public String getHyName() {
        return hyName;
    }

    public void setHyName(String hyName) {
        this.hyName = hyName;
    }

    public String getSpRemark() {
        return spRemark;
    }

    public void setSpRemark(String spRemark) {
        this.spRemark = spRemark;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getIsDzfx() {
        return isDzfx;
    }

    public void setIsDzfx(String isDzfx) {
        this.isDzfx = isDzfx;
    }

    public int getDdMoney() {
        return ddMoney;
    }

    public void setDdMoney(int ddMoney) {
        this.ddMoney = ddMoney;
    }

    public String getHyId() {
        return hyId;
    }

    public void setHyId(String hyId) {
        this.hyId = hyId;
    }

    public String getIsJiangli() {
        return isJiangli;
    }

    public void setIsJiangli(String isJiangli) {
        this.isJiangli = isJiangli;
    }

    public int getDdJf() {
        return ddJf;
    }

    public void setDdJf(int ddJf) {
        this.ddJf = ddJf;
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

    public String getCkId() {
        return ckId;
    }

    public void setCkId(String ckId) {
        this.ckId = ckId;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getHdId() {
        return hdId;
    }

    public void setHdId(String hdId) {
        this.hdId = hdId;
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getSpNum() {
        return spNum;
    }

    public void setSpNum(int spNum) {
        this.spNum = spNum;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public static class DelDateBean {
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

        public static DelDateBean objectFromData(String str) {

            return new Gson().fromJson(str, DelDateBean.class);
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
