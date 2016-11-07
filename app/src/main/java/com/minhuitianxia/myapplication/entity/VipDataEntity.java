package com.minhuitianxia.myapplication.entity;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class VipDataEntity {


    /**
     * attributes : null
     * obj : {"address":"","id":"2759","password":"6918bc28bef29408","updateName":"总店技术01","createName":null,"createBy":null,"updateBy":"zdjs01","createDate":1476869191000,"updateDate":1477446205000,"remark":"","email":null,"hykId":"6225350818106666","hyName":"赵宜","czye":0,"jfye":5500,"delflag":null,"delDate":null,"tel":"15166866385","shState":"ok","zcdpId":"1","tcygId":null,"hyState":"zc","hyLevel":"1","sex":"0","tjrName":"王婷婷","csrq":746640000000,"sfz":"370612199308302519","gddh":null,"tcygName":null,"tjrCardId":"6225350818094666","tjrId":"27","txImgUrl":null,"wxCode":null}
     * msg : 操作成功
     * jsonStr : {"obj":{"address":"","createDate":1476869191000,"csrq":746640000000,"czye":0.000000,"hyLevel":"1","hyName":"赵宜","hyState":"zc","hykId":"6225350818106666","id":"2759","jfye":5500.000000,"password":"6918bc28bef29408","remark":"","sex":"0","sfz":"370612199308302519","shState":"ok","tel":"15166866385","tjrCardId":"6225350818094666","tjrId":"27","tjrName":"王婷婷","updateBy":"zdjs01","updateDate":1477446205000,"updateName":"总店技术01","zcdpId":"1"},"msg":"操作成功","success":true}
     * success : true
     */

    private Object attributes;
    /**
     * address :
     * id : 2759
     * password : 6918bc28bef29408
     * updateName : 总店技术01
     * createName : null
     * createBy : null
     * updateBy : zdjs01
     * createDate : 1476869191000
     * updateDate : 1477446205000
     * remark :
     * email : null
     * hykId : 6225350818106666
     * hyName : 赵宜
     * czye : 0.0
     * jfye : 5500.0
     * delflag : null
     * delDate : null
     * tel : 15166866385
     * shState : ok
     * zcdpId : 1
     * tcygId : null
     * hyState : zc
     * hyLevel : 1
     * sex : 0
     * tjrName : 王婷婷
     * csrq : 746640000000
     * sfz : 370612199308302519
     * gddh : null
     * tcygName : null
     * tjrCardId : 6225350818094666
     * tjrId : 27
     * txImgUrl : null
     * wxCode : null
     */

    private ObjBean obj;
    private String msg;
    private String jsonStr;
    private boolean success;

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class ObjBean {
        private String address;
        private String id;
        private String password;
        private String updateName;
        private Object createName;
        private Object createBy;
        private String updateBy;
        private long createDate;
        private long updateDate;
        private String remark;
        private Object email;
        private String hykId;
        private String hyName;
        private double czye;
        private double jfye;
        private Object delflag;
        private Object delDate;
        private String tel;
        private String shState;
        private String zcdpId;
        private Object tcygId;
        private String hyState;
        private String hyLevel;
        private String sex;
        private String tjrName;
        private long csrq;
        private String sfz;
        private Object gddh;
        private Object tcygName;
        private String tjrCardId;
        private String tjrId;
        private Object txImgUrl;
        private Object wxCode;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public Object getCreateName() {
            return createName;
        }

        public void setCreateName(Object createName) {
            this.createName = createName;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getHykId() {
            return hykId;
        }

        public void setHykId(String hykId) {
            this.hykId = hykId;
        }

        public String getHyName() {
            return hyName;
        }

        public void setHyName(String hyName) {
            this.hyName = hyName;
        }

        public double getCzye() {
            return czye;
        }

        public void setCzye(double czye) {
            this.czye = czye;
        }

        public double getJfye() {
            return jfye;
        }

        public void setJfye(double jfye) {
            this.jfye = jfye;
        }

        public Object getDelflag() {
            return delflag;
        }

        public void setDelflag(Object delflag) {
            this.delflag = delflag;
        }

        public Object getDelDate() {
            return delDate;
        }

        public void setDelDate(Object delDate) {
            this.delDate = delDate;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getShState() {
            return shState;
        }

        public void setShState(String shState) {
            this.shState = shState;
        }

        public String getZcdpId() {
            return zcdpId;
        }

        public void setZcdpId(String zcdpId) {
            this.zcdpId = zcdpId;
        }

        public Object getTcygId() {
            return tcygId;
        }

        public void setTcygId(Object tcygId) {
            this.tcygId = tcygId;
        }

        public String getHyState() {
            return hyState;
        }

        public void setHyState(String hyState) {
            this.hyState = hyState;
        }

        public String getHyLevel() {
            return hyLevel;
        }

        public void setHyLevel(String hyLevel) {
            this.hyLevel = hyLevel;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTjrName() {
            return tjrName;
        }

        public void setTjrName(String tjrName) {
            this.tjrName = tjrName;
        }

        public long getCsrq() {
            return csrq;
        }

        public void setCsrq(long csrq) {
            this.csrq = csrq;
        }

        public String getSfz() {
            return sfz;
        }

        public void setSfz(String sfz) {
            this.sfz = sfz;
        }

        public Object getGddh() {
            return gddh;
        }

        public void setGddh(Object gddh) {
            this.gddh = gddh;
        }

        public Object getTcygName() {
            return tcygName;
        }

        public void setTcygName(Object tcygName) {
            this.tcygName = tcygName;
        }

        public String getTjrCardId() {
            return tjrCardId;
        }

        public void setTjrCardId(String tjrCardId) {
            this.tjrCardId = tjrCardId;
        }

        public String getTjrId() {
            return tjrId;
        }

        public void setTjrId(String tjrId) {
            this.tjrId = tjrId;
        }

        public Object getTxImgUrl() {
            return txImgUrl;
        }

        public void setTxImgUrl(Object txImgUrl) {
            this.txImgUrl = txImgUrl;
        }

        public Object getWxCode() {
            return wxCode;
        }

        public void setWxCode(Object wxCode) {
            this.wxCode = wxCode;
        }
    }
}
