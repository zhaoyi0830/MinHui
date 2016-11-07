package com.minhuitianxia.myapplication.entity;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class VipPasswordEntity {

    /**
     * attributes : null
     * obj : null
     * msg : 会员密码修改成功。
     * jsonStr : {"msg":"会员密码修改成功。","success":true}
     * success : true
     */

    private Object attributes;
    private Object obj;
    private String msg;
    private String jsonStr;
    private boolean success;

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
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
}
