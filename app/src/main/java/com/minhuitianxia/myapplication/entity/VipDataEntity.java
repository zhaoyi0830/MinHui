package com.minhuitianxia.myapplication.entity;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class VipDataEntity {

    /**
     * attributes : null
     * obj : {"address":"","id":"bbee85b55806ace801580a31c7c508c9","password":"c9d09aa7de301532052521dfde7c31da","hykId":"6225350818101141","hyName":"王大寅","czye":0,"jfye":7000,"delflag":null,"delDate":1572247823000,"tel":"15552223061","shState":"ok","zcdpId":"9","tcygId":"","hyState":"zc","hyLevel":"1","sex":"0","tjrName":"贾相军","csrq":159811200000,"sfz":"370611197501250313","gddh":"","tcygName":"","tjrCardId":"6225350818096155","tjrId":"2309","txImgUrl":"","wxCode":"","remark":"","email":"","updateName":"富豪银座店","createName":"富豪银座店","createBy":"fhyzd","updateBy":"fhyzd","createDate":1477639657000,"updateDate":1477639823000}
     * msg : 操作成功
     * jsonStr : {"obj":{"address":"","createBy":"fhyzd","createDate":1477639657000,"createName":"富豪银座店","csrq":159811200000,"czye":0.000000,"delDate":1572247823000,"email":"","gddh":"","hyLevel":"1","hyName":"王大寅","hyState":"zc","hykId":"6225350818101141","id":"bbee85b55806ace801580a31c7c508c9","jfye":7000.000000,"password":"c9d09aa7de301532052521dfde7c31da","remark":"","sex":"0","sfz":"370611197501250313","shState":"ok","tcygId":"","tcygName":"","tel":"15552223061","tjrCardId":"6225350818096155","tjrId":"2309","tjrName":"贾相军","txImgUrl":"","updateBy":"fhyzd","updateDate":1477639823000,"updateName":"富豪银座店","wxCode":"","zcdpId":"9"},"msg":"操作成功","success":true}
     * success : true
     */

    private Object attributes;
    /**
     * address :
     * id : bbee85b55806ace801580a31c7c508c9
     * password : c9d09aa7de301532052521dfde7c31da
     * hykId : 6225350818101141
     * hyName : 王大寅
     * czye : 0.0
     * jfye : 7000.0
     * delflag : null
     * delDate : 1572247823000
     * tel : 15552223061
     * shState : ok
     * zcdpId : 9
     * tcygId :
     * hyState : zc
     * hyLevel : 1
     * sex : 0
     * tjrName : 贾相军
     * csrq : 159811200000
     * sfz : 370611197501250313
     * gddh :
     * tcygName :
     * tjrCardId : 6225350818096155
     * tjrId : 2309
     * txImgUrl :
     * wxCode :
     * remark :
     * email :
     * updateName : 富豪银座店
     * createName : 富豪银座店
     * createBy : fhyzd
     * updateBy : fhyzd
     * createDate : 1477639657000
     * updateDate : 1477639823000
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
        private String hykId;
        private String hyName;
        private double czye;
        private double jfye;
        private Object delflag;
        private long delDate;
        private String tel;
        private String shState;
        private String zcdpId;
        private String tcygId;
        private String hyState;
        private String hyLevel;
        private String sex;
        private String tjrName;
        private long csrq;
        private String sfz;
        private String gddh;
        private String tcygName;
        private String tjrCardId;
        private String tjrId;
        private String txImgUrl;
        private String wxCode;
        private String remark;
        private String email;
        private String updateName;
        private String createName;
        private String createBy;
        private String updateBy;
        private long createDate;
        private long updateDate;

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

        public long getDelDate() {
            return delDate;
        }

        public void setDelDate(long delDate) {
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

        public String getTcygId() {
            return tcygId;
        }

        public void setTcygId(String tcygId) {
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

        public String getGddh() {
            return gddh;
        }

        public void setGddh(String gddh) {
            this.gddh = gddh;
        }

        public String getTcygName() {
            return tcygName;
        }

        public void setTcygName(String tcygName) {
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

        public String getTxImgUrl() {
            return txImgUrl;
        }

        public void setTxImgUrl(String txImgUrl) {
            this.txImgUrl = txImgUrl;
        }

        public String getWxCode() {
            return wxCode;
        }

        public void setWxCode(String wxCode) {
            this.wxCode = wxCode;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
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
    }
}
