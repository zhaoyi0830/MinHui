package com.minhuitianxia.myapplication.entity;

/**
 * 登录
 * Created by Administrator on 2016/11/7 0007.
 */
public class VipLoginEntity {


    /**
     * attributes : null
     * obj : 6225350818106666
     * msg : 验证通过。
     * jsonStr : {"obj":"6225350818106666","msg":"验证通过。","success":true}
     * success : true
     */

    private Object attributes;
    private String obj;
    private String msg;
    private String jsonStr;
    private boolean success;
    private String zhanghao;

    public String getZhanghao() {
        return zhanghao;
    }

    public void setZhanghao(String username) {
        this.zhanghao=username;
    }


    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
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
